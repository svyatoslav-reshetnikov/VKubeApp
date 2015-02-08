package vkube.hit2b.com.vkube.operation;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.foxykeep.datadroid.exception.ConnectionException;
import com.foxykeep.datadroid.exception.DataException;
import com.foxykeep.datadroid.network.NetworkConnection;
import com.foxykeep.datadroid.requestmanager.Request;
import com.foxykeep.datadroid.service.RequestService;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

import vkube.hit2b.com.vkube.data.factory.AnnouncementsJsonFactory;
import vkube.hit2b.com.vkube.network.URLs;

/**
 * Created by svyat on 07.02.15.
 */
public class AnnouncementsOperation implements RequestService.Operation {

    public static String PARAM_AMOUNT = "";
    public static String PARAM_ANNOUNCEMENTS_URL = "";

    @Override
    public Bundle execute(Context context, Request request) throws ConnectionException,
            DataException {

        ArrayList<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        parameters.add(new BasicNameValuePair("amount", PARAM_AMOUNT));

        NetworkConnection networkConnection = new NetworkConnection(context,
                URLs.announcementsUrl);
        networkConnection.setParameters(parameters);
        networkConnection.setMethod(NetworkConnection.Method.POST);
        NetworkConnection.ConnectionResult result = networkConnection.execute();

        PARAM_AMOUNT = "";
        Log.d("result", result.body);
        return AnnouncementsJsonFactory.parseResult(result.body);
    }
}