package com.wchukai.rpc.codec;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.*;

/**
 * hessian编码器
 * Created by wenchukai on 2017/9/23.
 */
public class HessianCodec implements Codec {

    @Override
    public void doEncode(Object request, OutputStream outPut) throws IOException {
        Hessian2Output objectOutput = new Hessian2Output(outPut);
        objectOutput.writeObject(request);
        objectOutput.close();
    }

    @Override
    public Object doDecode(InputStream inputStream) throws IOException {
        Hessian2Input hessian2Input = new Hessian2Input(inputStream);
        Object resultObject = hessian2Input.readObject();
        hessian2Input.close();
        return resultObject;
    }

}
