package com.wxq.bigworld.servergateway.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

@Component
public class PublicUtil {

    /**
     * 将配置文件读出来的url去除空白
     *
     * @param permitUrls
     * @return
     */
    public String[] getPermitUrls(String permitUrls) {
        if (StringUtils.isNotEmpty(permitUrls) && StringUtils.isNotBlank(permitUrls)) {
            permitUrls = permitUrls.replace(" ", "");
            String[] urlArray = StringUtils.splitByWholeSeparator(permitUrls, ",");
            return urlArray;
        }
        return new String[]{};
    }


    /**
     * 获取request payload 数据
     *
     * @param request
     * @return
     * @throws IOException
     */
    public Map<String, Object> getRequestBody(HttpServletRequest request) throws IOException {
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        return (Map) JSON.parse(stringBuilder.toString());
    }
}
