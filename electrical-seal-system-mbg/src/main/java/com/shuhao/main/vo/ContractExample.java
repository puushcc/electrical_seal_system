package com.shuhao.main.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ContractExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ContractExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(Integer value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(Integer value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(Integer value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(Integer value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(Integer value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<Integer> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<Integer> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(Integer value1, Integer value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNull() {
            addCriterion("contract_name is null");
            return (Criteria) this;
        }

        public Criteria andContractNameIsNotNull() {
            addCriterion("contract_name is not null");
            return (Criteria) this;
        }

        public Criteria andContractNameEqualTo(String value) {
            addCriterion("contract_name =", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotEqualTo(String value) {
            addCriterion("contract_name <>", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThan(String value) {
            addCriterion("contract_name >", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameGreaterThanOrEqualTo(String value) {
            addCriterion("contract_name >=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThan(String value) {
            addCriterion("contract_name <", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLessThanOrEqualTo(String value) {
            addCriterion("contract_name <=", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameLike(String value) {
            addCriterion("contract_name like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotLike(String value) {
            addCriterion("contract_name not like", value, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameIn(List<String> values) {
            addCriterion("contract_name in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotIn(List<String> values) {
            addCriterion("contract_name not in", values, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameBetween(String value1, String value2) {
            addCriterion("contract_name between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractNameNotBetween(String value1, String value2) {
            addCriterion("contract_name not between", value1, value2, "contractName");
            return (Criteria) this;
        }

        public Criteria andContractFileIsNull() {
            addCriterion("contract_file is null");
            return (Criteria) this;
        }

        public Criteria andContractFileIsNotNull() {
            addCriterion("contract_file is not null");
            return (Criteria) this;
        }

        public Criteria andContractFileEqualTo(String value) {
            addCriterion("contract_file =", value, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileNotEqualTo(String value) {
            addCriterion("contract_file <>", value, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileGreaterThan(String value) {
            addCriterion("contract_file >", value, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileGreaterThanOrEqualTo(String value) {
            addCriterion("contract_file >=", value, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileLessThan(String value) {
            addCriterion("contract_file <", value, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileLessThanOrEqualTo(String value) {
            addCriterion("contract_file <=", value, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileLike(String value) {
            addCriterion("contract_file like", value, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileNotLike(String value) {
            addCriterion("contract_file not like", value, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileIn(List<String> values) {
            addCriterion("contract_file in", values, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileNotIn(List<String> values) {
            addCriterion("contract_file not in", values, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileBetween(String value1, String value2) {
            addCriterion("contract_file between", value1, value2, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractFileNotBetween(String value1, String value2) {
            addCriterion("contract_file not between", value1, value2, "contractFile");
            return (Criteria) this;
        }

        public Criteria andContractSponsorIsNull() {
            addCriterion("contract_sponsor is null");
            return (Criteria) this;
        }

        public Criteria andContractSponsorIsNotNull() {
            addCriterion("contract_sponsor is not null");
            return (Criteria) this;
        }

        public Criteria andContractSponsorEqualTo(String value) {
            addCriterion("contract_sponsor =", value, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorNotEqualTo(String value) {
            addCriterion("contract_sponsor <>", value, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorGreaterThan(String value) {
            addCriterion("contract_sponsor >", value, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorGreaterThanOrEqualTo(String value) {
            addCriterion("contract_sponsor >=", value, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorLessThan(String value) {
            addCriterion("contract_sponsor <", value, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorLessThanOrEqualTo(String value) {
            addCriterion("contract_sponsor <=", value, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorLike(String value) {
            addCriterion("contract_sponsor like", value, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorNotLike(String value) {
            addCriterion("contract_sponsor not like", value, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorIn(List<String> values) {
            addCriterion("contract_sponsor in", values, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorNotIn(List<String> values) {
            addCriterion("contract_sponsor not in", values, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorBetween(String value1, String value2) {
            addCriterion("contract_sponsor between", value1, value2, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractSponsorNotBetween(String value1, String value2) {
            addCriterion("contract_sponsor not between", value1, value2, "contractSponsor");
            return (Criteria) this;
        }

        public Criteria andContractReceiverIsNull() {
            addCriterion("contract_receiver is null");
            return (Criteria) this;
        }

        public Criteria andContractReceiverIsNotNull() {
            addCriterion("contract_receiver is not null");
            return (Criteria) this;
        }

        public Criteria andContractReceiverEqualTo(String value) {
            addCriterion("contract_receiver =", value, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverNotEqualTo(String value) {
            addCriterion("contract_receiver <>", value, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverGreaterThan(String value) {
            addCriterion("contract_receiver >", value, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("contract_receiver >=", value, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverLessThan(String value) {
            addCriterion("contract_receiver <", value, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverLessThanOrEqualTo(String value) {
            addCriterion("contract_receiver <=", value, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverLike(String value) {
            addCriterion("contract_receiver like", value, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverNotLike(String value) {
            addCriterion("contract_receiver not like", value, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverIn(List<String> values) {
            addCriterion("contract_receiver in", values, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverNotIn(List<String> values) {
            addCriterion("contract_receiver not in", values, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverBetween(String value1, String value2) {
            addCriterion("contract_receiver between", value1, value2, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractReceiverNotBetween(String value1, String value2) {
            addCriterion("contract_receiver not between", value1, value2, "contractReceiver");
            return (Criteria) this;
        }

        public Criteria andContractDateIsNull() {
            addCriterion("contract_date is null");
            return (Criteria) this;
        }

        public Criteria andContractDateIsNotNull() {
            addCriterion("contract_date is not null");
            return (Criteria) this;
        }

        public Criteria andContractDateEqualTo(Date value) {
            addCriterionForJDBCDate("contract_date =", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("contract_date <>", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateGreaterThan(Date value) {
            addCriterionForJDBCDate("contract_date >", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("contract_date >=", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateLessThan(Date value) {
            addCriterionForJDBCDate("contract_date <", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("contract_date <=", value, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateIn(List<Date> values) {
            addCriterionForJDBCDate("contract_date in", values, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("contract_date not in", values, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("contract_date between", value1, value2, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("contract_date not between", value1, value2, "contractDate");
            return (Criteria) this;
        }

        public Criteria andContractStatusIsNull() {
            addCriterion("contract_status is null");
            return (Criteria) this;
        }

        public Criteria andContractStatusIsNotNull() {
            addCriterion("contract_status is not null");
            return (Criteria) this;
        }

        public Criteria andContractStatusEqualTo(String value) {
            addCriterion("contract_status =", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotEqualTo(String value) {
            addCriterion("contract_status <>", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusGreaterThan(String value) {
            addCriterion("contract_status >", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusGreaterThanOrEqualTo(String value) {
            addCriterion("contract_status >=", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusLessThan(String value) {
            addCriterion("contract_status <", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusLessThanOrEqualTo(String value) {
            addCriterion("contract_status <=", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusLike(String value) {
            addCriterion("contract_status like", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotLike(String value) {
            addCriterion("contract_status not like", value, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusIn(List<String> values) {
            addCriterion("contract_status in", values, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotIn(List<String> values) {
            addCriterion("contract_status not in", values, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusBetween(String value1, String value2) {
            addCriterion("contract_status between", value1, value2, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractStatusNotBetween(String value1, String value2) {
            addCriterion("contract_status not between", value1, value2, "contractStatus");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeIsNull() {
            addCriterion("contract_createTime is null");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeIsNotNull() {
            addCriterion("contract_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeEqualTo(Date value) {
            addCriterion("contract_createTime =", value, "contractCreatetime");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeNotEqualTo(Date value) {
            addCriterion("contract_createTime <>", value, "contractCreatetime");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeGreaterThan(Date value) {
            addCriterion("contract_createTime >", value, "contractCreatetime");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("contract_createTime >=", value, "contractCreatetime");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeLessThan(Date value) {
            addCriterion("contract_createTime <", value, "contractCreatetime");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("contract_createTime <=", value, "contractCreatetime");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeIn(List<Date> values) {
            addCriterion("contract_createTime in", values, "contractCreatetime");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeNotIn(List<Date> values) {
            addCriterion("contract_createTime not in", values, "contractCreatetime");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeBetween(Date value1, Date value2) {
            addCriterion("contract_createTime between", value1, value2, "contractCreatetime");
            return (Criteria) this;
        }

        public Criteria andContractCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("contract_createTime not between", value1, value2, "contractCreatetime");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeIsNull() {
            addCriterion("contract_completeTime is null");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeIsNotNull() {
            addCriterion("contract_completeTime is not null");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeEqualTo(Date value) {
            addCriterion("contract_completeTime =", value, "contractCompletetime");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeNotEqualTo(Date value) {
            addCriterion("contract_completeTime <>", value, "contractCompletetime");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeGreaterThan(Date value) {
            addCriterion("contract_completeTime >", value, "contractCompletetime");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("contract_completeTime >=", value, "contractCompletetime");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeLessThan(Date value) {
            addCriterion("contract_completeTime <", value, "contractCompletetime");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeLessThanOrEqualTo(Date value) {
            addCriterion("contract_completeTime <=", value, "contractCompletetime");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeIn(List<Date> values) {
            addCriterion("contract_completeTime in", values, "contractCompletetime");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeNotIn(List<Date> values) {
            addCriterion("contract_completeTime not in", values, "contractCompletetime");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeBetween(Date value1, Date value2) {
            addCriterion("contract_completeTime between", value1, value2, "contractCompletetime");
            return (Criteria) this;
        }

        public Criteria andContractCompletetimeNotBetween(Date value1, Date value2) {
            addCriterion("contract_completeTime not between", value1, value2, "contractCompletetime");
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