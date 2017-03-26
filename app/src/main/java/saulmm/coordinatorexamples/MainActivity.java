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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	private static final String GITHUB_REPO_URL = "https://github.com/saulmm/CoordinatorExamples";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
		toolbar.inflateMenu(R.menu.main);
		toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
			@Override public boolean onMenuItemClick(MenuItem item) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(GITHUB_REPO_URL));
				startActivity(browserIntent);
				return true;
			}
		});

		findViewById(R.id.main_coordinator_textview).setOnClickListener(this);
		findViewById(R.id.main_materialup_textview).setOnClickListener(this);
		findViewById(R.id.main_ioexample_textview).setOnClickListener(this);
		findViewById(R.id.main_space_textview).setOnClickListener(this);
		findViewById(R.id.main_swipebehavior_textview).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.main_coordinator_textview:
				SimpleCoordinatorActivity.start(this);
				break;

			case R.id.main_ioexample_textview:
				IOActivityExample.start(this);
				break;

			case R.id.main_space_textview:
				FlexibleSpaceExampleActivity.start(this);
				break;

			case R.id.main_materialup_textview:
				MaterialUpConceptActivity.start(this);
				break;

			case R.id.main_swipebehavior_textview:
				SwipeBehaviorExampleActivity.start(this);
				break;
		}
	}
}
