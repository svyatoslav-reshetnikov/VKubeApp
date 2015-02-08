package vkube.hit2b.com.vkube.menu;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import vkube.hit2b.com.vkube.activities.BaseActivity;
import vkube.hit2b.com.vkube.R;
import vkube.hit2b.com.vkube.activities.MainActivity;

/**
 * Created by SVYAT on 10.10.2014.
 */
public class MenuListFragment extends ListFragment {

    View headerView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        headerView = inflater.inflate(R.layout.menu_list_header, null);
        return inflater.inflate(R.layout.menu_list , null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        if (headerView != null){
            getListView().addHeaderView(headerView, null, false);
            getListView().setHeaderDividersEnabled(false);
        }

        ArrayList<MenuRowItem> items = new ArrayList<MenuRowItem>();

        items.add(new MenuRowItem(getResources().getString(R.string.announcements)));
        items.add(new MenuRowItem(getResources().getString(R.string.reports)));
        items.add(new MenuRowItem(getResources().getString(R.string.videos)));
        items.add(new MenuRowItem(getResources().getString(R.string.order)));
        items.add(new MenuRowItem(getResources().getString(R.string.about)));

        MenuAdapter adapter = new MenuAdapter(getActivity(), items);

        setListAdapter(adapter);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView lv, View v, int position, long id) {
        if (getActivity() == null)
            return;

        if (getActivity() instanceof MainActivity) {
            MainActivity ma = (MainActivity) getActivity();
            ma.switchContent(position);
        }
    }

}
