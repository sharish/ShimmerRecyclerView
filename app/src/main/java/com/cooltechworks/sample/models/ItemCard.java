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
package com.cooltechworks.sample.models;

/**
 * Created by sharish on 27/12/16.
 */

public class ItemCard {

    private String mTitle;
    private String mDescription;
    private String mThumbnailUrl;
    private String mSummaryText;

    public ItemCard(String mTitle, String mDescription, String mThumbnailUrl, String mSummaryText) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mThumbnailUrl = mThumbnailUrl;
        this.mSummaryText = mSummaryText;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getThumbnailUrl() {
        return mThumbnailUrl;
    }

    public String getSummaryText() {
        return mSummaryText;
    }

}
