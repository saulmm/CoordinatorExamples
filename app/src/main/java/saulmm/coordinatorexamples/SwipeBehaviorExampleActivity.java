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
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class SwipeBehaviorExampleActivity extends AppCompatActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_behavior);


		final SwipeDismissBehavior swipe = new SwipeDismissBehavior();
		swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_ANY);
		swipe.setListener(new SwipeDismissBehavior.OnDismissListener() {
			@Override public void onDismiss(View view) {
				Toast.makeText(SwipeBehaviorExampleActivity.this,
					"Card swiped !!", Toast.LENGTH_SHORT).show();
			}

			@Override public void onDragStateChanged(int state) {}
		});

		CardView cardView = (CardView) findViewById(R.id.swype_card);
		LayoutParams coordinatorParams = (LayoutParams) cardView.getLayoutParams();
		coordinatorParams.setBehavior(swipe);
	}

	public static void start(Context c) {
		c.startActivity(new Intent(c, SwipeBehaviorExampleActivity.class));
	}
}
