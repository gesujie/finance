/*
 *  =========================================================================
 *   Copyright(c) 2015-2016. Jibinfo System Inc. All Rights Reserved.
 *
 *   注意:本内容仅限于南京坚卓软件科技公司内部传阅，禁止外泄以及用于其他的商业目的
 *  =========================================================================
 *
 */
package com.jibinfo.finance.exception;

/**
 * CreditExcelException
 * excel 解析异常类
 * @author Vincentx
 * @version 1.0.0
 * @date 2016/6/16 15:38
 */
public class SensitiveException extends Exception {
    private static final long serialVersionUID = 149345744175299926L;
    public SensitiveException(){}
    public SensitiveException(String message){
        super(message);
    }
}
