package com.czxy.pojo;




import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "cid")
    private String cid;

    @Column(name = "cname")
    private String cname;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
