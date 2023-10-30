package com.cooltechworks.sample.utils

import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.recyclerview.widget.RecyclerView

class DemoConfiguration {
    @StyleRes
    var styleResource: Int = 0

    @LayoutRes
    var layoutResource: Int = 0

    @StringRes
    var titleResource: Int = 0

    var layoutManager: RecyclerView.LayoutManager? = null

    var itemDecoration: RecyclerView.ItemDecoration? = null
}
