package vkube.hit2b.com.vkube.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import vkube.hit2b.com.vkube.R;
import vkube.hit2b.com.vkube.data.model.Announcements;

/**
 * Created by svyat on 12.02.15.
 */
public class AnnouncementsAdapter extends BaseAdapter {

    Context context;
    LayoutInflater lInflater;
    Announcements announcements;

    public AnnouncementsAdapter (Context context, Announcements announcements) {
        this.context = context;
        this.announcements = announcements;
        lInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return announcements.announcements.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.announcement_item, parent, false);
        }

        TextView dateText = (TextView) view.findViewById(R.id.date);
        TextView descriptionText = (TextView) view.findViewById(R.id.description);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
        try {
            date = dateFormat.parse(announcements.announcements.get(position).date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            SimpleDateFormat announceFormat = new SimpleDateFormat("dd.MM");
            dateText.setText(announceFormat.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        descriptionText.setText(announcements.announcements.get(position).name);

        return view;
    }
}