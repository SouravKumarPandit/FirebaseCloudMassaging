/*******************************************************************************
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 ******************************************************************************/

package com.centrahub.focus.sourav.firebasecloudmassaging.notificationmaker;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by madhav on 2/15/2018.
 */

public class PostRequest {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    String json = "{\n" +
            "\"to\":\"/topics/all\",\n" +
            "\"data\":\n" +
            "{\n" +
            "\"title\":\"Android Team Focus\",\n" +
            "\"message\":\"Offer :50 % offText\"\n" +
            "\"image-url\":\"https://firebasestorage.googleapis.com/v0/b/fir-practiceandroid.appspot.com/o/Black_2x.png?alt=media&token=bdd48fa1-5c08-450c-9b1a-87735a0e5f81\"\n" +
            "}\n" +
            "}";
    private ResponseHandleing responseHandleing;

    public PostRequest(ResponseHandleing responseHandleing) {
        this.responseHandleing = responseHandleing;
        postRequest("https://fcm.googleapis.com/fcm/send", json);

    }

    private void postRequest(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "key=" + "AAAnC-HGvc:APA91bGMF94mQjHQJRh_OivXubrTkv_tH8tpYI9FlCkJCNhGr-sg3286rQb-5v00l3ACRjzohbHCGq8-yZowb58rdvURXE87T6inFkDPKCyc1ZQbJvzyZIM7dWNA-oxZfM0wULXjjRwu")
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                responseHandleing.onError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                responseHandleing.onSuccess();
            }
        });
    }
}

interface ResponseHandleing {
    void onSuccess();
    void onError();

}
