package com.shuhao.main.vo;

import java.util.ArrayList;
import java.util.List;

public class SealEnterpriseStatsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SealEnterpriseStatsExample() {
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

        public Criteria andEnterpriseStatsNameIsNull() {
            addCriterion("enterprise_stats_name is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameIsNotNull() {
            addCriterion("enterprise_stats_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameEqualTo(String value) {
            addCriterion("enterprise_stats_name =", value, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameNotEqualTo(String value) {
            addCriterion("enterprise_stats_name <>", value, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameGreaterThan(String value) {
            addCriterion("enterprise_stats_name >", value, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_stats_name >=", value, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameLessThan(String value) {
            addCriterion("enterprise_stats_name <", value, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameLessThanOrEqualTo(String value) {
            addCriterion("enterprise_stats_name <=", value, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameLike(String value) {
            addCriterion("enterprise_stats_name like", value, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameNotLike(String value) {
            addCriterion("enterprise_stats_name not like", value, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameIn(List<String> values) {
            addCriterion("enterprise_stats_name in", values, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameNotIn(List<String> values) {
            addCriterion("enterprise_stats_name not in", values, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameBetween(String value1, String value2) {
            addCriterion("enterprise_stats_name between", value1, value2, "enterpriseStatsName");
            return (Criteria) this;
        }

        public Criteria andEnterpriseStatsNameNotBetween(String value1, String value2) {
            addCriterion("enterprise_stats_name not between", value1, value2, "enterpriseStatsName");
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