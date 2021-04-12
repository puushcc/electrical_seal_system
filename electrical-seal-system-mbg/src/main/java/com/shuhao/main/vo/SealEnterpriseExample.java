package com.shuhao.main.vo;

import java.util.ArrayList;
import java.util.List;

public class SealEnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SealEnterpriseExample() {
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

        public Criteria andEnterpriseIdIsNull() {
            addCriterion("enterprise_id is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIsNotNull() {
            addCriterion("enterprise_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdEqualTo(Integer value) {
            addCriterion("enterprise_id =", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotEqualTo(Integer value) {
            addCriterion("enterprise_id <>", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThan(Integer value) {
            addCriterion("enterprise_id >", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id >=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThan(Integer value) {
            addCriterion("enterprise_id <", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_id <=", value, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdIn(List<Integer> values) {
            addCriterion("enterprise_id in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotIn(List<Integer> values) {
            addCriterion("enterprise_id not in", values, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id between", value1, value2, "enterpriseId");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_id not between", value1, value2, "enterpriseId");
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

        public Criteria andEnterpriseNameIsNull() {
            addCriterion("enterprise_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIsNotNull() {
            addCriterion("enterprise_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameEqualTo(String value) {
            addCriterion("enterprise_name =", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotEqualTo(String value) {
            addCriterion("enterprise_name <>", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThan(String value) {
            addCriterion("enterprise_name >", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_name >=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThan(String value) {
            addCriterion("enterprise_name <", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_name <=", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameLike(String value) {
            addCriterion("enterprise_name like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotLike(String value) {
            addCriterion("enterprise_name not like", value, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameIn(List<String> values) {
            addCriterion("enterprise_name in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotIn(List<String> values) {
            addCriterion("enterprise_name not in", values, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameBetween(String value1, String value2) {
            addCriterion("enterprise_name between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_name not between", value1, value2, "enterpriseName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryIsNull() {
            addCriterion("enterprise_industry is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryIsNotNull() {
            addCriterion("enterprise_industry is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryEqualTo(String value) {
            addCriterion("enterprise_industry =", value, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryNotEqualTo(String value) {
            addCriterion("enterprise_industry <>", value, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryGreaterThan(String value) {
            addCriterion("enterprise_industry >", value, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_industry >=", value, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryLessThan(String value) {
            addCriterion("enterprise_industry <", value, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryLessThanOrEqualTo(String value) {
            addCriterion("enterprise_industry <=", value, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryLike(String value) {
            addCriterion("enterprise_industry like", value, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryNotLike(String value) {
            addCriterion("enterprise_industry not like", value, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryIn(List<String> values) {
            addCriterion("enterprise_industry in", values, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryNotIn(List<String> values) {
            addCriterion("enterprise_industry not in", values, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryBetween(String value1, String value2) {
            addCriterion("enterprise_industry between", value1, value2, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseIndustryNotBetween(String value1, String value2) {
            addCriterion("enterprise_industry not between", value1, value2, "enterpriseIndustry");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalIsNull() {
            addCriterion("enterprise_local is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalIsNotNull() {
            addCriterion("enterprise_local is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalEqualTo(String value) {
            addCriterion("enterprise_local =", value, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalNotEqualTo(String value) {
            addCriterion("enterprise_local <>", value, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalGreaterThan(String value) {
            addCriterion("enterprise_local >", value, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_local >=", value, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalLessThan(String value) {
            addCriterion("enterprise_local <", value, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalLessThanOrEqualTo(String value) {
            addCriterion("enterprise_local <=", value, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalLike(String value) {
            addCriterion("enterprise_local like", value, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalNotLike(String value) {
            addCriterion("enterprise_local not like", value, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalIn(List<String> values) {
            addCriterion("enterprise_local in", values, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalNotIn(List<String> values) {
            addCriterion("enterprise_local not in", values, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalBetween(String value1, String value2) {
            addCriterion("enterprise_local between", value1, value2, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseLocalNotBetween(String value1, String value2) {
            addCriterion("enterprise_local not between", value1, value2, "enterpriseLocal");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityIsNull() {
            addCriterion("enterprise_city is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityIsNotNull() {
            addCriterion("enterprise_city is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityEqualTo(String value) {
            addCriterion("enterprise_city =", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityNotEqualTo(String value) {
            addCriterion("enterprise_city <>", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityGreaterThan(String value) {
            addCriterion("enterprise_city >", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_city >=", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityLessThan(String value) {
            addCriterion("enterprise_city <", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityLessThanOrEqualTo(String value) {
            addCriterion("enterprise_city <=", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityLike(String value) {
            addCriterion("enterprise_city like", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityNotLike(String value) {
            addCriterion("enterprise_city not like", value, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityIn(List<String> values) {
            addCriterion("enterprise_city in", values, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityNotIn(List<String> values) {
            addCriterion("enterprise_city not in", values, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityBetween(String value1, String value2) {
            addCriterion("enterprise_city between", value1, value2, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCityNotBetween(String value1, String value2) {
            addCriterion("enterprise_city not between", value1, value2, "enterpriseCity");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessIsNull() {
            addCriterion("enterprise_business is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessIsNotNull() {
            addCriterion("enterprise_business is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessEqualTo(String value) {
            addCriterion("enterprise_business =", value, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessNotEqualTo(String value) {
            addCriterion("enterprise_business <>", value, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessGreaterThan(String value) {
            addCriterion("enterprise_business >", value, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_business >=", value, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessLessThan(String value) {
            addCriterion("enterprise_business <", value, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessLessThanOrEqualTo(String value) {
            addCriterion("enterprise_business <=", value, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessLike(String value) {
            addCriterion("enterprise_business like", value, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessNotLike(String value) {
            addCriterion("enterprise_business not like", value, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessIn(List<String> values) {
            addCriterion("enterprise_business in", values, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessNotIn(List<String> values) {
            addCriterion("enterprise_business not in", values, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessBetween(String value1, String value2) {
            addCriterion("enterprise_business between", value1, value2, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseBusinessNotBetween(String value1, String value2) {
            addCriterion("enterprise_business not between", value1, value2, "enterpriseBusiness");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeIsNull() {
            addCriterion("enterprise_code is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeIsNotNull() {
            addCriterion("enterprise_code is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeEqualTo(String value) {
            addCriterion("enterprise_code =", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotEqualTo(String value) {
            addCriterion("enterprise_code <>", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeGreaterThan(String value) {
            addCriterion("enterprise_code >", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_code >=", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeLessThan(String value) {
            addCriterion("enterprise_code <", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeLessThanOrEqualTo(String value) {
            addCriterion("enterprise_code <=", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeLike(String value) {
            addCriterion("enterprise_code like", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotLike(String value) {
            addCriterion("enterprise_code not like", value, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeIn(List<String> values) {
            addCriterion("enterprise_code in", values, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotIn(List<String> values) {
            addCriterion("enterprise_code not in", values, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeBetween(String value1, String value2) {
            addCriterion("enterprise_code between", value1, value2, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCodeNotBetween(String value1, String value2) {
            addCriterion("enterprise_code not between", value1, value2, "enterpriseCode");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserIsNull() {
            addCriterion("enterprise_user is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserIsNotNull() {
            addCriterion("enterprise_user is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserEqualTo(String value) {
            addCriterion("enterprise_user =", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserNotEqualTo(String value) {
            addCriterion("enterprise_user <>", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserGreaterThan(String value) {
            addCriterion("enterprise_user >", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_user >=", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserLessThan(String value) {
            addCriterion("enterprise_user <", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserLessThanOrEqualTo(String value) {
            addCriterion("enterprise_user <=", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserLike(String value) {
            addCriterion("enterprise_user like", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserNotLike(String value) {
            addCriterion("enterprise_user not like", value, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserIn(List<String> values) {
            addCriterion("enterprise_user in", values, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserNotIn(List<String> values) {
            addCriterion("enterprise_user not in", values, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserBetween(String value1, String value2) {
            addCriterion("enterprise_user between", value1, value2, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseUserNotBetween(String value1, String value2) {
            addCriterion("enterprise_user not between", value1, value2, "enterpriseUser");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsIsNull() {
            addCriterion("enterprise_stats is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsIsNotNull() {
            addCriterion("enterprise_stats is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsEqualTo(Integer value) {
            addCriterion("enterprise_stats =", value, "enterpriseStats");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNotEqualTo(Integer value) {
            addCriterion("enterprise_stats <>", value, "enterpriseStats");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsGreaterThan(Integer value) {
            addCriterion("enterprise_stats >", value, "enterpriseStats");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsGreaterThanOrEqualTo(Integer value) {
            addCriterion("enterprise_stats >=", value, "enterpriseStats");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsLessThan(Integer value) {
            addCriterion("enterprise_stats <", value, "enterpriseStats");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsLessThanOrEqualTo(Integer value) {
            addCriterion("enterprise_stats <=", value, "enterpriseStats");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsIn(List<Integer> values) {
            addCriterion("enterprise_stats in", values, "enterpriseStats");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNotIn(List<Integer> values) {
            addCriterion("enterprise_stats not in", values, "enterpriseStats");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_stats between", value1, value2, "enterpriseStats");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNotBetween(Integer value1, Integer value2) {
            addCriterion("enterprise_stats not between", value1, value2, "enterpriseStats");
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