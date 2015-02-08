package vkube.hit2b.com.vkube.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;
import com.foxykeep.datadroid.requestmanager.Request;
import com.foxykeep.datadroid.requestmanager.RequestManager;

import java.util.ArrayList;

import vkube.hit2b.com.vkube.R;
import vkube.hit2b.com.vkube.data.model.Videos;
import vkube.hit2b.com.vkube.network.URLs;
import vkube.hit2b.com.vkube.network.VKubeRequestFactory;
import vkube.hit2b.com.vkube.network.VKubeRequestManager;
import vkube.hit2b.com.vkube.operation.VideosOperation;

/**
 * Created by SVYAT on 13.10.2014.
 */
public class VideosFragment extends SherlockFragment implements RequestManager.RequestListener{

    public VKubeRequestManager mRequestManager;
    public ArrayList<Request> mRequestList;

    protected static final String SAVED_STATE_REQUEST_LIST = "savedStateRequestList";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRequestManager = VKubeRequestManager.from(getActivity());

        if (savedInstanceState != null) {
            mRequestList = savedInstanceState.getParcelableArrayList(SAVED_STATE_REQUEST_LIST);
        } else {
            mRequestList = new ArrayList<Request>();
        }

        getVideos(10);

        View view = inflater.inflate(R.layout.fragment_videos,
                container, false);

        return view;
    }

    public void getVideos (int amount) {
        VideosOperation.PARAM_AMOUNT = String.valueOf(amount);

        Request request = VKubeRequestFactory.getVideosRequest(URLs.videoUrl);
        mRequestManager.execute(request, this);
        mRequestList.add(request);
    }

    @Override
    public void onRequestFinished(Request request, Bundle resultData) {
        if (mRequestList.contains(request))
            mRequestList.remove(request);

        if (request.getRequestType() == 3) {
            Videos videos = resultData
                    .getParcelable(VKubeRequestFactory.BUNDLE_EXTRA_VIDEOS);
            Log.d("videos", "videos = " + videos.result);
        }
    }

    @Override
    public void onRequestConnectionError(Request request, int statusCode) {

    }

    @Override
    public void onRequestDataError(Request request) {

    }

    @Override
    public void onRequestCustomError(Request request, Bundle resultData) {

    }
}