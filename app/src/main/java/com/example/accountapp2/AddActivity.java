package com.example.accountapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);

    }
    public void mOnClick(View view) {
        Intent intent =null;
        switch(view.getId()){
            case R.id.backbtn2:
                intent =new Intent(AddActivity.this, MainActivity.class);
                break;
            case R.id.in_money_btn:
                intent =new Intent(AddActivity.this, AddIncomeActivity.class);
                break;
            case R.id.out_money_btn:
                intent =new Intent(AddActivity.this, AddActivity.class);
                break;
        }
        startActivity(intent);
    }
}
