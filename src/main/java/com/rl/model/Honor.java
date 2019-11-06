package com.rl.model;

import java.util.Date;

public class Honor {
    private Integer id;

    private String tUserId;

    private String honor;

    private Date honorTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String gettUserId() {
        return tUserId;
    }

    public void settUserId(String tUserId) {
        this.tUserId = tUserId == null ? null : tUserId.trim();
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor == null ? null : honor.trim();
    }

    public Date getHonorTime() {
        return honorTime;
    }

    public void setHonorTime(Date honorTime) {
        this.honorTime = honorTime;
    }
}