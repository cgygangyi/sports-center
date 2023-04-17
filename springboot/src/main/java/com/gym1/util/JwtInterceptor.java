package com.gym1.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().toUpperCase().equals("OPTIONS")){
            return true; // Pass all OPTION requests
        } else {
            String token = request.getHeader("token"); // Get the token in the request header
            Map<String, Object> map = new HashMap<>();
            try {
                boolean verify = JwtUtil.checkToken(token);
                if (verify) {
                    return true; // validated
                } else {
                    return false; // Not validated
                }
            } catch (SignatureException e) {
                e.printStackTrace();
                map.put("msg", "Invalid token!");
            } catch (UnsupportedJwtException e) {
                e.printStackTrace();
                map.put("msg", "Unsupported signatures");
            } catch (ExpiredJwtException e) {
                e.printStackTrace();
                map.put("msg", "Expired token");
            } catch (MalformedJwtException e) { // IllegalArgumentException
                e.printStackTrace();
                map.put("msg", "Unsupported signature formats");
            } catch (Exception e) {
                e.printStackTrace();
                map.put("msg", "Invalid token");
            }
            map.put("state", false);
            String json = new ObjectMapper().writeValueAsString(map);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(json);
            return false;
        }
    }
}
