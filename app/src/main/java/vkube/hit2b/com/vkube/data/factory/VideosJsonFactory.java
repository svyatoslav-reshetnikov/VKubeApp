package vkube.hit2b.com.vkube.data.factory;

import android.os.Bundle;
import android.util.Log;

import com.foxykeep.datadroid.exception.DataException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import vkube.hit2b.com.vkube.data.model.Report;
import vkube.hit2b.com.vkube.data.model.Reports;
import vkube.hit2b.com.vkube.data.model.Video;
import vkube.hit2b.com.vkube.data.model.Videos;
import vkube.hit2b.com.vkube.network.VKubeRequestFactory;
import vkube.hit2b.com.vkube.utils.JSONTags;

/**
 * Created by svyat on 07.02.15.
 */
public class VideosJsonFactory {

    private static final String TAG = VideosJsonFactory.class.getSimpleName();

    private VideosJsonFactory() {

    }

    public static Bundle parseResult(String wsResponse) throws DataException {

        Videos videos = new Videos();

        try {
            JSONObject response = new JSONObject(wsResponse);
            videos.result = response.getString(JSONTags.VIDEOS_RESULT);
            if (videos.result.equals("success")) {
                JSONArray videosJSONArray = response.getJSONArray(JSONTags.VIDEOS_VIDEOS);
                ArrayList<Video> videosArrayList = new ArrayList<Video>();
                int size = videosJSONArray.length();
                for (int i = 0; i < size; i++) {
                    JSONObject jsonVideo = videosJSONArray.getJSONObject(i);
                    Video video = new Video();

                    video.name = jsonVideo.getString(JSONTags.VIDEO_NAME);
                    video.date = jsonVideo.getString(JSONTags.VIDEO_DATE);
                    video.description = jsonVideo.getString(JSONTags.VIDEO_DESCRIPTION);
                    video.link = jsonVideo.getString(JSONTags.VIDEO_LINK);

                    videosArrayList.add(video);
                }
                videos.videos = videosArrayList;
            }
            else videos.videos = null;
        } catch (JSONException e) {
            Log.e(TAG, "JSONException", e);
            throw new DataException(e);
        }

        Bundle bundle = new Bundle();
        bundle.putParcelable(VKubeRequestFactory.BUNDLE_EXTRA_VIDEOS, videos);
        return bundle;
    }

}