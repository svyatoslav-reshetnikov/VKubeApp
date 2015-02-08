package vkube.hit2b.com.vkube.menu;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import vkube.hit2b.com.vkube.R;

/**
 * Created by SVYAT on 10.10.2014.
 */
public class MenuAdapter extends ArrayAdapter<MenuRowItem> {

    private Context context;
    private ArrayList<MenuRowItem> items;
    private LayoutInflater vi;

    public MenuAdapter(Context context, ArrayList<MenuRowItem> items) {
        super(context,0, items);
        this.context = context;
        this.items = items;
        vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        final MenuRowItem i = items.get(position);
        if (i != null) {
            MenuRowItem ei = (MenuRowItem)i;
            v = vi.inflate(R.layout.menu_row_item, null);

            final TextView title = (TextView)v.findViewById(R.id.list_item_row_title);
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/BebasNeueBook.ttf");
            title.setTypeface(tf);
            if (title != null) title.setText(ei.title);
        }

        return v;
    }

}