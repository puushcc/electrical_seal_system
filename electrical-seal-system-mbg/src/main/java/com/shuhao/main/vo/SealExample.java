package com.shuhao.main.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SealExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SealExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andSealIdIsNull() {
            addCriterion("seal_id is null");
            return (Criteria) this;
        }

        public Criteria andSealIdIsNotNull() {
            addCriterion("seal_id is not null");
            return (Criteria) this;
        }

        public Criteria andSealIdEqualTo(Integer value) {
            addCriterion("seal_id =", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdNotEqualTo(Integer value) {
            addCriterion("seal_id <>", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdGreaterThan(Integer value) {
            addCriterion("seal_id >", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("seal_id >=", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdLessThan(Integer value) {
            addCriterion("seal_id <", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdLessThanOrEqualTo(Integer value) {
            addCriterion("seal_id <=", value, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdIn(List<Integer> values) {
            addCriterion("seal_id in", values, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdNotIn(List<Integer> values) {
            addCriterion("seal_id not in", values, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdBetween(Integer value1, Integer value2) {
            addCriterion("seal_id between", value1, value2, "sealId");
            return (Criteria) this;
        }

        public Criteria andSealIdNotBetween(Integer value1, Integer value2) {
            addCriterion("seal_id not between", value1, value2, "sealId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSealUrlIsNull() {
            addCriterion("seal_url is null");
            return (Criteria) this;
        }

        public Criteria andSealUrlIsNotNull() {
            addCriterion("seal_url is not null");
            return (Criteria) this;
        }

        public Criteria andSealUrlEqualTo(String value) {
            addCriterion("seal_url =", value, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlNotEqualTo(String value) {
            addCriterion("seal_url <>", value, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlGreaterThan(String value) {
            addCriterion("seal_url >", value, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlGreaterThanOrEqualTo(String value) {
            addCriterion("seal_url >=", value, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlLessThan(String value) {
            addCriterion("seal_url <", value, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlLessThanOrEqualTo(String value) {
            addCriterion("seal_url <=", value, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlLike(String value) {
            addCriterion("seal_url like", value, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlNotLike(String value) {
            addCriterion("seal_url not like", value, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlIn(List<String> values) {
            addCriterion("seal_url in", values, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlNotIn(List<String> values) {
            addCriterion("seal_url not in", values, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlBetween(String value1, String value2) {
            addCriterion("seal_url between", value1, value2, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealUrlNotBetween(String value1, String value2) {
            addCriterion("seal_url not between", value1, value2, "sealUrl");
            return (Criteria) this;
        }

        public Criteria andSealNameIsNull() {
            addCriterion("seal_name is null");
            return (Criteria) this;
        }

        public Criteria andSealNameIsNotNull() {
            addCriterion("seal_name is not null");
            return (Criteria) this;
        }

        public Criteria andSealNameEqualTo(String value) {
            addCriterion("seal_name =", value, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameNotEqualTo(String value) {
            addCriterion("seal_name <>", value, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameGreaterThan(String value) {
            addCriterion("seal_name >", value, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameGreaterThanOrEqualTo(String value) {
            addCriterion("seal_name >=", value, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameLessThan(String value) {
            addCriterion("seal_name <", value, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameLessThanOrEqualTo(String value) {
            addCriterion("seal_name <=", value, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameLike(String value) {
            addCriterion("seal_name like", value, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameNotLike(String value) {
            addCriterion("seal_name not like", value, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameIn(List<String> values) {
            addCriterion("seal_name in", values, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameNotIn(List<String> values) {
            addCriterion("seal_name not in", values, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameBetween(String value1, String value2) {
            addCriterion("seal_name between", value1, value2, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNameNotBetween(String value1, String value2) {
            addCriterion("seal_name not between", value1, value2, "sealName");
            return (Criteria) this;
        }

        public Criteria andSealNumIsNull() {
            addCriterion("seal_num is null");
            return (Criteria) this;
        }

        public Criteria andSealNumIsNotNull() {
            addCriterion("seal_num is not null");
            return (Criteria) this;
        }

        public Criteria andSealNumEqualTo(String value) {
            addCriterion("seal_num =", value, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumNotEqualTo(String value) {
            addCriterion("seal_num <>", value, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumGreaterThan(String value) {
            addCriterion("seal_num >", value, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumGreaterThanOrEqualTo(String value) {
            addCriterion("seal_num >=", value, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumLessThan(String value) {
            addCriterion("seal_num <", value, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumLessThanOrEqualTo(String value) {
            addCriterion("seal_num <=", value, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumLike(String value) {
            addCriterion("seal_num like", value, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumNotLike(String value) {
            addCriterion("seal_num not like", value, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumIn(List<String> values) {
            addCriterion("seal_num in", values, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumNotIn(List<String> values) {
            addCriterion("seal_num not in", values, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumBetween(String value1, String value2) {
            addCriterion("seal_num between", value1, value2, "sealNum");
            return (Criteria) this;
        }

        public Criteria andSealNumNotBetween(String value1, String value2) {
            addCriterion("seal_num not between", value1, value2, "sealNum");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampIsNull() {
            addCriterion("create_timestamp is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampIsNotNull() {
            addCriterion("create_timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampEqualTo(Date value) {
            addCriterion("create_timestamp =", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampNotEqualTo(Date value) {
            addCriterion("create_timestamp <>", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampGreaterThan(Date value) {
            addCriterion("create_timestamp >", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("create_timestamp >=", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampLessThan(Date value) {
            addCriterion("create_timestamp <", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampLessThanOrEqualTo(Date value) {
            addCriterion("create_timestamp <=", value, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampIn(List<Date> values) {
            addCriterion("create_timestamp in", values, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampNotIn(List<Date> values) {
            addCriterion("create_timestamp not in", values, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampBetween(Date value1, Date value2) {
            addCriterion("create_timestamp between", value1, value2, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andCreateTimestampNotBetween(Date value1, Date value2) {
            addCriterion("create_timestamp not between", value1, value2, "createTimestamp");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("State is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("State is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("State =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("State <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("State >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("State >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("State <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("State <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("State like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("State not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("State in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("State not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("State between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("State not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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