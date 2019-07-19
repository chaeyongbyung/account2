package com.example.accountapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_page);

        ImageView back_Image =(ImageView)findViewById(R.id.backbtn);

        back_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        
    }
    public void mOnClick(View view) {
        Intent intent =null;
        switch(view.getId()){
            case R.id.backbtn:
                intent =new Intent(ListActivity.this, MainActivity.class);
                break;
        }
        startActivity(intent);
    }
}
