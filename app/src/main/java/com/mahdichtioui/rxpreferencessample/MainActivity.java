package com.mahdichtioui.rxpreferencessample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mahdichtioui.rxpreferencessample.samples.binding.BindingActivity;
import com.mahdichtioui.rxpreferencessample.samples.permissions.PermissionsActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_permission)
    public void onPermissionBtnClicked(View view){
        startActivity(new Intent(MainActivity.this, PermissionsActivity.class));
    }

    @OnClick(R.id.btn_preferences)
    public void onPreferencesBtnClicked(View view){
        Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_lifecycle)
    public void onLifecycleBtnClicked(View view){
        Toast.makeText(this, "Coming Soon", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_binding)
    public void onBindingBtnClicked(View view){
        startActivity(new Intent(MainActivity.this, BindingActivity.class));
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
