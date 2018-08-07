/**
 * Copyright 2017 Harish Sridharan
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cooltechworks.sample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cooltechworks.sample.adapters.CardAdapter;
import com.cooltechworks.sample.utils.BaseUtils;
import com.cooltechworks.sample.utils.DemoConfiguration;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import static com.cooltechworks.sample.utils.BaseUtils.TYPE_LIST;

public class MainFragment extends Fragment {

    private ShimmerRecyclerView shimmerRecycler;
    private CardAdapter mAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        DemoConfiguration demoConfiguration = BaseUtils.getDemoConfiguration(TYPE_LIST, getActivity());
        return inflater.inflate(demoConfiguration.getLayoutResource(), viewGroup, false);
    }

    public void onViewCreated(View rootView, Bundle savedInstanceState) {


        RecyclerView.LayoutManager layoutManager;

        DemoConfiguration demoConfiguration = BaseUtils.getDemoConfiguration(TYPE_LIST, getActivity());
        layoutManager = demoConfiguration.getLayoutManager();

        shimmerRecycler = rootView.findViewById(R.id.shimmer_recycler_view);

        if (demoConfiguration.getItemDecoration() != null) {
            shimmerRecycler.addItemDecoration(demoConfiguration.getItemDecoration());
        }

        mAdapter = new CardAdapter();
        mAdapter.setType(TYPE_LIST);
        mAdapter.mItemClickListener = new CardAdapter.OnItemClickListener() {
            @Override
            public void onClick(CardAdapter adapter, int position) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        };

        shimmerRecycler.setLayoutManager(layoutManager);
        shimmerRecycler.setAdapter(mAdapter);
        shimmerRecycler.showShimmerAdapter();

        shimmerRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadCards();
            }
        }, 3000);
    }

    private void loadCards() {

        mAdapter.setCards(BaseUtils.getCards(getResources(), TYPE_LIST));
        shimmerRecycler.hideShimmerAdapter();
    }
}
