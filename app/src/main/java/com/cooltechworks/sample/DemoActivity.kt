/**
 * Copyright 2017 Harish Sridharan
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cooltechworks.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.cooltechworks.sample.adapters.CardAdapter
import com.cooltechworks.sample.utils.BaseUtils
import kotlinx.android.synthetic.main.activity_grid.*


class DemoActivity : AppCompatActivity() {

    private lateinit var mAdapter: CardAdapter

    private val type: Int
        get() = intent.getIntExtra(EXTRA_TYPE, BaseUtils.TYPE_LIST)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val type = type

        val layoutManager: RecyclerView.LayoutManager

        val demoConfiguration = BaseUtils.getDemoConfiguration(type, this)
        setTheme(demoConfiguration!!.styleResource)
        setContentView(demoConfiguration.layoutResource)
        layoutManager = demoConfiguration.layoutManager!!
        setTitle(demoConfiguration.titleResource)

        if (demoConfiguration.itemDecoration != null) {
            shimmer_recycler_view.addItemDecoration(demoConfiguration.itemDecoration)
        }

        mAdapter = CardAdapter()
        mAdapter.setType(type)

        shimmer_recycler_view.layoutManager = layoutManager
        shimmer_recycler_view.adapter = mAdapter
        shimmer_recycler_view.showShimmerAdapter()

        shimmer_recycler_view.postDelayed({ loadCards() }, 3000)
    }

    private fun loadCards() {
        val type = type

        mAdapter.setCards(BaseUtils.getCards(resources, type))
        shimmer_recycler_view.hideShimmerAdapter()
    }

    companion object {
        const val EXTRA_TYPE = "type"
    }
}
