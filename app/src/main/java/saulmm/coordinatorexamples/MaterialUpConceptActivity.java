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
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class MaterialUpConceptActivity extends AppCompatActivity
	implements AppBarLayout.OnOffsetChangedListener {

	private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
	private boolean mIsAvatarShown = true;

	private ImageView mProfileImage;
	private int mMaxScrollSize;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_material_up_concept);

		TabLayout tabLayout = (TabLayout) findViewById(R.id.materialup_tabs);
		ViewPager viewPager  = (ViewPager) findViewById(R.id.materialup_viewpager);
		AppBarLayout appbarLayout = (AppBarLayout) findViewById(R.id.materialup_appbar);
		mProfileImage = (ImageView) findViewById(R.id.materialup_profile_image);

		Toolbar toolbar = (Toolbar) findViewById(R.id.materialup_toolbar);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				onBackPressed();
			}
		});

		appbarLayout.addOnOffsetChangedListener(this);
		mMaxScrollSize = appbarLayout.getTotalScrollRange();

		viewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));
		tabLayout.setupWithViewPager(viewPager);
	}

	public static void start(Context c) {
		c.startActivity(new Intent(c, MaterialUpConceptActivity.class));
	}

	@Override
	public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
		if (mMaxScrollSize == 0)
			mMaxScrollSize = appBarLayout.getTotalScrollRange();

		int percentage = (Math.abs(i)) * 100 / mMaxScrollSize;

		if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
			mIsAvatarShown = false;

			mProfileImage.animate()
				.scaleY(0).scaleX(0)
				.setDuration(200)
				.start();
		}

		if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
			mIsAvatarShown = true;

			mProfileImage.animate()
				.scaleY(1).scaleX(1)
				.start();
		}
	}

	private static class TabsAdapter extends FragmentPagerAdapter {
		private static final int TAB_COUNT = 2;

		TabsAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return TAB_COUNT;
		}

		@Override
		public Fragment getItem(int i) {
			return FakePageFragment.newInstance();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return "Tab " + String.valueOf(position);
		}
	}
}
