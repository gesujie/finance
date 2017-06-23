package com.jibinfo.finance.entity.surveys;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jibinfo.framework.page.Paginator;

public class SurveysQuestionsExample implements Serializable {
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

    public SurveysQuestionsExample() {
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

        public Criteria andSurveyCodeIsNull() {
            addCriterion("SURVEY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeIsNotNull() {
            addCriterion("SURVEY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeEqualTo(String value) {
            addCriterion("SURVEY_CODE =", value, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeNotEqualTo(String value) {
            addCriterion("SURVEY_CODE <>", value, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeGreaterThan(String value) {
            addCriterion("SURVEY_CODE >", value, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SURVEY_CODE >=", value, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeLessThan(String value) {
            addCriterion("SURVEY_CODE <", value, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeLessThanOrEqualTo(String value) {
            addCriterion("SURVEY_CODE <=", value, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeLike(String value) {
            addCriterion("SURVEY_CODE like", value, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeNotLike(String value) {
            addCriterion("SURVEY_CODE not like", value, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeIn(List<String> values) {
            addCriterion("SURVEY_CODE in", values, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeNotIn(List<String> values) {
            addCriterion("SURVEY_CODE not in", values, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeBetween(String value1, String value2) {
            addCriterion("SURVEY_CODE between", value1, value2, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andSurveyCodeNotBetween(String value1, String value2) {
            addCriterion("SURVEY_CODE not between", value1, value2, "surveyCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeIsNull() {
            addCriterion("QUESTION_CODE is null");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeIsNotNull() {
            addCriterion("QUESTION_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeEqualTo(String value) {
            addCriterion("QUESTION_CODE =", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeNotEqualTo(String value) {
            addCriterion("QUESTION_CODE <>", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeGreaterThan(String value) {
            addCriterion("QUESTION_CODE >", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_CODE >=", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeLessThan(String value) {
            addCriterion("QUESTION_CODE <", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_CODE <=", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeLike(String value) {
            addCriterion("QUESTION_CODE like", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeNotLike(String value) {
            addCriterion("QUESTION_CODE not like", value, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeIn(List<String> values) {
            addCriterion("QUESTION_CODE in", values, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeNotIn(List<String> values) {
            addCriterion("QUESTION_CODE not in", values, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeBetween(String value1, String value2) {
            addCriterion("QUESTION_CODE between", value1, value2, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionCodeNotBetween(String value1, String value2) {
            addCriterion("QUESTION_CODE not between", value1, value2, "questionCode");
            return (Criteria) this;
        }

        public Criteria andQuestionDescIsNull() {
            addCriterion("QUESTION_DESC is null");
            return (Criteria) this;
        }

        public Criteria andQuestionDescIsNotNull() {
            addCriterion("QUESTION_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionDescEqualTo(String value) {
            addCriterion("QUESTION_DESC =", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescNotEqualTo(String value) {
            addCriterion("QUESTION_DESC <>", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescGreaterThan(String value) {
            addCriterion("QUESTION_DESC >", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescGreaterThanOrEqualTo(String value) {
            addCriterion("QUESTION_DESC >=", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescLessThan(String value) {
            addCriterion("QUESTION_DESC <", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescLessThanOrEqualTo(String value) {
            addCriterion("QUESTION_DESC <=", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescLike(String value) {
            addCriterion("QUESTION_DESC like", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescNotLike(String value) {
            addCriterion("QUESTION_DESC not like", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescIn(List<String> values) {
            addCriterion("QUESTION_DESC in", values, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescNotIn(List<String> values) {
            addCriterion("QUESTION_DESC not in", values, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescBetween(String value1, String value2) {
            addCriterion("QUESTION_DESC between", value1, value2, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescNotBetween(String value1, String value2) {
            addCriterion("QUESTION_DESC not between", value1, value2, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionIsNull() {
            addCriterion("ANSWER_OPTION is null");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionIsNotNull() {
            addCriterion("ANSWER_OPTION is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionEqualTo(String value) {
            addCriterion("ANSWER_OPTION =", value, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionNotEqualTo(String value) {
            addCriterion("ANSWER_OPTION <>", value, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionGreaterThan(String value) {
            addCriterion("ANSWER_OPTION >", value, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionGreaterThanOrEqualTo(String value) {
            addCriterion("ANSWER_OPTION >=", value, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionLessThan(String value) {
            addCriterion("ANSWER_OPTION <", value, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionLessThanOrEqualTo(String value) {
            addCriterion("ANSWER_OPTION <=", value, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionLike(String value) {
            addCriterion("ANSWER_OPTION like", value, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionNotLike(String value) {
            addCriterion("ANSWER_OPTION not like", value, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionIn(List<String> values) {
            addCriterion("ANSWER_OPTION in", values, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionNotIn(List<String> values) {
            addCriterion("ANSWER_OPTION not in", values, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionBetween(String value1, String value2) {
            addCriterion("ANSWER_OPTION between", value1, value2, "answerOption");
            return (Criteria) this;
        }

        public Criteria andAnswerOptionNotBetween(String value1, String value2) {
            addCriterion("ANSWER_OPTION not between", value1, value2, "answerOption");
            return (Criteria) this;
        }

        public Criteria andOptionDescIsNull() {
            addCriterion("OPTION_DESC is null");
            return (Criteria) this;
        }

        public Criteria andOptionDescIsNotNull() {
            addCriterion("OPTION_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andOptionDescEqualTo(String value) {
            addCriterion("OPTION_DESC =", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescNotEqualTo(String value) {
            addCriterion("OPTION_DESC <>", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescGreaterThan(String value) {
            addCriterion("OPTION_DESC >", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescGreaterThanOrEqualTo(String value) {
            addCriterion("OPTION_DESC >=", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescLessThan(String value) {
            addCriterion("OPTION_DESC <", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescLessThanOrEqualTo(String value) {
            addCriterion("OPTION_DESC <=", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescLike(String value) {
            addCriterion("OPTION_DESC like", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescNotLike(String value) {
            addCriterion("OPTION_DESC not like", value, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescIn(List<String> values) {
            addCriterion("OPTION_DESC in", values, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescNotIn(List<String> values) {
            addCriterion("OPTION_DESC not in", values, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescBetween(String value1, String value2) {
            addCriterion("OPTION_DESC between", value1, value2, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andOptionDescNotBetween(String value1, String value2) {
            addCriterion("OPTION_DESC not between", value1, value2, "optionDesc");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andFcodeIsNull() {
            addCriterion("FCODE is null");
            return (Criteria) this;
        }

        public Criteria andFcodeIsNotNull() {
            addCriterion("FCODE is not null");
            return (Criteria) this;
        }

        public Criteria andFcodeEqualTo(String value) {
            addCriterion("FCODE =", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotEqualTo(String value) {
            addCriterion("FCODE <>", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeGreaterThan(String value) {
            addCriterion("FCODE >", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeGreaterThanOrEqualTo(String value) {
            addCriterion("FCODE >=", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLessThan(String value) {
            addCriterion("FCODE <", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLessThanOrEqualTo(String value) {
            addCriterion("FCODE <=", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLike(String value) {
            addCriterion("FCODE like", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotLike(String value) {
            addCriterion("FCODE not like", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeIn(List<String> values) {
            addCriterion("FCODE in", values, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotIn(List<String> values) {
            addCriterion("FCODE not in", values, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeBetween(String value1, String value2) {
            addCriterion("FCODE between", value1, value2, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotBetween(String value1, String value2) {
            addCriterion("FCODE not between", value1, value2, "fcode");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
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