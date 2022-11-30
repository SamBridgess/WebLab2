package com.exmpale.models;

public class PointRequest {
    private final float x;
    private final float y;
    private final float[] rs;

    public PointRequest(float x, float y, float[] rs) {
        this.x = x;
        this.y = y;
        this.rs = rs;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR(int index) {
        return rs[index];
    }

    public int getRSize() {
        return rs.length;
    }
}
