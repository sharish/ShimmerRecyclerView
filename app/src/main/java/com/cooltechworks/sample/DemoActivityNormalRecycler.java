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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cooltechworks.sample.adapters.CardAdapter;
import com.cooltechworks.sample.utils.BaseUtils;
import com.cooltechworks.sample.utils.DemoConfiguration;

import static com.cooltechworks.sample.utils.BaseUtils.TYPE_LIST;

public class DemoActivityNormalRecycler extends AppCompatActivity {

    public static final String EXTRA_TYPE = "type";

    private RecyclerView recyclerView;
    private CardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int type = TYPE_LIST;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);

        final DemoConfiguration demoConfiguration = BaseUtils.getDemoConfiguration(type, this);
        setTheme(demoConfiguration.getStyleResource());
        setContentView(R.layout.activity_list_normal_recycler);
        setTitle(demoConfiguration.getTitleResource());

        recyclerView = findViewById(R.id.shimmer_recycler_view);


        mAdapter = new CardAdapter();
        mAdapter.setType(type);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);

        loadCards();
    }

    private void loadCards() {
        int type = TYPE_LIST;

        mAdapter.setCards(BaseUtils.getCards(getResources(), type));
        mAdapter.notifyDataSetChanged();
    }

}
