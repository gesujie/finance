package com.jibinfo.finance.dto;

import java.io.Serializable;

/**
 * 磁盘状态
 * Created by admin on 2017/5/22.
 */
public class SpaceStatusDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String spaceName;

    private String total;

    private String free;

    private String usable;

	// private int usePercent;

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getUsable() {
        return usable;
    }

    public void setUsable(String usable) {
        this.usable = usable;
    }

	public int getUsePercent() {
        Double aDouble = new Double(this.free == null ? "0" : this.free.substring(0, this.free.length() - 1));
        Double aDouble1 = new Double(this.total == null ? "0" : this.total.substring(0, this.total.length() - 1));
        return (int)((aDouble1 - aDouble) * 100 / aDouble1);
    }
}
