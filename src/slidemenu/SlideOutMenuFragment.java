package slidemenu;

import com.theteachermate.app.ChildrenFragment;
import com.theteachermate.app.ColorFragment;
import com.theteachermate.app.FilesFragment;
import com.theteachermate.app.FragmentChangeActivity;
import com.theteachermate.app.HomeMenuFragment;
import com.theteachermate.app.ObservationsFragment;
import com.theteachermate.app.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SlideOutMenuFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) 
	{
		super.onActivityCreated(savedInstanceState);
		String[] colors = getResources().getStringArray(R.array.menu_items);
		
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, colors);
		
		setListAdapter(colorAdapter);
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
			newContent = new HomeMenuFragment();
			break;
		case 1:
			newContent = new ObservationsFragment();
			break;
		case 2:
			newContent = new FilesFragment();
			break;
		case 3:
			newContent = new ChildrenFragment();
			break;
		}
		if (newContent != null)
			switchFragment(newContent);
	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof FragmentChangeActivity) {
			FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
			fca.switchContent(fragment);
		}
	}


}