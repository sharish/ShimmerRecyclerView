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

package com.cooltechworks.views.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sharish on 22/11/16.
 */

public class ShimmerRecyclerView extends RecyclerView {

    private AdapterDataObserver mDataObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            updateEmptyView();
        }
    };

    public enum LayoutMangerType {
        LINEAR_VERTICAL, LINEAR_HORIZONTAL, GRID
    }

    private View mEmptyView;

    private ShimmerAdapter mShimmerAdapter;
    private LayoutManager mShimmerLayoutManager;

    private LayoutManager mActualLayoutManager;
    private Adapter mActualAdapter;


    private int mLayoutReference = R.layout.layout_sample_view;
    private boolean mCanScroll;
    private LayoutMangerType mLayoutMangerType = LayoutMangerType.LINEAR_VERTICAL;
    private int mGridCount = 2;

    public ShimmerRecyclerView(Context context) {
        super(context);
        init(null);
    }

    public ShimmerRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ShimmerRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        mShimmerAdapter = new ShimmerAdapter();
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ShimmerRecyclerView, 0, 0);

        int mShimmerAngle;
        int mShimmerColor;
        int mShimmerDuration;
        Drawable mShimmerItemBackground;

        try {
            if (a.hasValue(R.styleable.ShimmerRecyclerView_shimmer_demo_layout)) {
                setDemoLayoutReference(a.getResourceId(R.styleable.ShimmerRecyclerView_shimmer_demo_layout, R.layout.layout_sample_view));
            }

            if (a.hasValue(R.styleable.ShimmerRecyclerView_shimmer_demo_child_count)) {
                setDemoChildCount(a.getInteger(R.styleable.ShimmerRecyclerView_shimmer_demo_child_count, 1));
            }

            if (a.hasValue(R.styleable.ShimmerRecyclerView_shimmer_demo_layout_manager_type)) {
                int value = a.getInteger(R.styleable.ShimmerRecyclerView_shimmer_demo_layout_manager_type, 0);
                switch (value) {
                    case 1:
                        setDemoLayoutManager(LayoutMangerType.LINEAR_HORIZONTAL);
                        break;
                    case 2:
                        setDemoLayoutManager(LayoutMangerType.GRID);
                        break;
                    case 0:
                    default:
                        setDemoLayoutManager(LayoutMangerType.LINEAR_VERTICAL);
                        break;

                }
            }

            if (a.hasValue(R.styleable.ShimmerRecyclerView_shimmer_demo_grid_child_count)) {
                setGridChildCount(a.getInteger(R.styleable.ShimmerRecyclerView_shimmer_demo_grid_child_count, 2));
            }

            mShimmerAngle = a.getInteger(R.styleable.ShimmerRecyclerView_shimmer_demo_angle, 0);
            mShimmerColor = a.getColor(R.styleable.ShimmerRecyclerView_shimmer_demo_shimmer_color, getColor(R.color.default_shimmer_color));
            mShimmerItemBackground = a.getDrawable(R.styleable.ShimmerRecyclerView_shimmer_demo_view_holder_item_background);
            mShimmerDuration = a.getInteger(R.styleable.ShimmerRecyclerView_shimmer_demo_duration, 1500);
        } finally {
            a.recycle();
        }

        mShimmerAdapter.setShimmerAngle(mShimmerAngle);
        mShimmerAdapter.setShimmerColor(mShimmerColor);
        mShimmerAdapter.setShimmerItemBackground(mShimmerItemBackground);
        mShimmerAdapter.setShimmerDuration(mShimmerDuration);

        showShimmerAdapter();
    }

    /**
     * Designate a view as the empty view. When the backing adapter has no
     * data this view will be made visible and the recycler view hidden.
     *
     */
    public void setEmptyView(View emptyView) {
        mEmptyView = emptyView;
    }

    private void updateEmptyView() {
        if (mEmptyView != null && getAdapter() != null) {
            boolean showEmptyView = getAdapter().getItemCount() == 0;
            mEmptyView.setVisibility(showEmptyView ? VISIBLE : GONE);
            setVisibility(showEmptyView ? GONE : VISIBLE);
        }
    }

    /**
     * Specifies the number of child should exist in any row of the grid layout.
     *
     * @param count - count specifying the number of child.
     */
    public void setGridChildCount(int count) {
        mGridCount = count;
    }

    /**
     * Sets the layout manager for the shimmer adapter.
     *
     * @param type layout manager reference
     */
    public void setDemoLayoutManager(LayoutMangerType type) {
        mLayoutMangerType = type;

    }

    /**
     * Sets the number of demo views should be shown in the shimmer adapter.
     *
     * @param count - number of demo views should be shown.
     */
    public void setDemoChildCount(int count) {
        mShimmerAdapter.setMinItemCount(count);
    }

    /**
     * Specifies the animation duration of shimmer layout.
     *
     * @param duration - count specifying the duration of shimmer in millisecond.
     */
    public void setDemoShimmerDuration(int duration) {
        mShimmerAdapter.setShimmerDuration(duration);
    }

    /**
     * Sets the shimmer adapter and shows the loading screen.
     */
    public void showShimmerAdapter() {
        mCanScroll = false;

        if (mShimmerLayoutManager == null) {
            initShimmerManager();
        }

        setLayoutManager(mShimmerLayoutManager);
        setAdapter(mShimmerAdapter);

    }

    private void initShimmerManager() {

        switch (mLayoutMangerType) {
            case LINEAR_VERTICAL:
                mShimmerLayoutManager = new LinearLayoutManager(getContext()) {
                    public boolean canScrollVertically() {
                        return mCanScroll;
                    }
                };
                break;
            case LINEAR_HORIZONTAL:
                mShimmerLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false) {
                    public boolean canScrollHorizontally() {
                        return mCanScroll;
                    }
                };
                break;
            case GRID:
                mShimmerLayoutManager = new GridLayoutManager(getContext(), mGridCount) {
                    public boolean canScrollVertically() {
                        return mCanScroll;
                    }
                };
                break;


        }
    }

    /**
     * Hides the shimmer adapter
     */
    public void hideShimmerAdapter() {
        mCanScroll = true;
        setLayoutManager(mActualLayoutManager);
        setAdapter(mActualAdapter);
    }


    public void setLayoutManager(LayoutManager manager) {

        if (manager == null) {
            mActualLayoutManager = null;
        } else if (manager != mShimmerLayoutManager) {
            mActualLayoutManager = manager;
        }

        super.setLayoutManager(manager);
    }


    public void setAdapter(Adapter adapter) {

        if (adapter == null) {
            mActualAdapter = null;
        } else if (adapter != mShimmerAdapter) {
            mActualAdapter = adapter;
        }

        if (getAdapter() != null) {
            getAdapter().unregisterAdapterDataObserver(mDataObserver);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(mDataObserver);
        }

        super.setAdapter(adapter);

        updateEmptyView();
    }

    /**
     * Retrieves the actual adapter that contains the data set or null if no adapter is set.
     *
     * @return The actual adapter
     */
    public Adapter getActualAdapter() {
        return mActualAdapter;
    }


    public int getLayoutReference() {
        return mLayoutReference;
    }

    /**
     * Sets the demo layout reference
     *
     * @param mLayoutReference layout resource id of the layout which should be shown as demo.
     */
    public void setDemoLayoutReference(int mLayoutReference) {
        this.mLayoutReference = mLayoutReference;
        mShimmerAdapter.setLayoutReference(getLayoutReference());
    }

    private int getColor(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return getContext().getColor(id);
        } else {
            return getResources().getColor(id);
        }
    }
}
