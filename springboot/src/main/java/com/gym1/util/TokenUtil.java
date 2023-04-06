package com.gym1.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class TokenUtil {

    private static final long EXPIRE_DATE=60 * 60 * 1000;
    //token秘钥
    private static final String TOKEN_SECRET = "r54eg5sae4r665ser54rg";

    //实现签名方法
    public String getToken (String username,String password){

        String token = "";
        try {
            //这里将useName 和 password 存入了Token，在下面的解析中，也会有解析的方法可以获取到Token里面的数据
            //Token过期的时间
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息,类型以及签名所用的算法
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，存入token，生成签名
            token = JWT.create()
                    .withHeader(header)
                    //存储自己想要留给前端的内容
                    .withClaim("username",username)
                    .withClaim("password",password).withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }

    //验证token
    public static boolean verify(String token){
        /**
         * @desc   验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Token过期,需要重新登录！");
        }
        return false;
    }

    /**
     * 获取token中信息 userName
     * @param token
     * @return
     */

    public static String getUsername(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();

        }catch (JWTDecodeException e){
            e.printStackTrace();
        }
        return null;
    }

}
