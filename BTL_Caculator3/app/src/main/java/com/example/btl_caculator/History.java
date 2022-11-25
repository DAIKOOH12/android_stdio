package com.example.btl_caculator;

public class History {
    private int position;
    private String cal;
    private float total;


    public History() {
    }

    public History(int position, String cal, double total) {
        this.position = position;
        this.cal = cal;
        this.total = (float) total;
    }

    public History(String cal, double total) {
        this.cal = cal;
        this.total = (float) total;
    }

    public int getPosition() {
        return position;
    }

    public String getCal() {
        return cal;
    }

    public float getTotal() {
        return total;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public void setTotal(float total) {
        this.total = (float) total;
    }
}
