package com.example.samplelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AttendaceAdapter extends ArrayAdapter<Attendance> {

    Context context;
    List<Attendance> attendanceList;

    public AttendaceAdapter(@NonNull Context context, int resource, @NonNull List<Attendance> objects) {
        super(context, resource, objects);
        this.context=context;
        attendanceList=objects;
    }

    private class ViewHolder {
        TextView name;
        CheckBox checkBox;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.attendance, parent, false);

            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.checkBox = (CheckBox) convertView.findViewById(R.id.cb1);
            convertView.setTag(holder);

            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v;
                    Attendance attendance = (Attendance) cb.getTag();
                    Toast.makeText(context,
                            "Clicked on Checkbox: " + cb.getText() +
                                    " is " + cb.isChecked(),
                            Toast.LENGTH_LONG).show();
                    attendance.setSelected(cb.isChecked());
                }
            });
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        Attendance student = attendanceList.get(position);
        holder.name.setText(" (" +  student.getName() + ")");
        holder.checkBox.setText(student.getName());
        holder.checkBox.setChecked(student.isSelected());
        holder.checkBox.setTag(student);

        return convertView;

    }
}
