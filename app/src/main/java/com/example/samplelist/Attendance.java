package com.example.samplelist;

import android.widget.TextView;

public class Attendance {
    boolean selected=false;
    String name = null;

    public Attendance(boolean selected, String name) {
        this.selected = selected;
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
