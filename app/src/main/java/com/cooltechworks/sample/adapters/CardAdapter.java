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
package com.cooltechworks.sample.adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.ViewGroup;

import com.cooltechworks.sample.models.ItemCard;
import com.cooltechworks.sample.utils.BaseUtils;
import com.cooltechworks.sample.viewholders.ItemHolder;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<ItemHolder> {

    private List<ItemCard> mCards = new ArrayList<>();
    private int mType = BaseUtils.TYPE_LIST;

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ItemHolder.newInstance(parent, mType);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.bind(mCards.get(position));
    }

    @Override
    public int getItemCount() {
        return mCards.size();
    }

    public void setCards(List<ItemCard> cards) {
        if (cards == null) {
            return;
        }

        mCards = cards;
    }

    public void setType(int type) {
        this.mType = type;
    }
}
