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
import vkube.hit2b.com.vkube.network.VKubeRequestFactory;
import vkube.hit2b.com.vkube.utils.JSONTags;

/**
 * Created by svyat on 07.02.15.
 */
public class ReportsJsonFactory {

    private static final String TAG = ReportsJsonFactory.class.getSimpleName();

    private ReportsJsonFactory() {

    }

    public static Bundle parseResult(String wsResponse) throws DataException {

        Reports reports = new Reports();

        try {
            JSONObject response = new JSONObject(wsResponse);
            reports.result = response.getString(JSONTags.REPORTS_RESULT);
            if (reports.result.equals("success")) {
                JSONArray reportsJSONArray = response.getJSONArray(JSONTags.REPORTS_REPORTS);
                ArrayList<Report> reportArrayList = new ArrayList<Report>();
                int size = reportsJSONArray.length();
                for (int i = 0; i < size; i++) {
                    JSONObject jsonReport = reportsJSONArray.getJSONObject(i);
                    Report report = new Report();

                    report.name = jsonReport.getString(JSONTags.REPORT_NAME);
                    report.date = jsonReport.getString(JSONTags.REPORT_DATE);
                    report.description = jsonReport.getString(JSONTags.REPORT_DESCRIPTION);
                    JSONArray reportImages = jsonReport.getJSONArray(JSONTags.REPORT_IMAGES);
                    ArrayList<String> imagesArrayList = new ArrayList<String>();
                    if (reportImages.length() > 0) {
                        for (int j = 0; j < reportImages.length(); j++) {
                            JSONObject imageJSON = reportImages.getJSONObject(j);
                            imagesArrayList.add(imageJSON.getString(JSONTags.REPORT_IMAGES_URL));
                        }
                        report.images = imagesArrayList;
                    }
                    else report.images = null;

                    reportArrayList.add(report);
                }
                reports.reports = reportArrayList;
            }
            else reports.reports = null;
        } catch (JSONException e) {
            Log.e(TAG, "JSONException", e);
            throw new DataException(e);
        }

        Bundle bundle = new Bundle();
        bundle.putParcelable(VKubeRequestFactory.BUNDLE_EXTRA_REPORTS, reports);
        return bundle;
    }

}