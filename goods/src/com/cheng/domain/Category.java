package com.cheng.domain;

public class Category {

    @Override
    public String toString() {
        return "Category [cid=" + cid + ", cname=" + cname + ", pid=" + pid
                + ", miaoshu=" + miaoshu + ", paixu=" + paixu + "]";
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.cid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String cid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.cname
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String cname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.pid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.miaoshu
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String miaoshu;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column category.paixu
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private Integer paixu;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.cid
     *
     * @return the value of category.cid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.cid
     *
     * @param cid the value for category.cid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.cname
     *
     * @return the value of category.cname
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getCname() {
        return cname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.cname
     *
     * @param cname the value for category.cname
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.pid
     *
     * @return the value of category.pid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.pid
     *
     * @param pid the value for category.pid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.miaoshu
     *
     * @return the value of category.miaoshu
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getMiaoshu() {
        return miaoshu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.miaoshu
     *
     * @param miaoshu the value for category.miaoshu
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu == null ? null : miaoshu.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column category.paixu
     *
     * @return the value of category.paixu
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public Integer getPaixu() {
        return paixu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column category.paixu
     *
     * @param paixu the value for category.paixu
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }
}