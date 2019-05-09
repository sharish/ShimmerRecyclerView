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
import android.os.Build
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import io.supercharge.shimmerlayout.ShimmerLayout

class ShimmerViewHolder(inflater: LayoutInflater, parent: ViewGroup, innerViewResId: Int) : RecyclerView.ViewHolder(inflater.inflate(R.layout.viewholder_shimmer, parent, false)) {

    private val mShimmerLayout: ShimmerLayout = itemView as ShimmerLayout

    init {
        inflater.inflate(innerViewResId, mShimmerLayout, true)
    }

    fun setShimmerAngle(angle: Int) {
        mShimmerLayout.setShimmerAngle(angle)
    }

    fun setShimmerColor(color: Int) {
        mShimmerLayout.setShimmerColor(color)
    }

    fun setShimmerMaskWidth(maskWidth: Float) {
        mShimmerLayout.setMaskWidth(maskWidth)
    }

    fun setShimmerViewHolderBackground(viewHolderBackground: Drawable?) {
        if (viewHolderBackground != null) {
            setBackground(viewHolderBackground)
        }
    }

    fun setShimmerAnimationDuration(duration: Int) {
        mShimmerLayout.setShimmerAnimationDuration(duration)
    }

    fun setAnimationReversed(animationReversed: Boolean) {
        mShimmerLayout.setAnimationReversed(animationReversed)
    }

    fun bind() {
        mShimmerLayout.startShimmerAnimation()
    }

    private fun setBackground(background: Drawable) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            mShimmerLayout.background = background
        } else {
            mShimmerLayout.setBackgroundDrawable(background)
        }
    }
}
