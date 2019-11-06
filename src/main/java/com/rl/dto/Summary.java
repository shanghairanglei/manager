package com.rl.dto;

import com.rl.utils.GlobleService;

import java.util.Date;

/**
 * @ClassName
 * @Description 计划总结返回体
 * @Author
 * @Date 2019/10/22 18:41
 * @Version 1.0
 **/
public class Summary {

    private String name;

    private  String wpName;

    private Date wpCreatedate;

    private String tUserId;



    public Summary(String name, String wpName, Date wpCreatedate, String tUserId) {
        this.name = name;
        this.wpName = wpName;
        this.wpCreatedate = wpCreatedate;
        this.tUserId = tUserId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWpName() {
        return wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName;
    }

    public String getWpCreatedate() {
        return GlobleService.getDateString2(wpCreatedate);
    }

    public void setWpCreatedate(Date wpCreatedate) {
        this.wpCreatedate = wpCreatedate;
    }

    public String gettUserId() {
        return tUserId;
    }

    public void settUserId(String tUserId) {
        this.tUserId = tUserId;
    }

    public Summary() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Summary summary = (Summary) o;

        if (!name.equals(summary.name)) return false;
        if (!wpName.equals(summary.wpName)) return false;
        if (!wpCreatedate.equals(summary.wpCreatedate)) return false;
        return tUserId.equals(summary.tUserId);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + wpName.hashCode();
        result = 31 * result + wpCreatedate.hashCode();
        result = 31 * result + tUserId.hashCode();
        return result;
    }


}
