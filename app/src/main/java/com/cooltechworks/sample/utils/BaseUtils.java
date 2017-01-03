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

import android.content.res.Resources;

import com.cooltechworks.sample.R;
import com.cooltechworks.sample.models.ItemCard;

/**
 * Created by sharish on 27/12/16.
 */

public class BaseUtils {

    public static final int TYPE_LIST = 0, TYPE_GRID = 1;

    private static ItemCard[] getListCards(Resources resources) {

        String title = resources.getString(R.string.ndtv_titletext);
        String image = resources.getString(R.string.ndtv_image_url);
        String desc = resources.getString(R.string.ndtv_subtext);
        String summary = resources.getString(R.string.ndtv_summarytext);

        ItemCard ndtvCard = new ItemCard(title, desc, image, summary);

        title = resources.getString(R.string.op_titletext);
        image = resources.getString(R.string.op_image_url);
        desc = resources.getString(R.string.op_subtext);
        summary = resources.getString(R.string.op_summarytext);

        ItemCard opCard = new ItemCard(title, desc, image, summary);


        title = resources.getString(R.string.got_titletext);
        image = resources.getString(R.string.got_image_url);
        desc = resources.getString(R.string.got_subtext);
        summary = resources.getString(R.string.got_summarytext);

        ItemCard gotCard = new ItemCard(title, desc, image, summary);

        title = resources.getString(R.string.jet_titletext);
        image = resources.getString(R.string.jet_image_url);
        desc = resources.getString(R.string.jet_subtext);
        summary = resources.getString(R.string.jet_summarytext);

        ItemCard jetCard = new ItemCard(title, desc, image, summary);

        return new ItemCard[]{ndtvCard, opCard, gotCard, jetCard};

    }

    private static ItemCard[] getGridCards(Resources resources) {

        String title = resources.getString(R.string.on7_titletext);
        String image = resources.getString(R.string.on7_image_url);
        String desc = resources.getString(R.string.on7_subtext);
        String summary = resources.getString(R.string.on7_summarytext);

        ItemCard on7 = new ItemCard(title, desc, image, summary);


        title = resources.getString(R.string.note5_titletext);
        image = resources.getString(R.string.note5_image_url);
        desc = resources.getString(R.string.note5_subtext);
        summary = resources.getString(R.string.note5_summarytext);

        ItemCard note5 = new ItemCard(title, desc, image, summary);

        title = resources.getString(R.string.pix_titletext);
        image = resources.getString(R.string.pix_image_url);
        desc = resources.getString(R.string.pix_subtext);
        summary = resources.getString(R.string.pix_summarytext);

        ItemCard pixel = new ItemCard(title, desc, image, summary);

        title = resources.getString(R.string.i6_titletext);
        image = resources.getString(R.string.i6_image_url);
        desc = resources.getString(R.string.i6_subtext);
        summary = resources.getString(R.string.i6_summarytext);

        ItemCard iphone6 = new ItemCard(title, desc, image, summary);


        title = resources.getString(R.string.moto_titletext);
        image = resources.getString(R.string.moto_image_url);
        desc = resources.getString(R.string.moto_subtext);
        summary = resources.getString(R.string.moto_summarytext);

        ItemCard moto = new ItemCard(title, desc, image, summary);


        title = resources.getString(R.string.s7_titletext);
        image = resources.getString(R.string.s7_image_url);
        desc = resources.getString(R.string.s7_subtext);
        summary = resources.getString(R.string.s7_summarytext);

        ItemCard s7 = new ItemCard(title, desc, image, summary);

        return new ItemCard[]{on7, note5, pixel, iphone6, s7, moto};

    }

    public static ItemCard[] getCards(Resources resources, int type) {
        return type == TYPE_LIST ? getListCards(resources) : getGridCards(resources);
    }
}
