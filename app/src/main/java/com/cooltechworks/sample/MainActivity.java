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

package com.cooltechworks.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.cooltechworks.sample.utils.BaseUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button shimmerRecyclerViewButton = findViewById(R.id.list_demo_button);
        final Button normalRecyclerViewButton = findViewById(R.id.list_demo_button_normal);

        shimmerRecyclerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,  DemoActivity.class);
                intent.putExtra(DemoActivity.EXTRA_TYPE, BaseUtils.TYPE_LIST);
                startActivity(intent);
            }
        });

        normalRecyclerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,  DemoActivityNormalRecycler.class);
                intent.putExtra(DemoActivity.EXTRA_TYPE, BaseUtils.TYPE_LIST);
                startActivity(intent);
            }
        });
    }
}
