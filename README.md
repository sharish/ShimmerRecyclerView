# ShimmerRecyclerView


Intro
------

A custom recycler view with shimmer views to indicate that views are loading. The recycler view has a built-in adapter to control the shimmer appearance and provide two methods -

* showShimmerAdapter() - set up a demo adapter a predefined number of child demo views.
* hideShimmerAdapter() - restores your adapter to show the actual child elements.

    
Demo Screen
------    

|     List Demo                |        Grid Demo              | 
| ----------------------------  | ----------------------------- | 
| <img src='screenshots/list_demo.gif' height=444 width=250 /> | <img src='screenshots/grid_demo.gif' height=444 width=250 />   |

### Attributes and Methods

Following are the attributes and methods to initialise the demo views.

| XML Attributes | Java Methods | Explanation |
| -------------  | ------------ | ----------- | 
|```app:demo_child_count``` | ```setDemoChildCount(int)``` | Integer value that sets the number of demo views should be present in shimmer adapter |
|```app:demo_layout``` | ```setDemoLayoutReference(int)``` | Layout reference to your demo view. Define your my_demo_view.xml and refer the layout reference here. |
|```app:demo_layout_manager_type``` | ```setDemoLayoutManager(LayoutManagerType)``` | Layout manager of demo view. Can be one among linear_veritical or linear_horizontal or grid. |



Usage
--------

Define your xml as:

```xml
<com.cooltechworks.views.shimmer.ShimmerRecyclerView
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:demo_child_count="10"
        app:demo_grid_child_count="2"
        app:demo_layout="@layout/layout_demo_grid"
        app:demo_layout_manager_type="grid"
        />

```
where ```@layout/layout_demo_grid``` refers to your sample layout that should be shown during loading spinner. Now on your activity onCreate, initialize the shimmer as below:

```java
ShimmerRecyclerView shimmerRecycler = (ShimmerRecyclerView) findViewById(R.id.shimmer_recycler_view);
shimmerRecycler.showShimmerAdapter();
```

Adding to your project
------------------------

- Add the following configuration in your build.gradle file.

```gradle
repositories {
    jcenter()
    maven { url "https://jitpack.io" }
}

dependencies {
    compile 'com.github.cooltechworks:ScratchView:v1.1'
}
```

Developed By
------------

* Harish Sridharan - <harish.sridhar@gmail.com>


Acknowledgements
----------------

* Facebook for <a href="https://github.com/facebook/shimmer-android">Shimmer Android</a> which lies as a base for this repo.

License
--------
The repo is released under following licenses

<a href="LICENSE.md">Apache License</a> for ShimmerRecycler<br>
<a href="FACEBOOK_LICENSE.md">BSD License</a> for Facebook's Shimmer-Android




