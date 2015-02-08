package vkube.hit2b.com.vkube.network;

import android.content.Context;

import com.foxykeep.datadroid.requestmanager.RequestManager;

/**
 * Created by svyat on 07.02.15.
 */
public class VKubeRequestManager extends RequestManager {

    // Singleton management
    private static VKubeRequestManager sInstance;

    public synchronized static VKubeRequestManager from(Context context) {
        if (sInstance == null) {
            sInstance = new VKubeRequestManager(context);
        }

        return sInstance;
    }

    private VKubeRequestManager(Context context) {
        super(context, VKubeRequestService.class);
    }
}