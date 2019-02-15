package com.wxq.bigworld.servergateway.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtilTest {
   public  static String  SECRET = "im-Luxqi";

    /**
     * 生成token
     * @return
     */
   public String creatToken() throws UnsupportedEncodingException {

       Calendar nowTime = Calendar.getInstance();
       nowTime.add(Calendar.HOUR,2);
       Date expiresDate = nowTime.getTime();

       Map<String,Object> map = new HashMap<String,Object>();
       map.put("alg","HS256");
       map.put("typ","JWT");
       String token = JWT.create()
               .withHeader(map)
               .withClaim("name","wxq")
               .withClaim("age","11")
               .withClaim("org","今日头条")
               .withExpiresAt(expiresDate)
               .withIssuedAt(new Date())
               .sign(Algorithm.HMAC256(SECRET));
       return token;
   }

    /**
     * 解密token
     */
    public Map<String, Claim> verifyToken(String token) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET))
                .build();

        DecodedJWT jwt = null;
        try{
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw new RuntimeException("失效，重新登录");
        }
        return jwt.getClaims();
    }
}
