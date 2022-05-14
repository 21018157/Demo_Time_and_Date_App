package sg.edu.rp.c346.id21018157.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking field variables to UI elements
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.buttonReset);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hour = String.valueOf(tp.getCurrentHour());
                String minute = String.format("%02d", tp.getCurrentMinute()); //adds a 0 in front of single digits
                tvDisplay.setText("Time is " + hour + ":" + minute);
            }
        });

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day = String.format("%02d", dp.getDayOfMonth());
                String month = String.format("%02d", dp.getMonth()+1);  //dp.getMonth is INT, month is STR (must +1 to int)
                String year = String.valueOf(dp.getYear());
                tvDisplay.setText("Date is " + day + "/" + month + "/" + year);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(00);
                tp.setCurrentMinute(00);
                dp.updateDate(2022, 01-1,01);  //-1 to make it JAN
            }
        });


    }
}