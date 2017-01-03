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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cooltechworks.sample.adapters.CardAdapter;
import com.cooltechworks.sample.utils.BaseUtils;
import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

public class DemoActivity extends AppCompatActivity {

    public static final String EXTRA_TYPE = "type";

    private ShimmerRecyclerView shimmerRecycler;
    private CardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int type = getType();

        RecyclerView.LayoutManager layoutManager;

        if (type == BaseUtils.TYPE_LIST) {
            setTheme(R.style.AppTheme);
            setContentView(R.layout.activity_list);
            layoutManager = new LinearLayoutManager(this);
            setTitle(R.string.ab_list_title);

        } else {
            setTheme(R.style.AppThemeGrid);
            setContentView(R.layout.activity_grid);
            layoutManager = new GridLayoutManager(this, 2);
            setTitle(R.string.ab_grid_title);

        }

        shimmerRecycler = (ShimmerRecyclerView) findViewById(R.id.shimmer_recycler_view);


        mAdapter = new CardAdapter();
        mAdapter.setType(type);

        shimmerRecycler.setLayoutManager(layoutManager);
        shimmerRecycler.setAdapter(mAdapter);
        shimmerRecycler.showShimmerAdapter();

        shimmerRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadCards();
            }
        }, 2000);

    }

    private void loadCards() {

        int type = getType();

        mAdapter.setCards(BaseUtils.getCards(getResources(), type));
        shimmerRecycler.hideShimmerAdapter();

    }

    private int getType() {
        return getIntent().getIntExtra(EXTRA_TYPE, BaseUtils.TYPE_LIST);
    }
}
