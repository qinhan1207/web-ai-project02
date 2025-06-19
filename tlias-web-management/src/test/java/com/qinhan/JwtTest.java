package com.qinhan;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

public class JwtTest {

    /**
     * 生成JWT
     */
    @Test
    public void testGenerateTest(){
        HashMap<String, Object> dataMap = new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","qinhan");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "cWluaGFu") // 指定加密的算法以及秘钥
                .addClaims(dataMap) // 添加自定义的负载信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))// 设置过期时间
                .compact();//生成令牌
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJxaW5oYW4iLCJleHAiOjE3NTAzMzE3OTl9.WCdVo00sr9qzqdn9rSsRn90qJ1tziS2Nck0_c6g27XA";
        Claims claims = Jwts.parser().setSigningKey("cWluaGFu") //指定秘钥
                .parseClaimsJws(token)  // 解析令牌
                .getBody(); // 获取自定义信息
        System.out.println(claims);
    }
}
