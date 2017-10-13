package com.wchukai.rpc.codec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by wenchukai on 2017/9/23.
 */
public interface Codec {

    void doEncode(Object request, OutputStream outPut) throws IOException;

    Object doDecode(InputStream inputStream) throws IOException;
}
