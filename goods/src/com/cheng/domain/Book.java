package com.cheng.domain;

import java.math.BigDecimal;

public class Book {
    @Override
    public String toString() {
        return "bid=" + bid + ", bname=" + bname + ", author=" + author
                + ", price=" + price + ", currprice=" + currprice
                + ", discount=" + discount + ", press=" + press
                + ", publishtime=" + publishtime + ", edition=" + edition
                + ", pagenum=" + pagenum + ", wordnum=" + wordnum
                + ", printtime=" + printtime + ", booksize=" + booksize
                + ", paper=" + paper + ", cid=" + cid + ", imageW=" + imageW
                + ", imageB=" + imageB + ", paixu=" + paixu;
    }

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.bid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String bid;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.bname
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String bname;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.author
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.price
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.currPrice
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private BigDecimal currprice;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.discount
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private BigDecimal discount;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.press
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String press;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.publishtime
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String publishtime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.edition
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private Integer edition;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.pageNum
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private Integer pagenum;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.wordNum
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private Integer wordnum;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.printtime
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String printtime;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.booksize
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private Integer booksize;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.paper
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String paper;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.cid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String cid;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.image_w
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String imageW;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.image_b
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private String imageB;

    /**
     * This field was generated by MyBatis Generator. This field corresponds to
     * the database column book.paixu
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    private Integer paixu;

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.bid
     *
     * @return the value of book.bid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getBid() {
        return bid;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.bid
     *
     * @param bid
     *            the value for book.bid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.bname
     *
     * @return the value of book.bname
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getBname() {
        return bname;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.bname
     *
     * @param bname
     *            the value for book.bname
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.author
     *
     * @return the value of book.author
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.author
     *
     * @param author
     *            the value for book.author
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.price
     *
     * @return the value of book.price
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.price
     *
     * @param price
     *            the value for book.price
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.currPrice
     *
     * @return the value of book.currPrice
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public BigDecimal getCurrprice() {
        return currprice;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.currPrice
     *
     * @param currprice
     *            the value for book.currPrice
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setCurrprice(BigDecimal currprice) {
        this.currprice = currprice;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.discount
     *
     * @return the value of book.discount
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.discount
     *
     * @param discount
     *            the value for book.discount
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.press
     *
     * @return the value of book.press
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getPress() {
        return press;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.press
     *
     * @param press
     *            the value for book.press
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.publishtime
     *
     * @return the value of book.publishtime
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getPublishtime() {
        return publishtime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.publishtime
     *
     * @param publishtime
     *            the value for book.publishtime
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime == null ? null : publishtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.edition
     *
     * @return the value of book.edition
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public Integer getEdition() {
        return edition;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.edition
     *
     * @param edition
     *            the value for book.edition
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.pageNum
     *
     * @return the value of book.pageNum
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public Integer getPagenum() {
        return pagenum;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.pageNum
     *
     * @param pagenum
     *            the value for book.pageNum
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.wordNum
     *
     * @return the value of book.wordNum
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public Integer getWordnum() {
        return wordnum;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.wordNum
     *
     * @param wordnum
     *            the value for book.wordNum
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setWordnum(Integer wordnum) {
        this.wordnum = wordnum;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.printtime
     *
     * @return the value of book.printtime
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getPrinttime() {
        return printtime;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.printtime
     *
     * @param printtime
     *            the value for book.printtime
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setPrinttime(String printtime) {
        this.printtime = printtime == null ? null : printtime.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.booksize
     *
     * @return the value of book.booksize
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public Integer getBooksize() {
        return booksize;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.booksize
     *
     * @param booksize
     *            the value for book.booksize
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setBooksize(Integer booksize) {
        this.booksize = booksize;
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.paper
     *
     * @return the value of book.paper
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getPaper() {
        return paper;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.paper
     *
     * @param paper
     *            the value for book.paper
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setPaper(String paper) {
        this.paper = paper == null ? null : paper.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.cid
     *
     * @return the value of book.cid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.cid
     *
     * @param cid
     *            the value for book.cid
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.image_w
     *
     * @return the value of book.image_w
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getImageW() {
        return imageW;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.image_w
     *
     * @param imageW
     *            the value for book.image_w
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setImageW(String imageW) {
        this.imageW = imageW == null ? null : imageW.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.image_b
     *
     * @return the value of book.image_b
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public String getImageB() {
        return imageB;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.image_b
     *
     * @param imageB
     *            the value for book.image_b
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setImageB(String imageB) {
        this.imageB = imageB == null ? null : imageB.trim();
    }

    /**
     * This method was generated by MyBatis Generator. This method returns the
     * value of the database column book.paixu
     *
     * @return the value of book.paixu
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public Integer getPaixu() {
        return paixu;
    }

    /**
     * This method was generated by MyBatis Generator. This method sets the
     * value of the database column book.paixu
     *
     * @param paixu
     *            the value for book.paixu
     *
     * @mbggenerated Thu Jun 22 08:35:00 CST 2017
     */
    public void setPaixu(Integer paixu) {
        this.paixu = paixu;
    }
}