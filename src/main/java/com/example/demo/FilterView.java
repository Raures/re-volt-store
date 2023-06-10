package com.example.demo;

import java.util.List;

public class FilterView {

    private String name;
    private List<FilterOption> items;

    public FilterView(String name, List<FilterOption> items) {
        this.name = name;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FilterOption> getItems() {
        return items;
    }

    public void setItems(List<FilterOption> items) {
        this.items = items;
    }
}
