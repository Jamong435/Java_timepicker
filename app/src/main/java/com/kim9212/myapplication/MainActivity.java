package com.kim9212.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    public TimePicker timePicker;
    Button set_save_bt;
    int pick_hour, pick_min;
    ListViewAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ListViewAdapter();
        listView.setAdapter(adapter);
        timePicker = (TimePicker) findViewById(R.id.time_picker);
        set_save_bt = (Button) findViewById(R.id.set_save_bt);
        set_save_bt.setOnClickListener(listener);
    }


    public View.OnClickListener listener = new View.OnClickListener()
    {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onClick(View v)
        {
            String ampm;
            switch (v.getId())
            {
                case R.id.set_save_bt:
                {
                    if (timePicker.getHour() > 11 && timePicker.getHour() < 24)
                    {
                        ampm = "오후";
                    }
                    else ampm = "오전";
                    adapter.addItem(timePicker.getHour() + "", timePicker.getMinute() + "", ampm);
                    break;
                }
            }
        }
    };
}
