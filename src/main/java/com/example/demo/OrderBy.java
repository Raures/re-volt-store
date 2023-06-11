package com.example.demo;

import java.util.List;

public class OrderBy {

    private final int selected;

    private final List<OrderOption> options;
    private final String ascending;

    public OrderBy(int selected, List<OrderOption> options, String ascending) {
        this.selected = selected;
        this.options = options;
        this.ascending = ascending;
    }

    public int getSelected() {
        return selected;
    }

    public List<OrderOption> getOptions() {
        return options;
    }

    public String getAscending() {
        return ascending;
    }
}
