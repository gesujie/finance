package com.jibinfo.finance.service.impl.rule;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import com.jibinfo.finance.entity.rule.RuleSignInPoint;
import com.jibinfo.finance.service.rule.RuleSignInPointService;

@Service("ruleSignInPointService")
public class RuleSignInPointServiceImpl implements RuleSignInPointService {
	private static final Log logger = LogFactory
			.getLog(RuleSignInPointServiceImpl.class);

	@Override
	public RuleSignInPoint execSignInPoint(RuleSignInPoint signInPoint) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-sign_in");
			kSession.insert(signInPoint);
			kSession.fireAllRules();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return signInPoint;
	}

	public static void main(String[] args) {
		RuleSignInPoint signInPoint = new RuleSignInPoint(false, false, 7,
				true, 25, new BigDecimal(2), new BigDecimal(20),
				new BigDecimal(50), new BigDecimal(20000));
		RuleSignInPoint s = new RuleSignInPointServiceImpl()
				.execSignInPoint(signInPoint);
		System.out.println(s);
	}
}
