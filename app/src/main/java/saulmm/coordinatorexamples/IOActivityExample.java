/*
 * Copyright (C) 2017
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
package saulmm.coordinatorexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class IOActivityExample extends AppCompatActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_io_detail);

		Toolbar toolbar = (Toolbar) findViewById(R.id.ioexample_toolbar);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				onBackPressed();
			}
		});
	}

	public static void start(Context c) {
		c.startActivity(new Intent(c, IOActivityExample.class));
	}}
