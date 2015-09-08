package saulmm.coordinatorexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimpleCoordinatorFragment extends Fragment {

	private View mRootView;
	private CollapsingToolbarLayout mCollapsingToolbarLayout;

	@Nullable @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {

		mRootView = inflater.inflate(R.layout.fragment_simple_coordinator, container, false);
		return mRootView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		bindViews();
	}

	private void bindViews() {
		mCollapsingToolbarLayout = (CollapsingToolbarLayout) mRootView.findViewById(R.id.main_collapsing);
		mCollapsingToolbarLayout.setTitle(getString(R.string.app_name));
	}

	public static SimpleCoordinatorFragment newInstance () {
		return new SimpleCoordinatorFragment();
	}
}
