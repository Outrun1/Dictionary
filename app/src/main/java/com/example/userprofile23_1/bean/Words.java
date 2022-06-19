package com.example.userprofile23_1.bean;

public class Words {
    private Integer id;
    private Integer bookId;
    private String word;
    private String translate;
    private Integer isLearn;
    private Integer isReview;
    private Integer isCollect;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public Integer getIsLearn() {
        return isLearn;
    }

    public void setIsLearn(Integer isLearn) {
        this.isLearn = isLearn;
    }

    public Integer getIsReview() {
        return isReview;
    }

    public void setIsReview(Integer isReview) {
        this.isReview = isReview;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }

    @Override
    public String toString() {
        return "Words{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", word='" + word + '\'' +
                ", translate='" + translate + '\'' +
                ", isLearn=" + isLearn +
                ", isReview=" + isReview +
                ", isCollect=" + isCollect +
                '}';
    }
}
