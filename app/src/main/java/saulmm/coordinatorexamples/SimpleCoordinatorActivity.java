package saulmm.coordinatorexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;

public class SimpleCoordinatorActivity extends AppCompatActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_coordinator);

		CollapsingToolbarLayout collapsingToolbarLayout =
			(CollapsingToolbarLayout) findViewById(R.id.main_collapsing);

		collapsingToolbarLayout.setTitle(getString(R.string.app_name));
	}

	public static void start(Context c) {
		c.startActivity(new Intent(c, SimpleCoordinatorActivity.class));
	}
}
