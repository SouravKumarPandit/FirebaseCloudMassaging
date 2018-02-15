/*******************************************************************************
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 ******************************************************************************/

package com.centrahub.focus.sourav.firebasecloudmassaging.notificationmaker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by sourav on 15-Feb-18.
 */

public class TestActivity extends AppCompatActivity implements ResponseHandleing {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.addView(getView());
        setContentView(linearLayout);
    }

    @Override
    public void onSuccess() {
runOnUiThread(new Runnable() {
    @Override
    public void run() {
        Toast.makeText(TestActivity.this, "Wait For It", Toast.LENGTH_SHORT).show();
    }
});
    }

    @Override
    public void onError() {

    }

    public View getView() {
        Button view=new Button(this);
        view.setText("Make Cloud Massaging");
        view.setTextColor(Color.DKGRAY);
        view.setBackground(getResources().getDrawable(android.R.drawable.btn_default));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostRequest postRequest=new PostRequest(TestActivity.this);
            }
        });
        return view;
    }
}
