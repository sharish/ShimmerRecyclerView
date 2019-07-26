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
package com.cooltechworks.sample.viewholders;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cooltechworks.sample.R;
import com.cooltechworks.sample.models.ItemCard;

import static com.cooltechworks.sample.utils.BaseUtils.TYPE_GRID;
import static com.cooltechworks.sample.utils.BaseUtils.TYPE_LIST;
import static com.cooltechworks.sample.utils.BaseUtils.TYPE_SECOND_GRID;
import static com.cooltechworks.sample.utils.BaseUtils.TYPE_SECOND_LIST;

public class ItemHolder extends RecyclerView.ViewHolder {

    private TextView mTitleView;
    private TextView mDescView;
    private ImageView mThumbnailView;
    private TextView mSummaryView;

    public static ItemHolder newInstance(ViewGroup container, int type) {
        View root = LayoutInflater.from(container.getContext()).inflate(getLayoutResourceId(type),
                container, false);

        return new ItemHolder(root);
    }

    private ItemHolder(View itemView) {
        super(itemView);

        mTitleView =  itemView.findViewById(R.id.card_title);
        mDescView =  itemView.findViewById(R.id.card_subtitle);
        mSummaryView =  itemView.findViewById(R.id.card_summary);
        mThumbnailView = itemView.findViewById(R.id.card_image);
    }

    public void bind(ItemCard card) {
        mTitleView.setText(card.getTitle());
        mDescView.setText(card.getDescription());
        mSummaryView.setText(card.getSummaryText());

        Glide.with(itemView.getContext()).load(card.getThumbnailUrl()).into(mThumbnailView);
    }

    private static int getLayoutResourceId(int type) {
        int selectedLayoutResource;
        switch (type) {
            case TYPE_LIST:
                selectedLayoutResource = R.layout.layout_news_card;
                break;
            case TYPE_SECOND_LIST:
                selectedLayoutResource = R.layout.layout_second_news_card;
                break;
            case TYPE_GRID:
            case TYPE_SECOND_GRID:
                selectedLayoutResource = R.layout.layout_ecom_item;
                break;
            default:
                selectedLayoutResource = 0;
        }

        return selectedLayoutResource;
    }
}
