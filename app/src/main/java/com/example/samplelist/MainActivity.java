package com.example.samplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AttendaceAdapter attendaceAdapter = null;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);
        ArrayList<Attendance> attendanceList = new ArrayList<Attendance>();
        attendanceList.add(new Attendance(false, "vedant"));
        attendanceList.add(new Attendance(false, "vedantssss"));
        attendanceList.add(new Attendance(false, "vedantsss"));
        attendanceList.add(new Attendance(false, "vedantss"));
        attendanceList.add(new Attendance(false, "vedants"));
        attendanceList.add(new Attendance(false, "v"));
        attendanceList.add(new Attendance(false, "ve"));
        attendanceList.add(new Attendance(false, "ved"));
        attendanceList.add(new Attendance(false, "veda"));
        attendanceList.add(new Attendance(false, "vedan"));

        attendaceAdapter = new AttendaceAdapter(this, R.layout.attendance,attendanceList);
        lv.setAdapter(attendaceAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Attendance attendance = (Attendance) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + attendance.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
        checkButtonClick();
    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.submit);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                List<Attendance> atList = attendaceAdapter.attendanceList;
                for(int i=0;i<atList.size();i++){
                    Attendance attendance = atList.get(i);
                    if(attendance.isSelected()){
                        responseText.append("\n" + attendance.getName());
                    }
                }

                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

            }
        });

    }

}