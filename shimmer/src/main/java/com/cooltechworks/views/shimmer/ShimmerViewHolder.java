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

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;

/**
 * Created by sharish on 22/11/16.
 */

public class ShimmerViewHolder extends RecyclerView.ViewHolder {

    public ShimmerViewHolder(LayoutInflater inflater, ViewGroup parent, int innerViewResId) {
        super(inflater.inflate(R.layout.viewholder_shimmer, parent, false));
        ShimmerFrameLayout layout = (ShimmerFrameLayout) itemView;

        View innerView = inflater.inflate(innerViewResId, layout, false);
        layout.addView(innerView);
        layout.setAutoStart(false);
    }

    /**
     * Binds the view
     */
    public void bind() {

        ShimmerFrameLayout layout = (ShimmerFrameLayout) itemView;
        layout.startShimmerAnimation();
    }
}
