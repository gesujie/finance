package com.jibinfo.finance.entity.email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jibinfo.framework.page.Paginator;

public class EmailGatewayExample  implements Serializable {
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

    public EmailGatewayExample() {
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

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
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

        public Criteria andEmailHostIsNull() {
            addCriterion("EMAIL_HOST is null");
            return (Criteria) this;
        }

        public Criteria andEmailHostIsNotNull() {
            addCriterion("EMAIL_HOST is not null");
            return (Criteria) this;
        }

        public Criteria andEmailHostEqualTo(String value) {
            addCriterion("EMAIL_HOST =", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostNotEqualTo(String value) {
            addCriterion("EMAIL_HOST <>", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostGreaterThan(String value) {
            addCriterion("EMAIL_HOST >", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL_HOST >=", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostLessThan(String value) {
            addCriterion("EMAIL_HOST <", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostLessThanOrEqualTo(String value) {
            addCriterion("EMAIL_HOST <=", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostLike(String value) {
            addCriterion("EMAIL_HOST like", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostNotLike(String value) {
            addCriterion("EMAIL_HOST not like", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostIn(List<String> values) {
            addCriterion("EMAIL_HOST in", values, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostNotIn(List<String> values) {
            addCriterion("EMAIL_HOST not in", values, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostBetween(String value1, String value2) {
            addCriterion("EMAIL_HOST between", value1, value2, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostNotBetween(String value1, String value2) {
            addCriterion("EMAIL_HOST not between", value1, value2, "emailHost");
            return (Criteria) this;
        }

        public Criteria andSenderIsNull() {
            addCriterion("SENDER is null");
            return (Criteria) this;
        }

        public Criteria andSenderIsNotNull() {
            addCriterion("SENDER is not null");
            return (Criteria) this;
        }

        public Criteria andSenderEqualTo(String value) {
            addCriterion("SENDER =", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotEqualTo(String value) {
            addCriterion("SENDER <>", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThan(String value) {
            addCriterion("SENDER >", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderGreaterThanOrEqualTo(String value) {
            addCriterion("SENDER >=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThan(String value) {
            addCriterion("SENDER <", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLessThanOrEqualTo(String value) {
            addCriterion("SENDER <=", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderLike(String value) {
            addCriterion("SENDER like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotLike(String value) {
            addCriterion("SENDER not like", value, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderIn(List<String> values) {
            addCriterion("SENDER in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotIn(List<String> values) {
            addCriterion("SENDER not in", values, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderBetween(String value1, String value2) {
            addCriterion("SENDER between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andSenderNotBetween(String value1, String value2) {
            addCriterion("SENDER not between", value1, value2, "sender");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameIsNull() {
            addCriterion("EMAIL_USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameIsNotNull() {
            addCriterion("EMAIL_USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameEqualTo(String value) {
            addCriterion("EMAIL_USER_NAME =", value, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameNotEqualTo(String value) {
            addCriterion("EMAIL_USER_NAME <>", value, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameGreaterThan(String value) {
            addCriterion("EMAIL_USER_NAME >", value, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL_USER_NAME >=", value, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameLessThan(String value) {
            addCriterion("EMAIL_USER_NAME <", value, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameLessThanOrEqualTo(String value) {
            addCriterion("EMAIL_USER_NAME <=", value, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameLike(String value) {
            addCriterion("EMAIL_USER_NAME like", value, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameNotLike(String value) {
            addCriterion("EMAIL_USER_NAME not like", value, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameIn(List<String> values) {
            addCriterion("EMAIL_USER_NAME in", values, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameNotIn(List<String> values) {
            addCriterion("EMAIL_USER_NAME not in", values, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameBetween(String value1, String value2) {
            addCriterion("EMAIL_USER_NAME between", value1, value2, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailUserNameNotBetween(String value1, String value2) {
            addCriterion("EMAIL_USER_NAME not between", value1, value2, "emailUserName");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordIsNull() {
            addCriterion("EMAIL_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordIsNotNull() {
            addCriterion("EMAIL_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordEqualTo(String value) {
            addCriterion("EMAIL_PASSWORD =", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordNotEqualTo(String value) {
            addCriterion("EMAIL_PASSWORD <>", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordGreaterThan(String value) {
            addCriterion("EMAIL_PASSWORD >", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL_PASSWORD >=", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordLessThan(String value) {
            addCriterion("EMAIL_PASSWORD <", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordLessThanOrEqualTo(String value) {
            addCriterion("EMAIL_PASSWORD <=", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordLike(String value) {
            addCriterion("EMAIL_PASSWORD like", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordNotLike(String value) {
            addCriterion("EMAIL_PASSWORD not like", value, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordIn(List<String> values) {
            addCriterion("EMAIL_PASSWORD in", values, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordNotIn(List<String> values) {
            addCriterion("EMAIL_PASSWORD not in", values, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordBetween(String value1, String value2) {
            addCriterion("EMAIL_PASSWORD between", value1, value2, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andEmailPasswordNotBetween(String value1, String value2) {
            addCriterion("EMAIL_PASSWORD not between", value1, value2, "emailPassword");
            return (Criteria) this;
        }

        public Criteria andOnOffIsNull() {
            addCriterion("ON_OFF is null");
            return (Criteria) this;
        }

        public Criteria andOnOffIsNotNull() {
            addCriterion("ON_OFF is not null");
            return (Criteria) this;
        }

        public Criteria andOnOffEqualTo(String value) {
            addCriterion("ON_OFF =", value, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffNotEqualTo(String value) {
            addCriterion("ON_OFF <>", value, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffGreaterThan(String value) {
            addCriterion("ON_OFF >", value, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffGreaterThanOrEqualTo(String value) {
            addCriterion("ON_OFF >=", value, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffLessThan(String value) {
            addCriterion("ON_OFF <", value, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffLessThanOrEqualTo(String value) {
            addCriterion("ON_OFF <=", value, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffLike(String value) {
            addCriterion("ON_OFF like", value, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffNotLike(String value) {
            addCriterion("ON_OFF not like", value, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffIn(List<String> values) {
            addCriterion("ON_OFF in", values, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffNotIn(List<String> values) {
            addCriterion("ON_OFF not in", values, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffBetween(String value1, String value2) {
            addCriterion("ON_OFF between", value1, value2, "onOff");
            return (Criteria) this;
        }

        public Criteria andOnOffNotBetween(String value1, String value2) {
            addCriterion("ON_OFF not between", value1, value2, "onOff");
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
            addCriterion("CREATED_DATE not between", value1, value2, "createdDate");
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
            addCriterion("UPDATED_DATE not between", value1, value2, "updatedDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable  {
		private static final long serialVersionUID = 1L;

		protected Criteria() {
            super();
        }
    }

    public static class Criterion  implements Serializable {
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

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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