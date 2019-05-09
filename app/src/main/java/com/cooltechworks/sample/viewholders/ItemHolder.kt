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
package com.cooltechworks.sample.viewholders

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.cooltechworks.sample.R
import com.cooltechworks.sample.models.ItemCard

import com.cooltechworks.sample.utils.BaseUtils.TYPE_GRID
import com.cooltechworks.sample.utils.BaseUtils.TYPE_LIST
import com.cooltechworks.sample.utils.BaseUtils.TYPE_SECOND_GRID
import com.cooltechworks.sample.utils.BaseUtils.TYPE_SECOND_LIST

class ItemHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val mTitleView: TextView = itemView.findViewById(R.id.card_title)
    private val mDescView: TextView = itemView.findViewById(R.id.card_subtitle)
    private val mThumbnailView: ImageView = itemView.findViewById(R.id.card_image)
    private val mSummaryView: TextView = itemView.findViewById(R.id.card_summary)

    fun bind(card: ItemCard) {
        mTitleView.text = card.title
        mDescView.text = card.description
        mSummaryView.text = card.summaryText

        Glide.with(itemView.context).load(card.thumbnailUrl).into(mThumbnailView)
    }

    companion object {

        fun newInstance(container: ViewGroup, type: Int): ItemHolder {
            val root = LayoutInflater.from(container.context).inflate(getLayoutResourceId(type),
                    container, false)

            return ItemHolder(root)
        }

        private fun getLayoutResourceId(type: Int): Int {
            return when (type) {
                TYPE_LIST -> R.layout.layout_news_card
                TYPE_SECOND_LIST -> R.layout.layout_second_news_card
                TYPE_GRID, TYPE_SECOND_GRID -> R.layout.layout_ecom_item
                else -> 0
            }
        }
    }
}
