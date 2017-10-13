package com.wchukai.rpc.codec;

/**
 * Created by chulung on 2017/10/9.
 */
public enum CodecEnum {
    HESSAIN(0), JACKSON(1), JDK(2);
    private int id;

    CodecEnum(int id) {
        this.id = id;
    }
}
