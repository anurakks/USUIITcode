package it_anurak.co.th.usuiitcode;

import android.content.Context;
import android.os.AsyncTask;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextLinks;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class GetUserWhereUser extends AsyncTask<String, Void, String> {

    private Context context;

    public GetUserWhereUser(Context context) {

        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("User", strings[0])
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[1]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();



        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
