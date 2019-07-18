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
package com.cooltechworks.sample.utils;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.cooltechworks.sample.R;
import com.cooltechworks.sample.models.ItemCard;
import com.cooltechworks.sample.utils.view.CardPaddingItemDecoration;

import java.util.Arrays;
import java.util.List;

public class BaseUtils {

    public static final int TYPE_LIST = 0;
    public static final int TYPE_GRID = 1;
    public static final int TYPE_SECOND_LIST = 2;
    public static final int TYPE_SECOND_GRID = 3;

    private static List<ItemCard> getListCards(Resources resources) {
        ItemCard ndtvCard = createItemCard(resources, R.string.ndtv_titletext, R.string.ndtv_image_url,
                R.string.ndtv_subtext, R.string.ndtv_summarytext);

        ItemCard opCard = createItemCard(resources, R.string.op_titletext, R.string.op_image_url,
                R.string.op_subtext, R.string.op_summarytext);

        ItemCard gotCard = createItemCard(resources, R.string.got_titletext, R.string.got_image_url,
                R.string.got_subtext, R.string.got_summarytext);

        ItemCard jetCard = createItemCard(resources, R.string.jet_titletext, R.string.jet_image_url,
                R.string.jet_subtext, R.string.jet_summarytext);

        return Arrays.asList(ndtvCard, opCard, gotCard, jetCard);
    }

    private static List<ItemCard> getGridCards(Resources resources) {
        ItemCard on7 = createItemCard(resources, R.string.on7_titletext, R.string.on7_image_url,
                R.string.on7_subtext, R.string.on7_summarytext);

        ItemCard note5 = createItemCard(resources, R.string.note5_titletext, R.string.note5_image_url,
                R.string.note5_subtext, R.string.note5_summarytext);

        ItemCard pixel = createItemCard(resources, R.string.pix_titletext, R.string.pix_image_url,
                R.string.pix_subtext, R.string.pix_summarytext);

        ItemCard iphone6 = createItemCard(resources, R.string.i6_titletext, R.string.i6_image_url,
                R.string.i6_subtext, R.string.i6_summarytext);

        ItemCard moto = createItemCard(resources, R.string.moto_titletext, R.string.moto_image_url,
                R.string.moto_subtext, R.string.moto_summarytext);

        ItemCard s7 = createItemCard(resources, R.string.s7_titletext, R.string.s7_image_url,
                R.string.s7_subtext, R.string.s7_summarytext);

        return Arrays.asList(on7, note5, pixel, iphone6, s7, moto);
    }

    public static List<ItemCard> getCards(Resources resources, int type) {
        List<ItemCard> itemCards;

        switch (type) {
            case TYPE_LIST:
            case TYPE_SECOND_LIST:
                itemCards = getListCards(resources);
                break;
            case TYPE_GRID:
            case TYPE_SECOND_GRID:
                itemCards = getGridCards(resources);
                break;
            default:
                itemCards = null;
        }

        return itemCards;
    }

    public static DemoConfiguration getDemoConfiguration(int configurationType, Context context) {
        DemoConfiguration demoConfiguration;

        switch (configurationType) {
            case TYPE_LIST:
                demoConfiguration = new DemoConfiguration();
                demoConfiguration.setStyleResource(R.style.AppTheme);
                demoConfiguration.setLayoutResource(R.layout.activity_list);
                demoConfiguration.setLayoutManager(new LinearLayoutManager(context));
                demoConfiguration.setTitleResource(R.string.ab_list_title);
                break;
            case TYPE_GRID:
                demoConfiguration = new DemoConfiguration();
                demoConfiguration.setStyleResource(R.style.AppThemeGrid);
                demoConfiguration.setLayoutResource(R.layout.activity_grid);
                demoConfiguration.setLayoutManager(new GridLayoutManager(context, 2));
                demoConfiguration.setTitleResource(R.string.ab_grid_title);
                break;
            case TYPE_SECOND_LIST:
                demoConfiguration = new DemoConfiguration();
                demoConfiguration.setStyleResource(R.style.AppTheme);
                demoConfiguration.setLayoutResource(R.layout.activity_second_list);
                demoConfiguration.setLayoutManager(new LinearLayoutManager(context));
                demoConfiguration.setTitleResource(R.string.ab_list_title);
                demoConfiguration.setItemDecoration(new CardPaddingItemDecoration(context));
                break;
            case TYPE_SECOND_GRID:
                demoConfiguration = new DemoConfiguration();
                demoConfiguration.setStyleResource(R.style.AppThemeGrid);
                demoConfiguration.setLayoutResource(R.layout.activity_second_grid);
                demoConfiguration.setLayoutManager(new GridLayoutManager(context, 2));
                demoConfiguration.setTitleResource(R.string.ab_grid_title);
                break;
            default:
                demoConfiguration = null;
        }

        return demoConfiguration;
    }

    private static ItemCard createItemCard(Resources resources, @StringRes int title, @StringRes int imageUrl,
                                           @StringRes int description, @StringRes int summary) {
        ItemCard itemCard = new ItemCard();

        itemCard.setTitle(resources.getString(title));
        itemCard.setThumbnailUrl(resources.getString(imageUrl));
        itemCard.setDescription(resources.getString(description));
        itemCard.setSummaryText(resources.getString(summary));

        return itemCard;
    }
}
