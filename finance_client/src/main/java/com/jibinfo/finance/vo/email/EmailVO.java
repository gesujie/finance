package com.jibinfo.finance.vo.email;

import java.io.Serializable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 2017/5/26.
 */
public class EmailVO implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String ENCODEING = "UTF-8";

    private String subject; // 主题

    private String template;//模板CODE

    private String message; // 信息(支持HTML)

    private Map<String,String> params;//发送参数


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public static String getEncodeing() {
        return ENCODEING;
    }


    public static String composeMessage(String template, Map<String,String> data) {
        String regex = "\\$\\{(.+?)\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(template);
        /*
         * sb用来存储替换过的内容，它会把多次处理过的字符串按源字符串序
         * 存储起来。
         */
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String name = matcher.group(1);//键名
            String value = data.get(name);//键值
            if (value == null) {
                value = "";
            } else {
                value = value.replaceAll("\\$", "\\\\\\$");
            }

            matcher.appendReplacement(sb, value);
        }
        //最后还得要把尾串接到已替换的内容后面去，这里尾串为“，欢迎下次光临！”
        matcher.appendTail(sb);
        return sb.toString();
    }

}
