package vkube.hit2b.com.vkube.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

import vkube.hit2b.com.vkube.R;
import vkube.hit2b.com.vkube.activities.MainActivity;

/**
 * Created by SVYAT on 13.10.2014.
 */
public class OrderFragment extends SherlockFragment {

    MainActivity ma;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ma = (MainActivity) getActivity();

        View view = inflater.inflate(R.layout.fragment_order,
                container, false);

        return view;
    }
}