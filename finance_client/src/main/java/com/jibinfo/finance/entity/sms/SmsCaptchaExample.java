package com.jibinfo.finance.entity.sms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jibinfo.framework.page.Paginator;

public class SmsCaptchaExample implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Paginator paginator;

	public Paginator getPaginator() {
		return paginator;
	}

	public void setPaginator(Paginator paginator) {
		this.paginator = paginator;
	}

	public SmsCaptchaExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("ID not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("MOBILE =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("MOBILE <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("MOBILE >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("MOBILE >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("MOBILE <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("MOBILE <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("MOBILE like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("MOBILE not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("MOBILE in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("MOBILE not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("MOBILE between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("MOBILE not between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andCaptchaIsNull() {
			addCriterion("CAPTCHA is null");
			return (Criteria) this;
		}

		public Criteria andCaptchaIsNotNull() {
			addCriterion("CAPTCHA is not null");
			return (Criteria) this;
		}

		public Criteria andCaptchaEqualTo(String value) {
			addCriterion("CAPTCHA =", value, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaNotEqualTo(String value) {
			addCriterion("CAPTCHA <>", value, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaGreaterThan(String value) {
			addCriterion("CAPTCHA >", value, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaGreaterThanOrEqualTo(String value) {
			addCriterion("CAPTCHA >=", value, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaLessThan(String value) {
			addCriterion("CAPTCHA <", value, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaLessThanOrEqualTo(String value) {
			addCriterion("CAPTCHA <=", value, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaLike(String value) {
			addCriterion("CAPTCHA like", value, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaNotLike(String value) {
			addCriterion("CAPTCHA not like", value, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaIn(List<String> values) {
			addCriterion("CAPTCHA in", values, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaNotIn(List<String> values) {
			addCriterion("CAPTCHA not in", values, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaBetween(String value1, String value2) {
			addCriterion("CAPTCHA between", value1, value2, "captcha");
			return (Criteria) this;
		}

		public Criteria andCaptchaNotBetween(String value1, String value2) {
			addCriterion("CAPTCHA not between", value1, value2, "captcha");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("STATUS is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("STATUS =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("STATUS <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("STATUS >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("STATUS >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("STATUS <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("STATUS <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("STATUS like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("STATUS not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("STATUS in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("STATUS not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("STATUS between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("STATUS not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andExpireDateIsNull() {
			addCriterion("EXPIRE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andExpireDateIsNotNull() {
			addCriterion("EXPIRE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andExpireDateEqualTo(Date value) {
			addCriterion("EXPIRE_DATE =", value, "expireDate");
			return (Criteria) this;
		}

		public Criteria andExpireDateNotEqualTo(Date value) {
			addCriterion("EXPIRE_DATE <>", value, "expireDate");
			return (Criteria) this;
		}

		public Criteria andExpireDateGreaterThan(Date value) {
			addCriterion("EXPIRE_DATE >", value, "expireDate");
			return (Criteria) this;
		}

		public Criteria andExpireDateGreaterThanOrEqualTo(Date value) {
			addCriterion("EXPIRE_DATE >=", value, "expireDate");
			return (Criteria) this;
		}

		public Criteria andExpireDateLessThan(Date value) {
			addCriterion("EXPIRE_DATE <", value, "expireDate");
			return (Criteria) this;
		}

		public Criteria andExpireDateLessThanOrEqualTo(Date value) {
			addCriterion("EXPIRE_DATE <=", value, "expireDate");
			return (Criteria) this;
		}

		public Criteria andExpireDateIn(List<Date> values) {
			addCriterion("EXPIRE_DATE in", values, "expireDate");
			return (Criteria) this;
		}

		public Criteria andExpireDateNotIn(List<Date> values) {
			addCriterion("EXPIRE_DATE not in", values, "expireDate");
			return (Criteria) this;
		}

		public Criteria andExpireDateBetween(Date value1, Date value2) {
			addCriterion("EXPIRE_DATE between", value1, value2, "expireDate");
			return (Criteria) this;
		}

		public Criteria andExpireDateNotBetween(Date value1, Date value2) {
			addCriterion("EXPIRE_DATE not between", value1, value2,
					"expireDate");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNull() {
			addCriterion("IS_DEL is null");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNotNull() {
			addCriterion("IS_DEL is not null");
			return (Criteria) this;
		}

		public Criteria andIsDelEqualTo(String value) {
			addCriterion("IS_DEL =", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotEqualTo(String value) {
			addCriterion("IS_DEL <>", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThan(String value) {
			addCriterion("IS_DEL >", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThanOrEqualTo(String value) {
			addCriterion("IS_DEL >=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThan(String value) {
			addCriterion("IS_DEL <", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThanOrEqualTo(String value) {
			addCriterion("IS_DEL <=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLike(String value) {
			addCriterion("IS_DEL like", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotLike(String value) {
			addCriterion("IS_DEL not like", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelIn(List<String> values) {
			addCriterion("IS_DEL in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotIn(List<String> values) {
			addCriterion("IS_DEL not in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelBetween(String value1, String value2) {
			addCriterion("IS_DEL between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotBetween(String value1, String value2) {
			addCriterion("IS_DEL not between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andCreatedDateIsNull() {
			addCriterion("CREATED_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCreatedDateIsNotNull() {
			addCriterion("CREATED_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedDateEqualTo(Date value) {
			addCriterion("CREATED_DATE =", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateNotEqualTo(Date value) {
			addCriterion("CREATED_DATE <>", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateGreaterThan(Date value) {
			addCriterion("CREATED_DATE >", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATED_DATE >=", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateLessThan(Date value) {
			addCriterion("CREATED_DATE <", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
			addCriterion("CREATED_DATE <=", value, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateIn(List<Date> values) {
			addCriterion("CREATED_DATE in", values, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateNotIn(List<Date> values) {
			addCriterion("CREATED_DATE not in", values, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateBetween(Date value1, Date value2) {
			addCriterion("CREATED_DATE between", value1, value2, "createdDate");
			return (Criteria) this;
		}

		public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
			addCriterion("CREATED_DATE not between", value1, value2,
					"createdDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateIsNull() {
			addCriterion("UPDATED_DATE is null");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateIsNotNull() {
			addCriterion("UPDATED_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateEqualTo(Date value) {
			addCriterion("UPDATED_DATE =", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateNotEqualTo(Date value) {
			addCriterion("UPDATED_DATE <>", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateGreaterThan(Date value) {
			addCriterion("UPDATED_DATE >", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateGreaterThanOrEqualTo(Date value) {
			addCriterion("UPDATED_DATE >=", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateLessThan(Date value) {
			addCriterion("UPDATED_DATE <", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateLessThanOrEqualTo(Date value) {
			addCriterion("UPDATED_DATE <=", value, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateIn(List<Date> values) {
			addCriterion("UPDATED_DATE in", values, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateNotIn(List<Date> values) {
			addCriterion("UPDATED_DATE not in", values, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateBetween(Date value1, Date value2) {
			addCriterion("UPDATED_DATE between", value1, value2, "updatedDate");
			return (Criteria) this;
		}

		public Criteria andUpdatedDateNotBetween(Date value1, Date value2) {
			addCriterion("UPDATED_DATE not between", value1, value2,
					"updatedDate");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria implements
			Serializable {
		private static final long serialVersionUID = 1L;

		protected Criteria() {
			super();
		}
	}

	public static class Criterion implements Serializable {
		private static final long serialVersionUID = 1L;

		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}