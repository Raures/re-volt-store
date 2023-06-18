package com.example.demo.layout.filters;

public class Checkbox implements FilterOption {
    private String name;
    private boolean isChecked;
    private final int count;
    private final FilterOptionType type;

    public Checkbox(String name, boolean isChecked, int count) {
        this.name = name;
        this.isChecked = isChecked;
        this.count = count;
        this.type = FilterOptionType.CHECKBOX;
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
        return type.getValue();
    }

    public String toString() {
        return name + " (" + count + ")";
    }
}
