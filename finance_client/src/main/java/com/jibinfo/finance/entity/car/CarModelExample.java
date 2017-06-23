package com.jibinfo.finance.entity.car;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jibinfo.framework.page.Paginator;

public class CarModelExample implements Serializable {
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

	public CarModelExample() {
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

		public Criteria andSidIsNull() {
			addCriterion("SID is null");
			return (Criteria) this;
		}

		public Criteria andSidIsNotNull() {
			addCriterion("SID is not null");
			return (Criteria) this;
		}

		public Criteria andSidEqualTo(Long value) {
			addCriterion("SID =", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotEqualTo(Long value) {
			addCriterion("SID <>", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidGreaterThan(Long value) {
			addCriterion("SID >", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidGreaterThanOrEqualTo(Long value) {
			addCriterion("SID >=", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidLessThan(Long value) {
			addCriterion("SID <", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidLessThanOrEqualTo(Long value) {
			addCriterion("SID <=", value, "sid");
			return (Criteria) this;
		}

		public Criteria andSidIn(List<Long> values) {
			addCriterion("SID in", values, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotIn(List<Long> values) {
			addCriterion("SID not in", values, "sid");
			return (Criteria) this;
		}

		public Criteria andSidBetween(Long value1, Long value2) {
			addCriterion("SID between", value1, value2, "sid");
			return (Criteria) this;
		}

		public Criteria andSidNotBetween(Long value1, Long value2) {
			addCriterion("SID not between", value1, value2, "sid");
			return (Criteria) this;
		}

		public Criteria andModelNameIsNull() {
			addCriterion("MODEL_NAME is null");
			return (Criteria) this;
		}

		public Criteria andModelNameIsNotNull() {
			addCriterion("MODEL_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andModelNameEqualTo(String value) {
			addCriterion("MODEL_NAME =", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotEqualTo(String value) {
			addCriterion("MODEL_NAME <>", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameGreaterThan(String value) {
			addCriterion("MODEL_NAME >", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameGreaterThanOrEqualTo(String value) {
			addCriterion("MODEL_NAME >=", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameLessThan(String value) {
			addCriterion("MODEL_NAME <", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameLessThanOrEqualTo(String value) {
			addCriterion("MODEL_NAME <=", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameLike(String value) {
			addCriterion("MODEL_NAME like", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotLike(String value) {
			addCriterion("MODEL_NAME not like", value, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameIn(List<String> values) {
			addCriterion("MODEL_NAME in", values, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotIn(List<String> values) {
			addCriterion("MODEL_NAME not in", values, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameBetween(String value1, String value2) {
			addCriterion("MODEL_NAME between", value1, value2, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelNameNotBetween(String value1, String value2) {
			addCriterion("MODEL_NAME not between", value1, value2, "modelName");
			return (Criteria) this;
		}

		public Criteria andModelPriceIsNull() {
			addCriterion("MODEL_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andModelPriceIsNotNull() {
			addCriterion("MODEL_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andModelPriceEqualTo(String value) {
			addCriterion("MODEL_PRICE =", value, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceNotEqualTo(String value) {
			addCriterion("MODEL_PRICE <>", value, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceGreaterThan(String value) {
			addCriterion("MODEL_PRICE >", value, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceGreaterThanOrEqualTo(String value) {
			addCriterion("MODEL_PRICE >=", value, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceLessThan(String value) {
			addCriterion("MODEL_PRICE <", value, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceLessThanOrEqualTo(String value) {
			addCriterion("MODEL_PRICE <=", value, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceLike(String value) {
			addCriterion("MODEL_PRICE like", value, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceNotLike(String value) {
			addCriterion("MODEL_PRICE not like", value, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceIn(List<String> values) {
			addCriterion("MODEL_PRICE in", values, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceNotIn(List<String> values) {
			addCriterion("MODEL_PRICE not in", values, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceBetween(String value1, String value2) {
			addCriterion("MODEL_PRICE between", value1, value2, "modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelPriceNotBetween(String value1, String value2) {
			addCriterion("MODEL_PRICE not between", value1, value2,
					"modelPrice");
			return (Criteria) this;
		}

		public Criteria andModelYearIsNull() {
			addCriterion("MODEL_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andModelYearIsNotNull() {
			addCriterion("MODEL_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andModelYearEqualTo(String value) {
			addCriterion("MODEL_YEAR =", value, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearNotEqualTo(String value) {
			addCriterion("MODEL_YEAR <>", value, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearGreaterThan(String value) {
			addCriterion("MODEL_YEAR >", value, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearGreaterThanOrEqualTo(String value) {
			addCriterion("MODEL_YEAR >=", value, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearLessThan(String value) {
			addCriterion("MODEL_YEAR <", value, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearLessThanOrEqualTo(String value) {
			addCriterion("MODEL_YEAR <=", value, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearLike(String value) {
			addCriterion("MODEL_YEAR like", value, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearNotLike(String value) {
			addCriterion("MODEL_YEAR not like", value, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearIn(List<String> values) {
			addCriterion("MODEL_YEAR in", values, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearNotIn(List<String> values) {
			addCriterion("MODEL_YEAR not in", values, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearBetween(String value1, String value2) {
			addCriterion("MODEL_YEAR between", value1, value2, "modelYear");
			return (Criteria) this;
		}

		public Criteria andModelYearNotBetween(String value1, String value2) {
			addCriterion("MODEL_YEAR not between", value1, value2, "modelYear");
			return (Criteria) this;
		}

		public Criteria andLiterIsNull() {
			addCriterion("LITER is null");
			return (Criteria) this;
		}

		public Criteria andLiterIsNotNull() {
			addCriterion("LITER is not null");
			return (Criteria) this;
		}

		public Criteria andLiterEqualTo(String value) {
			addCriterion("LITER =", value, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterNotEqualTo(String value) {
			addCriterion("LITER <>", value, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterGreaterThan(String value) {
			addCriterion("LITER >", value, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterGreaterThanOrEqualTo(String value) {
			addCriterion("LITER >=", value, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterLessThan(String value) {
			addCriterion("LITER <", value, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterLessThanOrEqualTo(String value) {
			addCriterion("LITER <=", value, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterLike(String value) {
			addCriterion("LITER like", value, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterNotLike(String value) {
			addCriterion("LITER not like", value, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterIn(List<String> values) {
			addCriterion("LITER in", values, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterNotIn(List<String> values) {
			addCriterion("LITER not in", values, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterBetween(String value1, String value2) {
			addCriterion("LITER between", value1, value2, "liter");
			return (Criteria) this;
		}

		public Criteria andLiterNotBetween(String value1, String value2) {
			addCriterion("LITER not between", value1, value2, "liter");
			return (Criteria) this;
		}

		public Criteria andGearTypeIsNull() {
			addCriterion("GEAR_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andGearTypeIsNotNull() {
			addCriterion("GEAR_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andGearTypeEqualTo(String value) {
			addCriterion("GEAR_TYPE =", value, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeNotEqualTo(String value) {
			addCriterion("GEAR_TYPE <>", value, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeGreaterThan(String value) {
			addCriterion("GEAR_TYPE >", value, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeGreaterThanOrEqualTo(String value) {
			addCriterion("GEAR_TYPE >=", value, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeLessThan(String value) {
			addCriterion("GEAR_TYPE <", value, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeLessThanOrEqualTo(String value) {
			addCriterion("GEAR_TYPE <=", value, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeLike(String value) {
			addCriterion("GEAR_TYPE like", value, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeNotLike(String value) {
			addCriterion("GEAR_TYPE not like", value, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeIn(List<String> values) {
			addCriterion("GEAR_TYPE in", values, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeNotIn(List<String> values) {
			addCriterion("GEAR_TYPE not in", values, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeBetween(String value1, String value2) {
			addCriterion("GEAR_TYPE between", value1, value2, "gearType");
			return (Criteria) this;
		}

		public Criteria andGearTypeNotBetween(String value1, String value2) {
			addCriterion("GEAR_TYPE not between", value1, value2, "gearType");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardIsNull() {
			addCriterion("DISCHARGE_STANDARD is null");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardIsNotNull() {
			addCriterion("DISCHARGE_STANDARD is not null");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardEqualTo(String value) {
			addCriterion("DISCHARGE_STANDARD =", value, "dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardNotEqualTo(String value) {
			addCriterion("DISCHARGE_STANDARD <>", value, "dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardGreaterThan(String value) {
			addCriterion("DISCHARGE_STANDARD >", value, "dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardGreaterThanOrEqualTo(String value) {
			addCriterion("DISCHARGE_STANDARD >=", value, "dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardLessThan(String value) {
			addCriterion("DISCHARGE_STANDARD <", value, "dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardLessThanOrEqualTo(String value) {
			addCriterion("DISCHARGE_STANDARD <=", value, "dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardLike(String value) {
			addCriterion("DISCHARGE_STANDARD like", value, "dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardNotLike(String value) {
			addCriterion("DISCHARGE_STANDARD not like", value,
					"dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardIn(List<String> values) {
			addCriterion("DISCHARGE_STANDARD in", values, "dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardNotIn(List<String> values) {
			addCriterion("DISCHARGE_STANDARD not in", values,
					"dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardBetween(String value1, String value2) {
			addCriterion("DISCHARGE_STANDARD between", value1, value2,
					"dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andDischargeStandardNotBetween(String value1,
				String value2) {
			addCriterion("DISCHARGE_STANDARD not between", value1, value2,
					"dischargeStandard");
			return (Criteria) this;
		}

		public Criteria andSeatNumberIsNull() {
			addCriterion("SEAT_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andSeatNumberIsNotNull() {
			addCriterion("SEAT_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andSeatNumberEqualTo(String value) {
			addCriterion("SEAT_NUMBER =", value, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberNotEqualTo(String value) {
			addCriterion("SEAT_NUMBER <>", value, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberGreaterThan(String value) {
			addCriterion("SEAT_NUMBER >", value, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberGreaterThanOrEqualTo(String value) {
			addCriterion("SEAT_NUMBER >=", value, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberLessThan(String value) {
			addCriterion("SEAT_NUMBER <", value, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberLessThanOrEqualTo(String value) {
			addCriterion("SEAT_NUMBER <=", value, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberLike(String value) {
			addCriterion("SEAT_NUMBER like", value, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberNotLike(String value) {
			addCriterion("SEAT_NUMBER not like", value, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberIn(List<String> values) {
			addCriterion("SEAT_NUMBER in", values, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberNotIn(List<String> values) {
			addCriterion("SEAT_NUMBER not in", values, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberBetween(String value1, String value2) {
			addCriterion("SEAT_NUMBER between", value1, value2, "seatNumber");
			return (Criteria) this;
		}

		public Criteria andSeatNumberNotBetween(String value1, String value2) {
			addCriterion("SEAT_NUMBER not between", value1, value2,
					"seatNumber");
			return (Criteria) this;
		}

		public Criteria andShortNameIsNull() {
			addCriterion("SHORT_NAME is null");
			return (Criteria) this;
		}

		public Criteria andShortNameIsNotNull() {
			addCriterion("SHORT_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andShortNameEqualTo(String value) {
			addCriterion("SHORT_NAME =", value, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameNotEqualTo(String value) {
			addCriterion("SHORT_NAME <>", value, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameGreaterThan(String value) {
			addCriterion("SHORT_NAME >", value, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameGreaterThanOrEqualTo(String value) {
			addCriterion("SHORT_NAME >=", value, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameLessThan(String value) {
			addCriterion("SHORT_NAME <", value, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameLessThanOrEqualTo(String value) {
			addCriterion("SHORT_NAME <=", value, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameLike(String value) {
			addCriterion("SHORT_NAME like", value, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameNotLike(String value) {
			addCriterion("SHORT_NAME not like", value, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameIn(List<String> values) {
			addCriterion("SHORT_NAME in", values, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameNotIn(List<String> values) {
			addCriterion("SHORT_NAME not in", values, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameBetween(String value1, String value2) {
			addCriterion("SHORT_NAME between", value1, value2, "shortName");
			return (Criteria) this;
		}

		public Criteria andShortNameNotBetween(String value1, String value2) {
			addCriterion("SHORT_NAME not between", value1, value2, "shortName");
			return (Criteria) this;
		}

		public Criteria andMinGreYearIsNull() {
			addCriterion("MIN_GRE_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andMinGreYearIsNotNull() {
			addCriterion("MIN_GRE_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andMinGreYearEqualTo(String value) {
			addCriterion("MIN_GRE_YEAR =", value, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearNotEqualTo(String value) {
			addCriterion("MIN_GRE_YEAR <>", value, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearGreaterThan(String value) {
			addCriterion("MIN_GRE_YEAR >", value, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearGreaterThanOrEqualTo(String value) {
			addCriterion("MIN_GRE_YEAR >=", value, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearLessThan(String value) {
			addCriterion("MIN_GRE_YEAR <", value, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearLessThanOrEqualTo(String value) {
			addCriterion("MIN_GRE_YEAR <=", value, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearLike(String value) {
			addCriterion("MIN_GRE_YEAR like", value, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearNotLike(String value) {
			addCriterion("MIN_GRE_YEAR not like", value, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearIn(List<String> values) {
			addCriterion("MIN_GRE_YEAR in", values, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearNotIn(List<String> values) {
			addCriterion("MIN_GRE_YEAR not in", values, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearBetween(String value1, String value2) {
			addCriterion("MIN_GRE_YEAR between", value1, value2, "minGreYear");
			return (Criteria) this;
		}

		public Criteria andMinGreYearNotBetween(String value1, String value2) {
			addCriterion("MIN_GRE_YEAR not between", value1, value2,
					"minGreYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearIsNull() {
			addCriterion("MAX_GER_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearIsNotNull() {
			addCriterion("MAX_GER_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearEqualTo(String value) {
			addCriterion("MAX_GER_YEAR =", value, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearNotEqualTo(String value) {
			addCriterion("MAX_GER_YEAR <>", value, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearGreaterThan(String value) {
			addCriterion("MAX_GER_YEAR >", value, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearGreaterThanOrEqualTo(String value) {
			addCriterion("MAX_GER_YEAR >=", value, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearLessThan(String value) {
			addCriterion("MAX_GER_YEAR <", value, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearLessThanOrEqualTo(String value) {
			addCriterion("MAX_GER_YEAR <=", value, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearLike(String value) {
			addCriterion("MAX_GER_YEAR like", value, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearNotLike(String value) {
			addCriterion("MAX_GER_YEAR not like", value, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearIn(List<String> values) {
			addCriterion("MAX_GER_YEAR in", values, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearNotIn(List<String> values) {
			addCriterion("MAX_GER_YEAR not in", values, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearBetween(String value1, String value2) {
			addCriterion("MAX_GER_YEAR between", value1, value2, "maxGerYear");
			return (Criteria) this;
		}

		public Criteria andMaxGerYearNotBetween(String value1, String value2) {
			addCriterion("MAX_GER_YEAR not between", value1, value2,
					"maxGerYear");
			return (Criteria) this;
		}

		public Criteria andPictureUrlIsNull() {
			addCriterion("PICTURE_URL is null");
			return (Criteria) this;
		}

		public Criteria andPictureUrlIsNotNull() {
			addCriterion("PICTURE_URL is not null");
			return (Criteria) this;
		}

		public Criteria andPictureUrlEqualTo(String value) {
			addCriterion("PICTURE_URL =", value, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlNotEqualTo(String value) {
			addCriterion("PICTURE_URL <>", value, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlGreaterThan(String value) {
			addCriterion("PICTURE_URL >", value, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlGreaterThanOrEqualTo(String value) {
			addCriterion("PICTURE_URL >=", value, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlLessThan(String value) {
			addCriterion("PICTURE_URL <", value, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlLessThanOrEqualTo(String value) {
			addCriterion("PICTURE_URL <=", value, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlLike(String value) {
			addCriterion("PICTURE_URL like", value, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlNotLike(String value) {
			addCriterion("PICTURE_URL not like", value, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlIn(List<String> values) {
			addCriterion("PICTURE_URL in", values, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlNotIn(List<String> values) {
			addCriterion("PICTURE_URL not in", values, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlBetween(String value1, String value2) {
			addCriterion("PICTURE_URL between", value1, value2, "pictureUrl");
			return (Criteria) this;
		}

		public Criteria andPictureUrlNotBetween(String value1, String value2) {
			addCriterion("PICTURE_URL not between", value1, value2,
					"pictureUrl");
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

	public static class Criteria extends GeneratedCriteria implements Serializable{
		private static final long serialVersionUID = 1L;

		protected Criteria() {
			super();
		}
	}

	public static class Criterion implements Serializable{
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