/*
 *  =========================================================================
 *   Copyright(c) 2015-2016. Jibinfo System Inc. All Rights Reserved.
 *
 *   注意:本内容仅限于南京坚卓软件科技公司内部传阅，禁止外泄以及用于其他的商业目的
 *  =========================================================================
 *
 */

package com.jibinfo.finance.vo.util;

import java.util.Map;

public abstract class ExcelBaseTo {

    protected Long rowNo;

    protected Map<Integer, String> cellAttrMapping;

    protected abstract void initCellAttrMapping();

    public Map<Integer, String> getCellAttrMapping() {
        initCellAttrMapping();
        return cellAttrMapping;
    }

    public Long getRowNo() {
        return rowNo;
    }

    public void setRowNo(Long rowNo) {
        this.rowNo = rowNo;
    }
}