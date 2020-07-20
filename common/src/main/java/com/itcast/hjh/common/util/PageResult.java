package com.itcast.hjh.common.util;


public class PageResult {


    private int pageNum; //当前页数

    private int pageSize; //每页显示的数量
    private int total; //总条数

    private Object result;
    public PageResult() {
    }

    public PageResult(int pageNum, int pageSize, int total, Object result) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.result = result;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
