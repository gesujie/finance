package com.jibinfo.finance.service.rule;

import com.jibinfo.finance.entity.rule.RuleSignInPoint;

public interface RuleSignInPointService {
	// 积分签到规则
	public RuleSignInPoint execSignInPoint(RuleSignInPoint signInPoint);
}
