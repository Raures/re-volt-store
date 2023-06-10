package com.example.demo;

public class Checkbox implements FilterOption {
    private String name;
    private boolean isChecked;
    private final int count;
    private final String type = "checkbox";

    public Checkbox(String name, boolean isChecked, int count) {
        this.name = name;
        this.isChecked = isChecked;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return name + " (" + count + ")";
    }
}
