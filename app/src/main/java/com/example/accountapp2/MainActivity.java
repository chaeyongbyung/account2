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
    int mYear;
    int mMonth;
    int mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         this_month = (TextView) findViewById(R.id.this_month);

        Calendar cal = new GregorianCalendar();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        BtnOnClickListener onClickListener = new BtnOnClickListener() ;
        // 각 Button의 이벤트 리스너로 onClickListener 지정.
        ImageView before_month = (ImageView) findViewById(R.id.before_month) ;
        before_month.setOnClickListener(onClickListener) ;
        ImageView after_month = (ImageView) findViewById(R.id.after_month) ;
        after_month.setOnClickListener(onClickListener) ;

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

    DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            // TODO Auto-generated method stub

            mYear = year;

            mMonth = monthOfYear;

            mDay = dayOfMonth;

            UpdateNow();
        }
    };

    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            TextView this_month = (TextView) findViewById(R.id.this_month);
            switch (view.getId()) {
                case R.id.before_month:

                    break;
                case R.id.after_month:

                    break;
            }
        }
    }

    void UpdateNow(){

        this_month.setText(String.format("%d.%d.%d", mYear, mMonth + 1 , mDay));

    }

}