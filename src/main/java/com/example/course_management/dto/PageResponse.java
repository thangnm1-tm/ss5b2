package com.example.course_management.dto;

import java.util.List;
import org.springframework.data.domain.Page;

public class PageResponse<T> {
    private List<T> items;
    private int page;
    private int size;
    private int totalItems;
    private int totalPages;
    private boolean last;

    public PageResponse() {
    }

    public PageResponse(List<T> items, int page, int size, int totalItems, int totalPages, boolean last) {
        this.items = items;
        this.page = page;
        this.size = size;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.last = last;
    }

    public PageResponse(Page<T> pageObject) {
        this.items = pageObject.getContent();
        this.page = pageObject.getNumber();
        this.size = pageObject.getSize();
        this.totalItems = (int) pageObject.getTotalElements();
        this.totalPages = pageObject.getTotalPages();
        this.last = pageObject.isLast();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
