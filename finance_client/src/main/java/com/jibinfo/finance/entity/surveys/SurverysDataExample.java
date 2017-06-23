package com.jibinfo.finance.entity.surveys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jibinfo.framework.page.Paginator;

public class SurverysDataExample implements Serializable {
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

    public SurverysDataExample() {
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

        public Criteria andParOptionIdIsNull() {
            addCriterion("PAR_OPTION_ID is null");
            return (Criteria) this;
        }

        public Criteria andParOptionIdIsNotNull() {
            addCriterion("PAR_OPTION_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParOptionIdEqualTo(Long value) {
            addCriterion("PAR_OPTION_ID =", value, "parOptionId");
            return (Criteria) this;
        }

        public Criteria andParOptionIdNotEqualTo(Long value) {
            addCriterion("PAR_OPTION_ID <>", value, "parOptionId");
            return (Criteria) this;
        }

        public Criteria andParOptionIdGreaterThan(Long value) {
            addCriterion("PAR_OPTION_ID >", value, "parOptionId");
            return (Criteria) this;
        }

        public Criteria andParOptionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PAR_OPTION_ID >=", value, "parOptionId");
            return (Criteria) this;
        }

        public Criteria andParOptionIdLessThan(Long value) {
            addCriterion("PAR_OPTION_ID <", value, "parOptionId");
            return (Criteria) this;
        }

        public Criteria andParOptionIdLessThanOrEqualTo(Long value) {
            addCriterion("PAR_OPTION_ID <=", value, "parOptionId");
            return (Criteria) this;
        }

        public Criteria andParOptionIdIn(List<Long> values) {
            addCriterion("PAR_OPTION_ID in", values, "parOptionId");
            return (Criteria) this;
        }

        public Criteria andParOptionIdNotIn(List<Long> values) {
            addCriterion("PAR_OPTION_ID not in", values, "parOptionId");
            return (Criteria) this;
        }

        public Criteria andParOptionIdBetween(Long value1, Long value2) {
            addCriterion("PAR_OPTION_ID between", value1, value2, "parOptionId");
            return (Criteria) this;
        }

        public Criteria andParOptionIdNotBetween(Long value1, Long value2) {
            addCriterion("PAR_OPTION_ID not between", value1, value2, "parOptionId");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("SCORE is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("SCORE is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("SCORE =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("SCORE <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("SCORE >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCORE >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("SCORE <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("SCORE <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("SCORE in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("SCORE not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("SCORE between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("SCORE not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("URL is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("URL is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("URL =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("URL <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("URL >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("URL >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("URL <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("URL <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("URL like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("URL not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("URL in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("URL not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("URL between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("URL not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("DATA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("DATA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("DATA_TYPE =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("DATA_TYPE <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("DATA_TYPE >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("DATA_TYPE <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("DATA_TYPE like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("DATA_TYPE not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("DATA_TYPE in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("DATA_TYPE not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("DATA_TYPE between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("DATA_TYPE not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andOptiondescIsNull() {
            addCriterion("OPTIONDESC is null");
            return (Criteria) this;
        }

        public Criteria andOptiondescIsNotNull() {
            addCriterion("OPTIONDESC is not null");
            return (Criteria) this;
        }

        public Criteria andOptiondescEqualTo(String value) {
            addCriterion("OPTIONDESC =", value, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescNotEqualTo(String value) {
            addCriterion("OPTIONDESC <>", value, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescGreaterThan(String value) {
            addCriterion("OPTIONDESC >", value, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescGreaterThanOrEqualTo(String value) {
            addCriterion("OPTIONDESC >=", value, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescLessThan(String value) {
            addCriterion("OPTIONDESC <", value, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescLessThanOrEqualTo(String value) {
            addCriterion("OPTIONDESC <=", value, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescLike(String value) {
            addCriterion("OPTIONDESC like", value, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescNotLike(String value) {
            addCriterion("OPTIONDESC not like", value, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescIn(List<String> values) {
            addCriterion("OPTIONDESC in", values, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescNotIn(List<String> values) {
            addCriterion("OPTIONDESC not in", values, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescBetween(String value1, String value2) {
            addCriterion("OPTIONDESC between", value1, value2, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptiondescNotBetween(String value1, String value2) {
            addCriterion("OPTIONDESC not between", value1, value2, "optiondesc");
            return (Criteria) this;
        }

        public Criteria andOptionnameIsNull() {
            addCriterion("OPTIONNAME is null");
            return (Criteria) this;
        }

        public Criteria andOptionnameIsNotNull() {
            addCriterion("OPTIONNAME is not null");
            return (Criteria) this;
        }

        public Criteria andOptionnameEqualTo(String value) {
            addCriterion("OPTIONNAME =", value, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameNotEqualTo(String value) {
            addCriterion("OPTIONNAME <>", value, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameGreaterThan(String value) {
            addCriterion("OPTIONNAME >", value, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameGreaterThanOrEqualTo(String value) {
            addCriterion("OPTIONNAME >=", value, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameLessThan(String value) {
            addCriterion("OPTIONNAME <", value, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameLessThanOrEqualTo(String value) {
            addCriterion("OPTIONNAME <=", value, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameLike(String value) {
            addCriterion("OPTIONNAME like", value, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameNotLike(String value) {
            addCriterion("OPTIONNAME not like", value, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameIn(List<String> values) {
            addCriterion("OPTIONNAME in", values, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameNotIn(List<String> values) {
            addCriterion("OPTIONNAME not in", values, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameBetween(String value1, String value2) {
            addCriterion("OPTIONNAME between", value1, value2, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnameNotBetween(String value1, String value2) {
            addCriterion("OPTIONNAME not between", value1, value2, "optionname");
            return (Criteria) this;
        }

        public Criteria andOptionnoIsNull() {
            addCriterion("OPTIONNO is null");
            return (Criteria) this;
        }

        public Criteria andOptionnoIsNotNull() {
            addCriterion("OPTIONNO is not null");
            return (Criteria) this;
        }

        public Criteria andOptionnoEqualTo(Integer value) {
            addCriterion("OPTIONNO =", value, "optionno");
            return (Criteria) this;
        }

        public Criteria andOptionnoNotEqualTo(Integer value) {
            addCriterion("OPTIONNO <>", value, "optionno");
            return (Criteria) this;
        }

        public Criteria andOptionnoGreaterThan(Integer value) {
            addCriterion("OPTIONNO >", value, "optionno");
            return (Criteria) this;
        }

        public Criteria andOptionnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("OPTIONNO >=", value, "optionno");
            return (Criteria) this;
        }

        public Criteria andOptionnoLessThan(Integer value) {
            addCriterion("OPTIONNO <", value, "optionno");
            return (Criteria) this;
        }

        public Criteria andOptionnoLessThanOrEqualTo(Integer value) {
            addCriterion("OPTIONNO <=", value, "optionno");
            return (Criteria) this;
        }

        public Criteria andOptionnoIn(List<Integer> values) {
            addCriterion("OPTIONNO in", values, "optionno");
            return (Criteria) this;
        }

        public Criteria andOptionnoNotIn(List<Integer> values) {
            addCriterion("OPTIONNO not in", values, "optionno");
            return (Criteria) this;
        }

        public Criteria andOptionnoBetween(Integer value1, Integer value2) {
            addCriterion("OPTIONNO between", value1, value2, "optionno");
            return (Criteria) this;
        }

        public Criteria andOptionnoNotBetween(Integer value1, Integer value2) {
            addCriterion("OPTIONNO not between", value1, value2, "optionno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNull() {
            addCriterion("ORDERNO is null");
            return (Criteria) this;
        }

        public Criteria andOrdernoIsNotNull() {
            addCriterion("ORDERNO is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernoEqualTo(Integer value) {
            addCriterion("ORDERNO =", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotEqualTo(Integer value) {
            addCriterion("ORDERNO <>", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThan(Integer value) {
            addCriterion("ORDERNO >", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORDERNO >=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThan(Integer value) {
            addCriterion("ORDERNO <", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoLessThanOrEqualTo(Integer value) {
            addCriterion("ORDERNO <=", value, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoIn(List<Integer> values) {
            addCriterion("ORDERNO in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotIn(List<Integer> values) {
            addCriterion("ORDERNO not in", values, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoBetween(Integer value1, Integer value2) {
            addCriterion("ORDERNO between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andOrdernoNotBetween(Integer value1, Integer value2) {
            addCriterion("ORDERNO not between", value1, value2, "orderno");
            return (Criteria) this;
        }

        public Criteria andSitemcodeIsNull() {
            addCriterion("SITEMCODE is null");
            return (Criteria) this;
        }

        public Criteria andSitemcodeIsNotNull() {
            addCriterion("SITEMCODE is not null");
            return (Criteria) this;
        }

        public Criteria andSitemcodeEqualTo(String value) {
            addCriterion("SITEMCODE =", value, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeNotEqualTo(String value) {
            addCriterion("SITEMCODE <>", value, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeGreaterThan(String value) {
            addCriterion("SITEMCODE >", value, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeGreaterThanOrEqualTo(String value) {
            addCriterion("SITEMCODE >=", value, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeLessThan(String value) {
            addCriterion("SITEMCODE <", value, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeLessThanOrEqualTo(String value) {
            addCriterion("SITEMCODE <=", value, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeLike(String value) {
            addCriterion("SITEMCODE like", value, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeNotLike(String value) {
            addCriterion("SITEMCODE not like", value, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeIn(List<String> values) {
            addCriterion("SITEMCODE in", values, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeNotIn(List<String> values) {
            addCriterion("SITEMCODE not in", values, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeBetween(String value1, String value2) {
            addCriterion("SITEMCODE between", value1, value2, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andSitemcodeNotBetween(String value1, String value2) {
            addCriterion("SITEMCODE not between", value1, value2, "sitemcode");
            return (Criteria) this;
        }

        public Criteria andActionIsNull() {
            addCriterion("ACTION is null");
            return (Criteria) this;
        }

        public Criteria andActionIsNotNull() {
            addCriterion("ACTION is not null");
            return (Criteria) this;
        }

        public Criteria andActionEqualTo(String value) {
            addCriterion("ACTION =", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotEqualTo(String value) {
            addCriterion("ACTION <>", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThan(String value) {
            addCriterion("ACTION >", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionGreaterThanOrEqualTo(String value) {
            addCriterion("ACTION >=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThan(String value) {
            addCriterion("ACTION <", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLessThanOrEqualTo(String value) {
            addCriterion("ACTION <=", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionLike(String value) {
            addCriterion("ACTION like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotLike(String value) {
            addCriterion("ACTION not like", value, "action");
            return (Criteria) this;
        }

        public Criteria andActionIn(List<String> values) {
            addCriterion("ACTION in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotIn(List<String> values) {
            addCriterion("ACTION not in", values, "action");
            return (Criteria) this;
        }

        public Criteria andActionBetween(String value1, String value2) {
            addCriterion("ACTION between", value1, value2, "action");
            return (Criteria) this;
        }

        public Criteria andActionNotBetween(String value1, String value2) {
            addCriterion("ACTION not between", value1, value2, "action");
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