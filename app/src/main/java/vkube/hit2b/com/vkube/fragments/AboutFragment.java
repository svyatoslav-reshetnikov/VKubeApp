package vkube.hit2b.com.vkube.fragments;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.MenuItem;

import vkube.hit2b.com.vkube.R;
import vkube.hit2b.com.vkube.activities.MainActivity;

/**
 * Created by SVYAT on 10.10.2014.
 */
public class AboutFragment extends SherlockFragment {

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

        View view = inflater.inflate(R.layout.fragment_about,
                container, false);

        Typeface tf = Typeface.createFromAsset(ma.getAssets(), "fonts/LatoRegular.ttf");

        TextView aboutTextTitle = (TextView) view.findViewById(R.id.aboutTextTitle);
        aboutTextTitle.setTypeface(tf);

        TextView aboutTextContent = (TextView) view.findViewById(R.id.aboutTextContent);
        aboutTextContent.setTypeface(tf);

        return view;
    }

}