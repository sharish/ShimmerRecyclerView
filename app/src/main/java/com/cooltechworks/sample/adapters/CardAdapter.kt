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
package com.cooltechworks.sample.adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.cooltechworks.sample.models.ItemCard
import com.cooltechworks.sample.utils.BaseUtils
import com.cooltechworks.sample.viewholders.ItemHolder
import java.util.*

class CardAdapter : RecyclerView.Adapter<ItemHolder>() {

    private var mCards: List<ItemCard> = ArrayList()
    private var mType = BaseUtils.TYPE_LIST

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder.newInstance(parent, mType)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(mCards[position])
    }

    override fun getItemCount() = mCards.size


    fun setCards(cards: List<ItemCard>?) {
        if (cards == null) {
            return
        }

        mCards = cards
    }

    fun setType(type: Int) {
        this.mType = type
    }
}
