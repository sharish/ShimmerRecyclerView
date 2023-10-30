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

package com.cooltechworks.views.shimmer

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ShimmerAdapter : RecyclerView.Adapter<ShimmerViewHolder>() {

    private var mItemCount: Int = 0
    private var mLayoutReference: Int = 0
    private var mShimmerAngle: Int = 0
    private var mShimmerColor: Int = 0
    private var mShimmerDuration: Int = 0
    private var mShimmerMaskWidth: Float = 0.toFloat()
    private var isAnimationReversed: Boolean = false
    private var mShimmerItemBackground: Drawable? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShimmerViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val shimmerViewHolder = ShimmerViewHolder(inflater, parent, mLayoutReference)
        shimmerViewHolder.setShimmerColor(mShimmerColor)
        shimmerViewHolder.setShimmerAngle(mShimmerAngle)
        shimmerViewHolder.setShimmerMaskWidth(mShimmerMaskWidth)
        shimmerViewHolder.setShimmerViewHolderBackground(mShimmerItemBackground)
        shimmerViewHolder.setShimmerAnimationDuration(mShimmerDuration)
        shimmerViewHolder.setAnimationReversed(isAnimationReversed)

        return shimmerViewHolder
    }

    override fun onBindViewHolder(holder: ShimmerViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = mItemCount


    fun setMinItemCount(itemCount: Int) {
        mItemCount = itemCount
    }

    fun setShimmerAngle(shimmerAngle: Int) {
        this.mShimmerAngle = shimmerAngle
    }

    fun setShimmerColor(shimmerColor: Int) {
        this.mShimmerColor = shimmerColor
    }

    fun setShimmerMaskWidth(maskWidth: Float) {
        this.mShimmerMaskWidth = maskWidth
    }

    fun setShimmerItemBackground(shimmerItemBackground: Drawable) {
        this.mShimmerItemBackground = shimmerItemBackground
    }

    fun setShimmerDuration(mShimmerDuration: Int) {
        this.mShimmerDuration = mShimmerDuration
    }

    fun setLayoutReference(layoutReference: Int) {
        this.mLayoutReference = layoutReference
    }

    fun setAnimationReversed(animationReversed: Boolean) {
        this.isAnimationReversed = animationReversed
    }
}
