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
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity {

    TextView this_month;
    Calendar cal = new GregorianCalendar();
    Date pickedDate = cal.getTime();

    String pickYear;
    String pickMonth;

    DateFormat dbdf = new SimpleDateFormat("yyyyMMdd");
    DateFormat showdf = new SimpleDateFormat("yyyy년 MM월");
    DateFormat yeardf = new SimpleDateFormat("yyyy");
    DateFormat monthdf = new SimpleDateFormat("MM");


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
            switch (view.getId()) {
                case R.id.before_month:
                    cal.setTime(pickedDate);
                    cal.add(Calendar.MONTH, -1);
                    pickedDate = cal.getTime();
                    UpdateNow();
                    break;
                case R.id.after_month:
                    cal.setTime(pickedDate);
                    cal.add(Calendar.MONTH, 1);
                    pickedDate = cal.getTime();
                    UpdateNow();
                    break;
            }
        }
    }

    void UpdateNow(){
        pickYear = yeardf.format(pickedDate);
        pickMonth = monthdf.format(pickedDate);
        String pickDay = showdf.format(pickedDate);
        this_month.setText(pickDay);
        Toast.makeText(this, pickYear + pickMonth, Toast.LENGTH_SHORT).show();

    }

}