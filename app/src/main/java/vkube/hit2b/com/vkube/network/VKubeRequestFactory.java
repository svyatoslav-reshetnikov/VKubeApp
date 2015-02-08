package vkube.hit2b.com.vkube.network;

/**
 * Created by svyat on 07.02.15.
 */

import com.foxykeep.datadroid.requestmanager.Request;

import vkube.hit2b.com.vkube.data.model.Announcement;
import vkube.hit2b.com.vkube.operation.AnnouncementsOperation;
import vkube.hit2b.com.vkube.operation.ReportsOperation;
import vkube.hit2b.com.vkube.operation.VideosOperation;

public class VKubeRequestFactory {

    // Request types
    public static final int REQUEST_TYPE_ANNOUNCEMENTS = 1;
    public static final int REQUEST_TYPE_REPORTS = 2;
    public static final int REQUEST_TYPE_VIDEOS = 3;

    // Response data
    public static final String BUNDLE_EXTRA_ANNOUNCEMENTS =
            "com.vkube.announcements";
    public static final String BUNDLE_EXTRA_REPORTS =
            "com.vkube.reports";
    public static final String BUNDLE_EXTRA_VIDEOS =
            "com.vkube.videos";
    public static final String BUNDLE_EXTRA_ERROR_MESSAGE =
            "com.foxykeep.datadroidpoc.extra.errorMessage";

    public static Request getAnnouncementsRequest(String url) {
        Request request = new Request(REQUEST_TYPE_ANNOUNCEMENTS);
        request.put(AnnouncementsOperation.PARAM_ANNOUNCEMENTS_URL, url);
        request.setMemoryCacheEnabled(true);
        return request;
    }

    public static Request getReportsRequest(String url) {
        Request request = new Request(REQUEST_TYPE_REPORTS);
        request.put(ReportsOperation.PARAM_REPORTS_URL, url);
        request.setMemoryCacheEnabled(true);
        return request;
    }

    public static Request getVideosRequest(String url) {
        Request request = new Request(REQUEST_TYPE_VIDEOS);
        request.put(VideosOperation.PARAM_VIDEOS_URL, url);
        request.setMemoryCacheEnabled(true);
        return request;
    }
}