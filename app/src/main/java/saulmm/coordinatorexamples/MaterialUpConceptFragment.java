package saulmm.coordinatorexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

@SuppressWarnings("FieldCanBeLocal")
public class MaterialUpConceptFragment extends Fragment
	implements AppBarLayout.OnOffsetChangedListener {

	private static final int PERCENTAGE_TO_ANIMATE_AVATAR = 20;
	private boolean mIsAvatarShown = true;

	private View mRootView;
	private ViewPager mViewPager;
	private TabLayout mTabLayout;
	private AppBarLayout mAppbarLayout;
	private ImageView mProfileImage;
	private int mMaxScrollSize;

	@Nullable @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.fragment_material_up_concept, container, false);
		return mRootView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		bindViews();
		initViewPagerWithTabs();
	}

	private void bindViews() {
		mTabLayout 		= (TabLayout) mRootView.findViewById(R.id.materialup_tabs);
		mViewPager 		= (ViewPager) mRootView.findViewById(R.id.materialup_viewpager);
		mAppbarLayout 	= (AppBarLayout) mRootView.findViewById(R.id.materialup_appbar);
		mProfileImage 	= (ImageView) mRootView.findViewById(R.id.materialup_profile_image);

		mAppbarLayout.addOnOffsetChangedListener(this);
		mMaxScrollSize = mAppbarLayout.getTotalScrollRange();
	}

	private void initViewPagerWithTabs() {
		mViewPager.setAdapter(new TabsAdapter(getActivity().getSupportFragmentManager()));
		mTabLayout.setupWithViewPager(mViewPager);
	}

	public static MaterialUpConceptFragment newInstance () {
		return new MaterialUpConceptFragment();
	}

	@Override
	public void onOffsetChanged(AppBarLayout appBarLayout, int i) {

		if (mMaxScrollSize == 0)
			mMaxScrollSize = appBarLayout.getTotalScrollRange();

		int percentage = (Math.abs(i)) * 100 / mMaxScrollSize;

		System.out.println("[DEBUG]" + " MaterialUpConceptFragment onOffsetChanged - " +
		    "Percentage: "+percentage + " mIsAvatarShown: " + mIsAvatarShown);

		if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
			mIsAvatarShown = false;
			mProfileImage.animate().scaleY(0).scaleX(0).setDuration(200).start();
		}


		if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
			mIsAvatarShown = true;

			mProfileImage.animate()
				.scaleY(1).scaleX(1)
				.start();
		}
	}

	class TabsAdapter extends FragmentPagerAdapter {
		public TabsAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public int getCount() {
			return 2;
		}

		@Override
		public Fragment getItem(int i) {
			switch(i) {
				case 0: return MaterialUpConceptFakePage.newInstance();
				case 1: return MaterialUpConceptFakePage.newInstance();
			}
			return null;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch(position) {
				case 0: return "Listing";
				case 1: return "Favorites";
			}
			return "";
		}
	}

}
