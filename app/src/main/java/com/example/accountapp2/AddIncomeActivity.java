package com.example.accountapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AddIncomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_income_page);
        ImageView back_Image2 =(ImageView)findViewById(R.id.backbtn2);

        back_Image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AddIncomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void mOnClick(View view) {
        Intent intent =null;
        switch(view.getId()){
            case R.id.backbtn2:
                intent =new Intent(AddIncomeActivity.this, MainActivity.class);
                break;
            case R.id.in_money_btn:
                intent =new Intent(AddIncomeActivity.this, AddIncomeActivity.class);
                break;
            case R.id.out_money_btn:
                intent =new Intent(AddIncomeActivity.this, AddActivity.class);
                break;
        }
        startActivity(intent);
    }
}
