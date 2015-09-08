package saulmm.coordinatorexamples;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import saulmm.coordinatorexamples.R;

public class FakePageAdapter extends RecyclerView.Adapter<FakePageVH> {

	private final int numItems;

	public FakePageAdapter(int numItems) {
		this.numItems = numItems;
	}

	@Override public FakePageVH onCreateViewHolder(ViewGroup viewGroup, int i) {

		View itemView = LayoutInflater.from(viewGroup.getContext())
			.inflate(R.layout.list_item_card, viewGroup, false);

		return new FakePageVH(itemView);
	}

	@Override
	public void onBindViewHolder(FakePageVH fakePageVH, int i) {
		// do nothing
	}

	@Override public int getItemCount() {
		return numItems;
	}
}

