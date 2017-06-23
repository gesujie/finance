/*
 *  =========================================================================
 *   Copyright(c) 2015-2016. Jibinfo System Inc. All Rights Reserved.
 *
 *   注意:本内容仅限于南京坚卓软件科技公司内部传阅，禁止外泄以及用于其他的商业目的
 *  =========================================================================
 *
 */
package com.jibinfo.finance.vo.util;

import java.io.Serializable;
import java.util.HashMap;

/**
 * BatchGrantCreditVO
 *
 * @author Vincentx
 * @version 1.0.0
 * @date 2016/6/6 11:14
 */
public class SystemSensitiveVO extends ExcelBaseTo implements Serializable {
    private static final long serialVersionUID = 3655873032341125670L;

    private String words;
    private String remark;

    @Override
    protected void initCellAttrMapping() {
        cellAttrMapping = new HashMap<>();
        cellAttrMapping.put(0,"words");
        cellAttrMapping.put(1,"remark");
    }

	public String getWords() {
		return words;
	}

	public void setWords(String words) {
		this.words = words;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

   
}
