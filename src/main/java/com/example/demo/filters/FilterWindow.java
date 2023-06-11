package com.example.demo.filters;

import java.util.List;

public class FilterWindow {
    private String name;
    private List<FilterView> filterViews;

    public FilterWindow(String name, List<FilterView> filterViews) {
        this.name = name;
        this.filterViews = filterViews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FilterView> getFilterViews() {
        return filterViews;
    }

    public void setFilterViews(List<FilterView> filterViews) {
        this.filterViews = filterViews;
    }
}
