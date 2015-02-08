package vkube.hit2b.com.vkube.network;

import android.os.Bundle;

import com.foxykeep.datadroid.exception.CustomRequestException;
import com.foxykeep.datadroid.requestmanager.Request;
import com.foxykeep.datadroid.service.RequestService;

import vkube.hit2b.com.vkube.operation.AnnouncementsOperation;
import vkube.hit2b.com.vkube.operation.ReportsOperation;
import vkube.hit2b.com.vkube.operation.VideosOperation;

/**
 * Created by svyat on 07.02.15.
 */
public class VKubeRequestService extends RequestService {

    @Override
    protected int getMaximumNumberOfThreads() {
        return 3;
    }

    @Override
    public Operation getOperationForType(int requestType) {
        switch (requestType) {
            case VKubeRequestFactory.REQUEST_TYPE_ANNOUNCEMENTS:
                return new AnnouncementsOperation();
            case VKubeRequestFactory.REQUEST_TYPE_REPORTS:
                return new ReportsOperation();
            case VKubeRequestFactory.REQUEST_TYPE_VIDEOS:
                return new VideosOperation();
        }
        return null;
    }

    @Override
    protected Bundle onCustomRequestException(Request request, CustomRequestException exception) {
        if (exception instanceof MyCustomRequestException) {
            Bundle bundle = new Bundle();
            bundle.putString(VKubeRequestFactory.BUNDLE_EXTRA_ERROR_MESSAGE,
                    "MyCustomRequestException thrown.");
            return bundle;
        }
        return super.onCustomRequestException(request, exception);
    }
}