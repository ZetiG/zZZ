package com.zt.common.configuration;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zt.common.response.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Description: FastJson结果转换
 *
 * @Date 2019/12/16 15:41
 * @Author Zeti
 */
public class ExtendedFastJsonHttpMessageConverter extends FastJsonHttpMessageConverter {

    private static final Charset UTF8 = StandardCharsets.UTF_8;

    private Charset charset;

    private SerializerFeature[] features;

    ExtendedFastJsonHttpMessageConverter() {
        super();
        this.charset = UTF8;
        this.features = new SerializerFeature[]{SerializerFeature.DisableCircularReferenceDetect};
        this.getFastJsonConfig().getSerializeConfig().put(Json.class, SwaggerJsonSerializer.instance);
    }


    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {

        //解决fastJson序列化导致swagger无法加载
        if (obj instanceof ArrayList) {
            ObjectMapper mapper = new ObjectMapper();
            HttpHeaders headers = outputMessage.getHeaders();
            ByteArrayOutputStream outnew = new ByteArrayOutputStream();
            mapper.writeValue(outnew, obj);
            outnew.flush();
            headers.setContentLength(outnew.size());
            OutputStream out = outputMessage.getBody();
            outnew.writeTo(out);
            outnew.close();
        } else if (obj instanceof Result) {
            super.writeInternal(obj, outputMessage);
        } else {
            OutputStream out = outputMessage.getBody();
            String text = JSON.toJSONString(Result.Data(obj), this.features);
            byte[] bytes = text.getBytes(this.charset);
            out.write(bytes);
        }
    }
}
