package com.example.accountapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.DatePicker;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {

    TextView this_month;
    Calendar cal = new GregorianCalendar();
    int mYear = cal.get(Calendar.YEAR);
    int mMonth = cal.get(Calendar.MONTH) + 1;
    int mDay = cal.get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this_month = (TextView) findViewById(R.id.this_month);

        MyListener myListener = new MyListener() ;
        // 각 Button의 이벤트 리스너로 onClickListener 지정.
        ImageView before_month = (ImageView) findViewById(R.id.before_month) ;
        before_month.setOnClickListener(myListener) ;
        ImageView after_month = (ImageView) findViewById(R.id.after_month) ;
        after_month.setOnClickListener(myListener) ;

        UpdateNow();

    }

    public void mOnClick(View view) {
        Intent intent = null;
        switch(view.getId()){
        case R.id.this_month:
            new DatePickerDialog(MainActivity.this, mDateSetListener, mYear, mMonth, mDay).show();
            break;
        case R.id.btn_add:
            intent =new Intent(MainActivity.this, AddActivity.class);
            break;
        case R.id.btn_list:
            intent =new Intent(MainActivity.this, ListActivity.class);
            break;
        }
    startActivity(intent);
    }

    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            this_month = (TextView) findViewById(R.id.this_month);
            switch (view.getId()) {
                case R.id.before_month:
                    mMonth -= 1;
                    UpdateNow();
                    break;
                case R.id.after_month:
                    mMonth += 1;
                    UpdateNow();
                    break;
            }
        }
    }

    DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            mYear = year;

            mMonth = monthOfYear;

            mDay = dayOfMonth;

            UpdateNow();
        }
    };



    void UpdateNow(){

        this_month.setText(String.format("%d년 %d월", mYear, mMonth));

    }

}