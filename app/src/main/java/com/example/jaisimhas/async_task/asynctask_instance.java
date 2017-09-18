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

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by jaisimhas on 9/14/2017.
 */

 //If the main activity undergoes onstop due to rotation of the tablet we have to take precautions to avoid memory leaks.
 //This needs to be factored in.
 
//Async task can be defined as private inner class of the Activity Class (main thread). Here
// we can call methods of the Activity Class from side onPostExectue

//Example
//public class MainActivity extends Activity {
// …...
//  static public class MyAsyncTask extends AsyncTask<Void, Void, String>   {
//     @Override protected String doInBackground(Void... params) {...}
//     @Override protected void onPostExecute(String result) {...}
// }
//}

//OR
//Async Task subclass of Async Task which is separate public class. Here we can reference main activity clas
//and use this to call methods from onPostExecute


//Async tasks are meant for short operations that need to occur in the background.
//The async task allows for background operations to be performed and then reported to the
//main activity thread.

//Async Task has 3 parameters Parameters, Progress and Resul
//Param is passed during execute method call
//progress is provided through publishProgress(Progress ..values) which will cause an update to UI thread
//context onProgressUpdate(Progress...values)
//onPostExecute will provide the oepration after doInBackground operation completes. This will trigger method call to UI Thread.
public class asynctask_instance extends AsyncTask<Integer, Void, String> {

    private MainActivity activity;

    //define the constructor
    public asynctask_instance(MainActivity context)
    {
        Log.w("MainActivity", "Constructor of asynctask_instance");
        activity = context;
    }

    protected String doInBackground(Integer ...numbers)
    {
        Log.w("MainActivity", "inside doInBackground");
        return "product from async task doinBackground function";
    }

    protected void onPostExecute (String message)
    {
        Log.w("MainActivity", "inside onPostExecute");
        activity.updateView(message);

    }


}
