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

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

