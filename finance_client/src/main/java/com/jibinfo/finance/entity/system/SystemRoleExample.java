package com.jibinfo.finance.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jibinfo.framework.page.Paginator;

public class SystemRoleExample implements Serializable {
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

	public SystemRoleExample() {
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

		public Criteria andRoleCodeIsNull() {
			addCriterion("ROLE_CODE is null");
			return (Criteria) this;
		}

		public Criteria andRoleCodeIsNotNull() {
			addCriterion("ROLE_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andRoleCodeEqualTo(String value) {
			addCriterion("ROLE_CODE =", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeNotEqualTo(String value) {
			addCriterion("ROLE_CODE <>", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeGreaterThan(String value) {
			addCriterion("ROLE_CODE >", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeGreaterThanOrEqualTo(String value) {
			addCriterion("ROLE_CODE >=", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeLessThan(String value) {
			addCriterion("ROLE_CODE <", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeLessThanOrEqualTo(String value) {
			addCriterion("ROLE_CODE <=", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeLike(String value) {
			addCriterion("ROLE_CODE like", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeNotLike(String value) {
			addCriterion("ROLE_CODE not like", value, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeIn(List<String> values) {
			addCriterion("ROLE_CODE in", values, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeNotIn(List<String> values) {
			addCriterion("ROLE_CODE not in", values, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeBetween(String value1, String value2) {
			addCriterion("ROLE_CODE between", value1, value2, "roleCode");
			return (Criteria) this;
		}

		public Criteria andRoleCodeNotBetween(String value1, String value2) {
			addCriterion("ROLE_CODE not between", value1, value2, "roleCode");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andRoleDescIsNull() {
			addCriterion("ROLE_DESC is null");
			return (Criteria) this;
		}

		public Criteria andRoleDescIsNotNull() {
			addCriterion("ROLE_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andRoleDescEqualTo(String value) {
			addCriterion("ROLE_DESC =", value, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescNotEqualTo(String value) {
			addCriterion("ROLE_DESC <>", value, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescGreaterThan(String value) {
			addCriterion("ROLE_DESC >", value, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescGreaterThanOrEqualTo(String value) {
			addCriterion("ROLE_DESC >=", value, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescLessThan(String value) {
			addCriterion("ROLE_DESC <", value, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescLessThanOrEqualTo(String value) {
			addCriterion("ROLE_DESC <=", value, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescLike(String value) {
			addCriterion("ROLE_DESC like", value, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescNotLike(String value) {
			addCriterion("ROLE_DESC not like", value, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescIn(List<String> values) {
			addCriterion("ROLE_DESC in", values, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescNotIn(List<String> values) {
			addCriterion("ROLE_DESC not in", values, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescBetween(String value1, String value2) {
			addCriterion("ROLE_DESC between", value1, value2, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andRoleDescNotBetween(String value1, String value2) {
			addCriterion("ROLE_DESC not between", value1, value2, "roleDesc");
			return (Criteria) this;
		}

		public Criteria andStatIsNull() {
			addCriterion("STAT is null");
			return (Criteria) this;
		}

		public Criteria andStatIsNotNull() {
			addCriterion("STAT is not null");
			return (Criteria) this;
		}

		public Criteria andStatEqualTo(String value) {
			addCriterion("STAT =", value, "stat");
			return (Criteria) this;
		}

		public Criteria andStatNotEqualTo(String value) {
			addCriterion("STAT <>", value, "stat");
			return (Criteria) this;
		}

		public Criteria andStatGreaterThan(String value) {
			addCriterion("STAT >", value, "stat");
			return (Criteria) this;
		}

		public Criteria andStatGreaterThanOrEqualTo(String value) {
			addCriterion("STAT >=", value, "stat");
			return (Criteria) this;
		}

		public Criteria andStatLessThan(String value) {
			addCriterion("STAT <", value, "stat");
			return (Criteria) this;
		}

		public Criteria andStatLessThanOrEqualTo(String value) {
			addCriterion("STAT <=", value, "stat");
			return (Criteria) this;
		}

		public Criteria andStatLike(String value) {
			addCriterion("STAT like", value, "stat");
			return (Criteria) this;
		}

		public Criteria andStatNotLike(String value) {
			addCriterion("STAT not like", value, "stat");
			return (Criteria) this;
		}

		public Criteria andStatIn(List<String> values) {
			addCriterion("STAT in", values, "stat");
			return (Criteria) this;
		}

		public Criteria andStatNotIn(List<String> values) {
			addCriterion("STAT not in", values, "stat");
			return (Criteria) this;
		}

		public Criteria andStatBetween(String value1, String value2) {
			addCriterion("STAT between", value1, value2, "stat");
			return (Criteria) this;
		}

		public Criteria andStatNotBetween(String value1, String value2) {
			addCriterion("STAT not between", value1, value2, "stat");
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