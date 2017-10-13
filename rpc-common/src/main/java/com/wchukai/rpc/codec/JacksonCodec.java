package com.wchukai.rpc.codec;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by chulung on 2017/10/9.
 */
public class JacksonCodec implements Codec {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doEncode(Object request, OutputStream outPut) throws IOException {
        objectMapper.writeValue(outPut, new ObjectWapper(objectMapper.writeValueAsString(request), request.getClass().getName()));
    }

    @Override
    public Object doDecode(InputStream inputStream) throws IOException {
        ObjectWapper objectWapper = objectMapper.readValue(inputStream, ObjectWapper.class);
        try {
            return objectMapper.readValue(objectWapper.object, Class.forName(objectWapper.className));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private class ObjectWapper {
        String object;
        String className;

        public ObjectWapper(String object, String className) {
            this.object = object;
            this.className = className;
        }
    }
}
