package saulmm.coordinatorexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IoExampleFragment extends Fragment {

	private View mRootView;
	private CollapsingToolbarLayout mCollapsingToolbarLayout;

	@Nullable @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {

		mRootView = inflater.inflate(R.layout.fragment_io_detail, container, false);
		return mRootView;
	}

	public static IoExampleFragment newInstance () {
		return new IoExampleFragment();
	}
}
