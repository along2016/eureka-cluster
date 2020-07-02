package com.cloud.common.util;

import com.alibaba.fastjson.JSON;
import com.cloud.common.auth.entity.IUser;
import com.cloud.common.user.sysUser.entity.vo.AuthorityVO;
import com.cloud.common.user.sysUser.entity.vo.UserVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class Utils {
    private static final Logger log = LoggerFactory.getLogger(Utils.class);
    private static ObjectMapper objectMapper;
    private static String injector;
    private static boolean isLogicDelete;
    private static String[] ignoreList = new String[]{"currentUser", "currentDataRule"};

    public Utils() {
    }

    public static void responseJson(Object responseMessage) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        PrintWriter out = null;

        try {
            response.setContentType("application/json;charset=UTF-8");
            String json = getObjectMapper().writeValueAsString(responseMessage);
            out = response.getWriter();
            out.write(json);
            out.flush();
        } catch (IOException var8) {
            var8.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }

    }

    public static HttpServletRequest getHttpServletRequest() {
        try {
            return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception var1) {
            return null;
        }
    }

    public static Object getPrincipal() {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return principal;
        } catch (NullPointerException var1) {
            log.error(var1.toString());
            return null;
        }
    }

    public static UserVO getPrincipalUserVO() {
        Object principal = getPrincipal();
        if (principal != null && IUser.class.isAssignableFrom(principal.getClass())) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(principal, userVO);
            return userVO;
        } else {
            return null;
        }
    }

    public static String getToken() {
        String token = "";
        HttpServletRequest request = getHttpServletRequest();
        if (request != null) {
            token = request.getHeader("Authorization");
            if (StringUtils.isBlank(token) || !token.startsWith("Bearer")) {
                token = StringUtils.isNotBlank(request.getParameter("access_token")) ? "Bearer " + request.getParameter("access_token") : "";
            }
        }

        return token;
    }

    public static String getPrincipalUsername() {
        Object principal = getPrincipal();
        if (principal != null) {
            return IUser.class.isAssignableFrom(principal.getClass()) ? ((IUser)principal).getUsername() : principal.toString();
        } else {
            return null;
        }
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (ip != null && ip.contains(",")) {
            String[] ips = ip.split(",");
            if (ips.length > 0) {
                ip = ips[0];
            }
        }

        return ip;
    }

    public static boolean hasRole(Collection<? extends GrantedAuthority> authorities, String role) {
        if (CollectionUtils.isEmpty(authorities)) {
            return false;
        } else {
            GrantedAuthority authority = (GrantedAuthority)authorities.stream().filter((auth) -> {
                return auth.getAuthority().equals(role);
            }).findAny().orElse(null);
            return Objects.nonNull(authority);
        }
    }

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }

        return objectMapper;
    }

    public static String beanToJson(Object o) {
        String json;
        try {
            json = getObjectMapper().writeValueAsString(o);
        } catch (IOException var3) {
            var3.printStackTrace();
            json = "";
        }

        return json;
    }

    public static String beanToFastJson(Object o) {
        String json = JSON.toJSONString(o);
        return json;
    }

    public static Object jsonToBean(String json, Class o) {
        Object result;
        try {
            result = objectMapper.readValue(json, o);
        } catch (IOException var4) {
            var4.printStackTrace();
            result = null;
        }

        return result;
    }

    public static <T> T mapToBean(Map<String, Object> map, T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    public static Map beanToMap(Object bean) {
        BeanMap beanMap = BeanMap.create(bean);
        return beanMap;
    }

    public static void copyProperties(Object source, Object target, String... list) {
        String[] tempList = list == null ? ignoreList : list;
        if (source.getClass().equals(target.getClass())) {
            tempList = null;
        }

        BeanUtils.copyProperties(source, target, tempList);
    }

    public static boolean checkAuthorityLevel(Integer level, boolean... isEquals) {
        List<AuthorityVO> list = getPrincipalUserVO().getAuthorities();
        return isEquals.length > 0 && isEquals[0] ? list.stream().anyMatch((a) -> {
            return a.getLevel() != null && a.getLevel() <= level;
        }) : list.stream().anyMatch((a) -> {
            return a.getLevel() != null && a.getLevel() < level;
        });
    }

    public static Integer getAuthorityLevel() {
        List<AuthorityVO> list = getPrincipalUserVO().getAuthorities();
        AuthorityVO authorityVO = (AuthorityVO)list.stream().min(Comparator.comparing((a) -> {
            return a.getLevel();
        })).get();
        return authorityVO != null ? authorityVO.getLevel() : 2147483647;
    }

    public static boolean checkSuperAdmin() {
        return getAuthorityLevel() == 1;
    }

    public static String getAuthorizationHeader(String clientId, String clientSecret) {
        if (clientId == null || clientSecret == null) {
            log.warn("Null Client ID or Client Secret detected. Endpoint that requires authentication will reject request with 401 error.");
        }

        String creds = String.format("%s:%s", clientId, clientSecret);

        try {
            return "Basic " + new String(Base64.encode(creds.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException var4) {
            throw new IllegalStateException("Could not convert String");
        }
    }

    public static String toUnderLineName(String value) {
        if (StringUtils.isBlank(value)) {
            return "";
        } else {
            StringBuilder result = new StringBuilder();

            for(int i = 0; i < value.length(); ++i) {
                String s = value.substring(i, i + 1);
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                    s = s.toLowerCase();
                }

                result.append(s);
            }

            return result.toString();
        }
    }

    public static String camelName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && !name.isEmpty()) {
            if (!name.contains("_")) {
                return name.substring(0, 1).toLowerCase() + name.substring(1);
            } else {
                String[] camels = name.split("_");
                String[] var3 = camels;
                int var4 = camels.length;

                for(int var5 = 0; var5 < var4; ++var5) {
                    String camel = var3[var5];
                    if (!camel.isEmpty()) {
                        if (result.length() == 0) {
                            result.append(camel.toLowerCase());
                        } else {
                            result.append(camel.substring(0, 1).toUpperCase());
                            result.append(camel.substring(1).toLowerCase());
                        }
                    }
                }

                return result.toString();
            }
        } else {
            return "";
        }
    }

    public static Throwable loadCause(Throwable e) {
        Throwable result;
        for(result = e; result.getCause() != null; result = result.getCause()) {
        }

        return result;
    }

    public static String loadCauseMsg(Throwable e) {
        String msg = loadCause(e).getMessage();
        return msg != null ? msg : e.getMessage();
    }
}
