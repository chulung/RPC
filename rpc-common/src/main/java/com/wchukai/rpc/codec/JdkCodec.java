package com.wchukai.rpc.codec;

import java.io.*;

/**
 * Created by chulung on 2017/10/9.
 */
public class JdkCodec implements Codec {
    @Override
    public void doEncode(Object request, OutputStream outPut) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outPut)) {
            objectOutputStream.writeObject(request);
        }
    }

    @Override
    public Object doDecode(InputStream inputStream) throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
