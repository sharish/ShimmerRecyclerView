/**
 *
 * Copyright 2017 Harish Sridharan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cooltechworks.views.shimmer;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

public class ShimmerAdapter extends RecyclerView.Adapter<ShimmerViewHolder> {

    private int mItemCount;
    private int mLayoutReference;
    private int mShimmerAngle;
    private int mShimmerColor;
    private int mShimmerDuration;
    private float mShimmerMaskWidth;
    private boolean isAnimationReversed;
    private Drawable mShimmerItemBackground;

    @Override
    public ShimmerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ShimmerViewHolder shimmerViewHolder = new ShimmerViewHolder(inflater, parent, mLayoutReference);
        shimmerViewHolder.setShimmerColor(mShimmerColor);
        shimmerViewHolder.setShimmerAngle(mShimmerAngle);
        shimmerViewHolder.setShimmerMaskWidth(mShimmerMaskWidth);
        shimmerViewHolder.setShimmerViewHolderBackground(mShimmerItemBackground);
        shimmerViewHolder.setShimmerAnimationDuration(mShimmerDuration);
        shimmerViewHolder.setAnimationReversed(isAnimationReversed);

        return shimmerViewHolder;
    }

    @Override
    public void onBindViewHolder(ShimmerViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return mItemCount;
    }

    public void setMinItemCount(int itemCount) {
        mItemCount = itemCount;
    }

    public void setShimmerAngle(int shimmerAngle) {
        this.mShimmerAngle = shimmerAngle;
    }

    public void setShimmerColor(int shimmerColor) {
        this.mShimmerColor = shimmerColor;
    }

    public void setShimmerMaskWidth(float maskWidth) {
        this.mShimmerMaskWidth = maskWidth;
    }

    public void setShimmerItemBackground(Drawable shimmerItemBackground) {
        this.mShimmerItemBackground = shimmerItemBackground;
    }

    public void setShimmerDuration(int mShimmerDuration) {
        this.mShimmerDuration = mShimmerDuration;
    }

    public void setLayoutReference(int layoutReference) {
        this.mLayoutReference = layoutReference;
    }

    public void setAnimationReversed(boolean animationReversed) {
        this.isAnimationReversed = animationReversed;
    }
}
