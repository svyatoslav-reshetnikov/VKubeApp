package vkube.hit2b.com.vkube.data.factory;

import android.os.Bundle;
import android.util.Log;

import com.foxykeep.datadroid.exception.DataException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import vkube.hit2b.com.vkube.data.model.Announcement;
import vkube.hit2b.com.vkube.data.model.Announcements;
import vkube.hit2b.com.vkube.network.VKubeRequestFactory;
import vkube.hit2b.com.vkube.utils.JSONTags;

/**
 * Created by svyat on 07.02.15.
 */
public class AnnouncementsJsonFactory {

    private static final String TAG = AnnouncementsJsonFactory.class.getSimpleName();

    private AnnouncementsJsonFactory() {

    }

    public static Bundle parseResult(String wsResponse) throws DataException {

        Announcements announcements = new Announcements();

        try {
            JSONObject response = new JSONObject(wsResponse);
            announcements.result = response.getString(JSONTags.ANNOUNCEMENTS_RESULT);
            if (announcements.result.equals("success")) {
                JSONArray announcementsJSONArray = response.getJSONArray(JSONTags.ANNOUNCEMENTS_ANNOUNCEMENTS);
                ArrayList<Announcement> announcementArrayList = new ArrayList<Announcement>();
                int size = announcementsJSONArray.length();
                for (int i = 0; i < size; i++) {
                    JSONObject jsonAnnouncement = announcementsJSONArray.getJSONObject(i);
                    Announcement announcement = new Announcement();

                    announcement.name = jsonAnnouncement.getString(JSONTags.ANNOUNCEMENT_NAME);
                    announcement.date = jsonAnnouncement.getString(JSONTags.ANNOUNCEMENT_DATE);
                    announcement.description = jsonAnnouncement.getString(JSONTags.ANNOUNCEMENT_DESCRIPTION);
                    JSONArray announcementImages = jsonAnnouncement.getJSONArray(JSONTags.ANNOUNCEMENT_IMAGES);
                    ArrayList<String> imagesArrayList = new ArrayList<String>();
                    if (announcementImages.length() > 0) {
                        for (int j = 0; j < announcementImages.length(); j++) {
                            JSONObject imageJSON = announcementImages.getJSONObject(j);
                            imagesArrayList.add(imageJSON.getString(JSONTags.ANNOUNCEMENT_IMAGES_URL));
                        }
                        announcement.images = imagesArrayList;
                    } else announcement.images = null;

                    announcementArrayList.add(announcement);
                }
                announcements.announcements = announcementArrayList;
            }
            else announcements.announcements = null;
        } catch (JSONException e) {
            Log.e(TAG, "JSONException", e);
            throw new DataException(e);
        }

        Bundle bundle = new Bundle();
        bundle.putParcelable(VKubeRequestFactory.BUNDLE_EXTRA_ANNOUNCEMENTS, announcements);
        return bundle;
    }

}