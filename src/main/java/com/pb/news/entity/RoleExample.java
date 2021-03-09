package com.pb.news.entity;

import java.util.ArrayList;
import java.util.List;

public class RoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNull() {
            addCriterion("role_code is null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNotNull() {
            addCriterion("role_code is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeEqualTo(String value) {
            addCriterion("role_code =", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotEqualTo(String value) {
            addCriterion("role_code <>", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThan(String value) {
            addCriterion("role_code >", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("role_code >=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThan(String value) {
            addCriterion("role_code <", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThanOrEqualTo(String value) {
            addCriterion("role_code <=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLike(String value) {
            addCriterion("role_code like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotLike(String value) {
            addCriterion("role_code not like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIn(List<String> values) {
            addCriterion("role_code in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotIn(List<String> values) {
            addCriterion("role_code not in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeBetween(String value1, String value2) {
            addCriterion("role_code between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotBetween(String value1, String value2) {
            addCriterion("role_code not between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleDescIsNull() {
            addCriterion("role_desc is null");
            return (Criteria) this;
        }

        public Criteria andRoleDescIsNotNull() {
            addCriterion("role_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDescEqualTo(String value) {
            addCriterion("role_desc =", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotEqualTo(String value) {
            addCriterion("role_desc <>", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescGreaterThan(String value) {
            addCriterion("role_desc >", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescGreaterThanOrEqualTo(String value) {
            addCriterion("role_desc >=", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLessThan(String value) {
            addCriterion("role_desc <", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLessThanOrEqualTo(String value) {
            addCriterion("role_desc <=", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescLike(String value) {
            addCriterion("role_desc like", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotLike(String value) {
            addCriterion("role_desc not like", value, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescIn(List<String> values) {
            addCriterion("role_desc in", values, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotIn(List<String> values) {
            addCriterion("role_desc not in", values, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescBetween(String value1, String value2) {
            addCriterion("role_desc between", value1, value2, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andRoleDescNotBetween(String value1, String value2) {
            addCriterion("role_desc not between", value1, value2, "roleDesc");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlIsNull() {
            addCriterion("default_url is null");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlIsNotNull() {
            addCriterion("default_url is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlEqualTo(String value) {
            addCriterion("default_url =", value, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlNotEqualTo(String value) {
            addCriterion("default_url <>", value, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlGreaterThan(String value) {
            addCriterion("default_url >", value, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlGreaterThanOrEqualTo(String value) {
            addCriterion("default_url >=", value, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlLessThan(String value) {
            addCriterion("default_url <", value, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlLessThanOrEqualTo(String value) {
            addCriterion("default_url <=", value, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlLike(String value) {
            addCriterion("default_url like", value, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlNotLike(String value) {
            addCriterion("default_url not like", value, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlIn(List<String> values) {
            addCriterion("default_url in", values, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlNotIn(List<String> values) {
            addCriterion("default_url not in", values, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlBetween(String value1, String value2) {
            addCriterion("default_url between", value1, value2, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andDefaultUrlNotBetween(String value1, String value2) {
            addCriterion("default_url not between", value1, value2, "defaultUrl");
            return (Criteria) this;
        }

        public Criteria andCreUserIsNull() {
            addCriterion("cre_user is null");
            return (Criteria) this;
        }

        public Criteria andCreUserIsNotNull() {
            addCriterion("cre_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreUserEqualTo(String value) {
            addCriterion("cre_user =", value, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserNotEqualTo(String value) {
            addCriterion("cre_user <>", value, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserGreaterThan(String value) {
            addCriterion("cre_user >", value, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserGreaterThanOrEqualTo(String value) {
            addCriterion("cre_user >=", value, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserLessThan(String value) {
            addCriterion("cre_user <", value, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserLessThanOrEqualTo(String value) {
            addCriterion("cre_user <=", value, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserLike(String value) {
            addCriterion("cre_user like", value, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserNotLike(String value) {
            addCriterion("cre_user not like", value, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserIn(List<String> values) {
            addCriterion("cre_user in", values, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserNotIn(List<String> values) {
            addCriterion("cre_user not in", values, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserBetween(String value1, String value2) {
            addCriterion("cre_user between", value1, value2, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreUserNotBetween(String value1, String value2) {
            addCriterion("cre_user not between", value1, value2, "creUser");
            return (Criteria) this;
        }

        public Criteria andCreTimeIsNull() {
            addCriterion("cre_time is null");
            return (Criteria) this;
        }

        public Criteria andCreTimeIsNotNull() {
            addCriterion("cre_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreTimeEqualTo(String value) {
            addCriterion("cre_time =", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeNotEqualTo(String value) {
            addCriterion("cre_time <>", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeGreaterThan(String value) {
            addCriterion("cre_time >", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeGreaterThanOrEqualTo(String value) {
            addCriterion("cre_time >=", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeLessThan(String value) {
            addCriterion("cre_time <", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeLessThanOrEqualTo(String value) {
            addCriterion("cre_time <=", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeLike(String value) {
            addCriterion("cre_time like", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeNotLike(String value) {
            addCriterion("cre_time not like", value, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeIn(List<String> values) {
            addCriterion("cre_time in", values, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeNotIn(List<String> values) {
            addCriterion("cre_time not in", values, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeBetween(String value1, String value2) {
            addCriterion("cre_time between", value1, value2, "creTime");
            return (Criteria) this;
        }

        public Criteria andCreTimeNotBetween(String value1, String value2) {
            addCriterion("cre_time not between", value1, value2, "creTime");
            return (Criteria) this;
        }

        public Criteria andModUserIsNull() {
            addCriterion("mod_user is null");
            return (Criteria) this;
        }

        public Criteria andModUserIsNotNull() {
            addCriterion("mod_user is not null");
            return (Criteria) this;
        }

        public Criteria andModUserEqualTo(String value) {
            addCriterion("mod_user =", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserNotEqualTo(String value) {
            addCriterion("mod_user <>", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserGreaterThan(String value) {
            addCriterion("mod_user >", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserGreaterThanOrEqualTo(String value) {
            addCriterion("mod_user >=", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserLessThan(String value) {
            addCriterion("mod_user <", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserLessThanOrEqualTo(String value) {
            addCriterion("mod_user <=", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserLike(String value) {
            addCriterion("mod_user like", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserNotLike(String value) {
            addCriterion("mod_user not like", value, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserIn(List<String> values) {
            addCriterion("mod_user in", values, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserNotIn(List<String> values) {
            addCriterion("mod_user not in", values, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserBetween(String value1, String value2) {
            addCriterion("mod_user between", value1, value2, "modUser");
            return (Criteria) this;
        }

        public Criteria andModUserNotBetween(String value1, String value2) {
            addCriterion("mod_user not between", value1, value2, "modUser");
            return (Criteria) this;
        }

        public Criteria andModTimeIsNull() {
            addCriterion("mod_time is null");
            return (Criteria) this;
        }

        public Criteria andModTimeIsNotNull() {
            addCriterion("mod_time is not null");
            return (Criteria) this;
        }

        public Criteria andModTimeEqualTo(String value) {
            addCriterion("mod_time =", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotEqualTo(String value) {
            addCriterion("mod_time <>", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeGreaterThan(String value) {
            addCriterion("mod_time >", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeGreaterThanOrEqualTo(String value) {
            addCriterion("mod_time >=", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeLessThan(String value) {
            addCriterion("mod_time <", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeLessThanOrEqualTo(String value) {
            addCriterion("mod_time <=", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeLike(String value) {
            addCriterion("mod_time like", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotLike(String value) {
            addCriterion("mod_time not like", value, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeIn(List<String> values) {
            addCriterion("mod_time in", values, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotIn(List<String> values) {
            addCriterion("mod_time not in", values, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeBetween(String value1, String value2) {
            addCriterion("mod_time between", value1, value2, "modTime");
            return (Criteria) this;
        }

        public Criteria andModTimeNotBetween(String value1, String value2) {
            addCriterion("mod_time not between", value1, value2, "modTime");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Integer value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Integer value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Integer value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Integer value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Integer value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Integer> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Integer> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Integer value1, Integer value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
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