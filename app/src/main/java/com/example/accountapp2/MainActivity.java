package com.example.accountapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void mOnClick(View view) {
        Intent intent =null;
        switch(view.getId()){
            case R.id.btn_add:
                intent =new Intent(MainActivity.this, AddActivity.class);
                break;
            case R.id.btn_list:
                intent =new Intent(MainActivity.this, ListActivity.class);
                break;
            case R.id.before_month:
                intent =new Intent(MainActivity.this, AddActivity.class);
                break;
        }
        startActivity(intent);
    }
}