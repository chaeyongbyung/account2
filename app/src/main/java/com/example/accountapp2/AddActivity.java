package com.example.accountapp2;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.DatePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private EditText input;
    private EditText content;
    private TextView date;

    Calendar cal = new GregorianCalendar();
    Date pickedDate = cal.getTime();
    DateFormat dbdf = new SimpleDateFormat("yyyyMMdd");
    DateFormat showdf = new SimpleDateFormat("yyyy년 MM월 dd일");

    private TextView input_date;
    private TextView putput;
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

    public void insert(View v){
        String input_money = input.getText().toString();
        String input_content = content.getText().toString();
        String input_date = date.getText().toString();

        if (flag == 1)
        insertToIncome(input_money, input_content, input_date);
        if (flag ==2)
        insertToExpenditure(input_money, input_content, input_date);

    }


    private void insertToIncome(String input_content, String input_money, String input_date){
        class InsertData extends AsyncTask<String, String, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(AddActivity.this,"Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String ... params){
                try{
                    String input_money =(String)params[0];
                    String input_content = (String)params[1];
                    String input_date = (String)params[2];

                    String link = "http://52.79.101.11/info.php?";
                    String data = URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(input_content, "UTF-8");
                    data += "&" + URLEncoder.encode("expenditure", "UTF-8") + "=" + URLEncoder.encode(input_money, "UTF-8");
                    data += "&" + URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(input_date,  "UTF-8");
                    link += data;
                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }
                    return sb.toString();

                }
                catch (Exception e){
                    return new String("Exception: " +e.getMessage());
                }
            }
        }
        InsertData task = new InsertData();
        task.execute(input_content, input_money, input_date);

    }
    private void insertToExpenditure(String input_content, String input_money, String input_date){
        class InsertData extends AsyncTask<String, String, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute(){
                super.onPreExecute();
                loading = ProgressDialog.show(AddActivity.this,"Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String ... params){
                try{
                    String input_money =(String)params[0];
                    String input_content = (String)params[1];
                    String input_date = (String)params[2];

                    String link = "http://52.79.101.11/info.php?";
                    String data = URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(input_content, "UTF-8");
                    data += "&" + URLEncoder.encode("expenditure", "UTF-8") + "=" + URLEncoder.encode(input_money, "UTF-8");
                    data += "&" + URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(input_date,  "UTF-8");
                    link += data;
                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    while ((line = reader.readLine()) != null) {
                        sb.append(line);
                        break;
                    }
                    return sb.toString();

                }
                catch (Exception e){
                    return new String("Exception: " +e.getMessage());
                }
            }
        }
        InsertData task = new InsertData();
        task.execute(input_content, input_money, input_date);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_page);

        input =(EditText)findViewById(R.id.input_money);
        content=(EditText)findViewById(R.id.input_info);
        date =(TextView) findViewById(R.id.putput);


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
        putput=(TextView)findViewById(R.id.putput);

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
                pickDay = dbdf.format(pickedDate);
                putput.setText(pickDay);
            }
        };
    }

    public void OnClickHandler(View view)
    {
        DatePickerDialog dialog = new DatePickerDialog(this, callbackMethod, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) , cal.get(Calendar.DATE));

        dialog.show();
    }

}
