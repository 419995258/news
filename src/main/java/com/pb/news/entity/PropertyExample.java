package com.pb.news.entity;

import java.util.ArrayList;
import java.util.List;

public class PropertyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropertyExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(String value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(String value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(String value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(String value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(String value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(String value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLike(String value) {
            addCriterion("gid like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotLike(String value) {
            addCriterion("gid not like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<String> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<String> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(String value1, String value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(String value1, String value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIsNull() {
            addCriterion("property_key is null");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIsNotNull() {
            addCriterion("property_key is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyEqualTo(String value) {
            addCriterion("property_key =", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyNotEqualTo(String value) {
            addCriterion("property_key <>", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyGreaterThan(String value) {
            addCriterion("property_key >", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyGreaterThanOrEqualTo(String value) {
            addCriterion("property_key >=", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyLessThan(String value) {
            addCriterion("property_key <", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyLessThanOrEqualTo(String value) {
            addCriterion("property_key <=", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyLike(String value) {
            addCriterion("property_key like", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyNotLike(String value) {
            addCriterion("property_key not like", value, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyIn(List<String> values) {
            addCriterion("property_key in", values, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyNotIn(List<String> values) {
            addCriterion("property_key not in", values, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyBetween(String value1, String value2) {
            addCriterion("property_key between", value1, value2, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyKeyNotBetween(String value1, String value2) {
            addCriterion("property_key not between", value1, value2, "propertyKey");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIsNull() {
            addCriterion("property_name is null");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIsNotNull() {
            addCriterion("property_name is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyNameEqualTo(String value) {
            addCriterion("property_name =", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotEqualTo(String value) {
            addCriterion("property_name <>", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThan(String value) {
            addCriterion("property_name >", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameGreaterThanOrEqualTo(String value) {
            addCriterion("property_name >=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThan(String value) {
            addCriterion("property_name <", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLessThanOrEqualTo(String value) {
            addCriterion("property_name <=", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameLike(String value) {
            addCriterion("property_name like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotLike(String value) {
            addCriterion("property_name not like", value, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameIn(List<String> values) {
            addCriterion("property_name in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotIn(List<String> values) {
            addCriterion("property_name not in", values, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameBetween(String value1, String value2) {
            addCriterion("property_name between", value1, value2, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyNameNotBetween(String value1, String value2) {
            addCriterion("property_name not between", value1, value2, "propertyName");
            return (Criteria) this;
        }

        public Criteria andPropertyDescIsNull() {
            addCriterion("property_desc is null");
            return (Criteria) this;
        }

        public Criteria andPropertyDescIsNotNull() {
            addCriterion("property_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyDescEqualTo(String value) {
            addCriterion("property_desc =", value, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescNotEqualTo(String value) {
            addCriterion("property_desc <>", value, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescGreaterThan(String value) {
            addCriterion("property_desc >", value, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescGreaterThanOrEqualTo(String value) {
            addCriterion("property_desc >=", value, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescLessThan(String value) {
            addCriterion("property_desc <", value, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescLessThanOrEqualTo(String value) {
            addCriterion("property_desc <=", value, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescLike(String value) {
            addCriterion("property_desc like", value, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescNotLike(String value) {
            addCriterion("property_desc not like", value, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescIn(List<String> values) {
            addCriterion("property_desc in", values, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescNotIn(List<String> values) {
            addCriterion("property_desc not in", values, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescBetween(String value1, String value2) {
            addCriterion("property_desc between", value1, value2, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andPropertyDescNotBetween(String value1, String value2) {
            addCriterion("property_desc not between", value1, value2, "propertyDesc");
            return (Criteria) this;
        }

        public Criteria andGroupKeyIsNull() {
            addCriterion("group_key is null");
            return (Criteria) this;
        }

        public Criteria andGroupKeyIsNotNull() {
            addCriterion("group_key is not null");
            return (Criteria) this;
        }

        public Criteria andGroupKeyEqualTo(String value) {
            addCriterion("group_key =", value, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyNotEqualTo(String value) {
            addCriterion("group_key <>", value, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyGreaterThan(String value) {
            addCriterion("group_key >", value, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyGreaterThanOrEqualTo(String value) {
            addCriterion("group_key >=", value, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyLessThan(String value) {
            addCriterion("group_key <", value, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyLessThanOrEqualTo(String value) {
            addCriterion("group_key <=", value, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyLike(String value) {
            addCriterion("group_key like", value, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyNotLike(String value) {
            addCriterion("group_key not like", value, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyIn(List<String> values) {
            addCriterion("group_key in", values, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyNotIn(List<String> values) {
            addCriterion("group_key not in", values, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyBetween(String value1, String value2) {
            addCriterion("group_key between", value1, value2, "groupKey");
            return (Criteria) this;
        }

        public Criteria andGroupKeyNotBetween(String value1, String value2) {
            addCriterion("group_key not between", value1, value2, "groupKey");
            return (Criteria) this;
        }

        public Criteria andParCodeIsNull() {
            addCriterion("par_code is null");
            return (Criteria) this;
        }

        public Criteria andParCodeIsNotNull() {
            addCriterion("par_code is not null");
            return (Criteria) this;
        }

        public Criteria andParCodeEqualTo(String value) {
            addCriterion("par_code =", value, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeNotEqualTo(String value) {
            addCriterion("par_code <>", value, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeGreaterThan(String value) {
            addCriterion("par_code >", value, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeGreaterThanOrEqualTo(String value) {
            addCriterion("par_code >=", value, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeLessThan(String value) {
            addCriterion("par_code <", value, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeLessThanOrEqualTo(String value) {
            addCriterion("par_code <=", value, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeLike(String value) {
            addCriterion("par_code like", value, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeNotLike(String value) {
            addCriterion("par_code not like", value, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeIn(List<String> values) {
            addCriterion("par_code in", values, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeNotIn(List<String> values) {
            addCriterion("par_code not in", values, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeBetween(String value1, String value2) {
            addCriterion("par_code between", value1, value2, "parCode");
            return (Criteria) this;
        }

        public Criteria andParCodeNotBetween(String value1, String value2) {
            addCriterion("par_code not between", value1, value2, "parCode");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNull() {
            addCriterion("seq_no is null");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNotNull() {
            addCriterion("seq_no is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(Integer value) {
            addCriterion("seq_no =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotEqualTo(Integer value) {
            addCriterion("seq_no <>", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThan(Integer value) {
            addCriterion("seq_no >", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq_no >=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThan(Integer value) {
            addCriterion("seq_no <", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThanOrEqualTo(Integer value) {
            addCriterion("seq_no <=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIn(List<Integer> values) {
            addCriterion("seq_no in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotIn(List<Integer> values) {
            addCriterion("seq_no not in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoBetween(Integer value1, Integer value2) {
            addCriterion("seq_no between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotBetween(Integer value1, Integer value2) {
            addCriterion("seq_no not between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andExtra1IsNull() {
            addCriterion("extra1 is null");
            return (Criteria) this;
        }

        public Criteria andExtra1IsNotNull() {
            addCriterion("extra1 is not null");
            return (Criteria) this;
        }

        public Criteria andExtra1EqualTo(String value) {
            addCriterion("extra1 =", value, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1NotEqualTo(String value) {
            addCriterion("extra1 <>", value, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1GreaterThan(String value) {
            addCriterion("extra1 >", value, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1GreaterThanOrEqualTo(String value) {
            addCriterion("extra1 >=", value, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1LessThan(String value) {
            addCriterion("extra1 <", value, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1LessThanOrEqualTo(String value) {
            addCriterion("extra1 <=", value, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1Like(String value) {
            addCriterion("extra1 like", value, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1NotLike(String value) {
            addCriterion("extra1 not like", value, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1In(List<String> values) {
            addCriterion("extra1 in", values, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1NotIn(List<String> values) {
            addCriterion("extra1 not in", values, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1Between(String value1, String value2) {
            addCriterion("extra1 between", value1, value2, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra1NotBetween(String value1, String value2) {
            addCriterion("extra1 not between", value1, value2, "extra1");
            return (Criteria) this;
        }

        public Criteria andExtra2IsNull() {
            addCriterion("extra2 is null");
            return (Criteria) this;
        }

        public Criteria andExtra2IsNotNull() {
            addCriterion("extra2 is not null");
            return (Criteria) this;
        }

        public Criteria andExtra2EqualTo(String value) {
            addCriterion("extra2 =", value, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2NotEqualTo(String value) {
            addCriterion("extra2 <>", value, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2GreaterThan(String value) {
            addCriterion("extra2 >", value, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2GreaterThanOrEqualTo(String value) {
            addCriterion("extra2 >=", value, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2LessThan(String value) {
            addCriterion("extra2 <", value, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2LessThanOrEqualTo(String value) {
            addCriterion("extra2 <=", value, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2Like(String value) {
            addCriterion("extra2 like", value, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2NotLike(String value) {
            addCriterion("extra2 not like", value, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2In(List<String> values) {
            addCriterion("extra2 in", values, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2NotIn(List<String> values) {
            addCriterion("extra2 not in", values, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2Between(String value1, String value2) {
            addCriterion("extra2 between", value1, value2, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra2NotBetween(String value1, String value2) {
            addCriterion("extra2 not between", value1, value2, "extra2");
            return (Criteria) this;
        }

        public Criteria andExtra3IsNull() {
            addCriterion("extra3 is null");
            return (Criteria) this;
        }

        public Criteria andExtra3IsNotNull() {
            addCriterion("extra3 is not null");
            return (Criteria) this;
        }

        public Criteria andExtra3EqualTo(String value) {
            addCriterion("extra3 =", value, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3NotEqualTo(String value) {
            addCriterion("extra3 <>", value, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3GreaterThan(String value) {
            addCriterion("extra3 >", value, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3GreaterThanOrEqualTo(String value) {
            addCriterion("extra3 >=", value, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3LessThan(String value) {
            addCriterion("extra3 <", value, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3LessThanOrEqualTo(String value) {
            addCriterion("extra3 <=", value, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3Like(String value) {
            addCriterion("extra3 like", value, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3NotLike(String value) {
            addCriterion("extra3 not like", value, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3In(List<String> values) {
            addCriterion("extra3 in", values, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3NotIn(List<String> values) {
            addCriterion("extra3 not in", values, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3Between(String value1, String value2) {
            addCriterion("extra3 between", value1, value2, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra3NotBetween(String value1, String value2) {
            addCriterion("extra3 not between", value1, value2, "extra3");
            return (Criteria) this;
        }

        public Criteria andExtra4IsNull() {
            addCriterion("extra4 is null");
            return (Criteria) this;
        }

        public Criteria andExtra4IsNotNull() {
            addCriterion("extra4 is not null");
            return (Criteria) this;
        }

        public Criteria andExtra4EqualTo(String value) {
            addCriterion("extra4 =", value, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4NotEqualTo(String value) {
            addCriterion("extra4 <>", value, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4GreaterThan(String value) {
            addCriterion("extra4 >", value, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4GreaterThanOrEqualTo(String value) {
            addCriterion("extra4 >=", value, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4LessThan(String value) {
            addCriterion("extra4 <", value, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4LessThanOrEqualTo(String value) {
            addCriterion("extra4 <=", value, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4Like(String value) {
            addCriterion("extra4 like", value, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4NotLike(String value) {
            addCriterion("extra4 not like", value, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4In(List<String> values) {
            addCriterion("extra4 in", values, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4NotIn(List<String> values) {
            addCriterion("extra4 not in", values, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4Between(String value1, String value2) {
            addCriterion("extra4 between", value1, value2, "extra4");
            return (Criteria) this;
        }

        public Criteria andExtra4NotBetween(String value1, String value2) {
            addCriterion("extra4 not between", value1, value2, "extra4");
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