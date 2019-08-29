package com.mahdichtioui.rxpreferencessample.samples.permissions;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mahdichtioui.rxpreferencessample.R;
import com.tbruyelle.rxpermissions2.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

public class PermissionsActivity extends AppCompatActivity {

    @BindView(R.id.et_number_input)
    EditText etNumberInput;

    private Unbinder unbinder;
    private Disposable disposable;
    private RxPermissions rxPermissions;

    private static final String PHONE_NUMBER = "321564054654";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rxPermissions = new RxPermissions(this);
        setContentView(R.layout.activity_permissions);
        unbinder = ButterKnife.bind(this);
    }

    @SuppressLint("MissingPermission")
    @OnClick(R.id.btn_call)
    public void onCallBtnClicked(View view) {
        disposable = rxPermissions.request(Manifest.permission.CALL_PHONE)
                .subscribe(granted -> {
                    if (granted) {
                        String phoneNumber = etNumberInput.getText().toString();
                        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber)));
                    } else {
                        Toast.makeText(this, "Sorry, Request Not Granted", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
        unbinder.unbind();
        super.onDestroy();
    }
}
