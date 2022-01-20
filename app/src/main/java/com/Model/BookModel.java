package com.Model;

public class BookModel {
    int pic;
    String text;
    String text2;

    public BookModel() {
    }

 public BookModel(int pic, String text,String text2) {
        this.pic = pic;
        this.text = text;
        this.text2=text2;
    }

    public int getPic() {
        return pic;
    }

    public String getText2() {
        return text2;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
