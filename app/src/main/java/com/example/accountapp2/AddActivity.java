package com.example.accountapp2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    Calendar cal = new GregorianCalendar();
    Date pickedDate = cal.getTime();
    DateFormat dbdf = new SimpleDateFormat("yyyyMMdd");
    DateFormat showdf = new SimpleDateFormat("yyyy년 MM월 dd일");

    private TextView input_date;
    private DatePickerDialog.OnDateSetListener callbackMethod;

    //플래그값  1=수익  2=지출
    int flag = 2;

    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            Button in_money_btn = (Button) findViewById(R.id.in_money_btn);
            Button out_money_btn = (Button) findViewById(R.id.out_money_btn);
            Button move_money_btn = (Button) findViewById(R.id.move_money_btn);
            switch (view.getId()) {
                case R.id.in_money_btn:
                    flag = 1;
                    in_money_btn.setBackgroundResource(R.color.darkbrown);
                    out_money_btn.setBackgroundResource(R.color.white);
                    move_money_btn.setBackgroundResource(R.color.white);
                    break;
                case R.id.out_money_btn:
                    flag = 2;
                    in_money_btn.setBackgroundResource(R.color.white);
                    out_money_btn.setBackgroundResource(R.color.darkbrown);
                    move_money_btn.setBackgroundResource(R.color.white);
                    break;
                case R.id.move_money_btn:
                    flag = 3;
                    in_money_btn.setBackgroundResource(R.color.white);
                    out_money_btn.setBackgroundResource(R.color.white);
                    move_money_btn.setBackgroundResource(R.color.darkbrown);
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);

        input_date = (TextView)findViewById(R.id.input_date);

        String pickDay = showdf.format(pickedDate);
        input_date.setText(pickDay);

        //달력에서 값받기
        this.InitializeView();
        this.InitializeListener();

        BtnOnClickListener onClickListener = new BtnOnClickListener() ;

        // 각 Button의 이벤트 리스너로 onClickListener 지정.
        Button in_money_btn = (Button) findViewById(R.id.in_money_btn) ;
        in_money_btn.setOnClickListener(onClickListener) ;
        Button out_money_btn = (Button) findViewById(R.id.out_money_btn) ;
        out_money_btn.setOnClickListener(onClickListener) ;
        Button move_money_btn = (Button) findViewById(R.id.move_money_btn) ;
        move_money_btn.setOnClickListener(onClickListener) ;



    }

    public void mOnClick(View view) {
        Intent intent = null;

        switch(view.getId()){
            case R.id.backbtn2:
                intent =new Intent(AddActivity.this, MainActivity.class);
                break;

        }
        startActivity(intent);
    }


    //달력에서 값 받기용
    public void InitializeView()
    {
        input_date = (TextView)findViewById(R.id.input_date);
    }

    public void InitializeListener()
    {
        callbackMethod = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {

                cal.set(year,month,day);
                pickedDate = cal.getTime();
                String pickDay = showdf.format(pickedDate);
                input_date.setText(pickDay);
            }
        };
    }

    public void OnClickHandler(View view)
    {
        DatePickerDialog dialog = new DatePickerDialog(this, callbackMethod, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) , cal.get(Calendar.DATE));

        dialog.show();
    }

}
