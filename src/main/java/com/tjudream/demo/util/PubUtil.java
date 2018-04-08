package com.tjudream.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述:
 * <p>
 * Created by mengxiansen on 2018-04-08 14:40
 *
 * @author mengxs@lenovocloud.com
 */
public class PubUtil {
    private PubUtil(){

    }
    /**
     *
     * @param resp  httpServletResponse
     * @param content 返回信息
     * @throws IOException io异常
     */
    public static void responseText(HttpServletResponse resp, Object content) throws IOException {
        resp.setContentType("application/json; charset=utf-8");
        String text = "";
        if(content instanceof String){
            text = (String)content;
        }else{
            text = JSON.toJSONString(content, SerializerFeature.WriteMapNullValue,
                    SerializerFeature.WriteNullStringAsEmpty);
        }
        resp.getWriter().write(text);
    }
}
