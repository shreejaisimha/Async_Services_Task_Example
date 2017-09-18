/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.jaisimhas.async_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


//Async tasks are meant for short operations that need to occur in the background.
//The async task allows for background operations to be performed and then reported to the
//main activity thread.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.w("MainActivity", "Creating an instance of the Async Task");
        asynctask_instance task = new asynctask_instance(this); //pass this for the current context
        Log.w("MainActivity", "Starting the Async Task");
        task.execute(1);
        Log.w("MainActivity", "Started the Async Task");
    }

    public void updateView(String s)
    {
        Log.w("MainActivity","inside the updateView");
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(s);
    }
}
