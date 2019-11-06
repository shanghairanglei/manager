package com.rl.dto;

/**
 * @ClassName
 * @Description TODO
 * @Author
 * @Date 2019/9/20 8:42
 * @Version 1.0
 **/
public class PerformanceDto {

    //创建日期
    private String wpCreate;

    //实际绩效和
    private Integer actualCountPerformance;

    //自测绩效和
    private Integer checkPointCount;

    //审核绩效和
    private Integer prospectCount;


    public String getWpCreate() {
        return wpCreate;
    }

    public void setWpCreate(String wpCreate) {
        this.wpCreate = wpCreate;
    }

    public Integer getActualCountPerformance() {
        return actualCountPerformance;
    }

    public void setActualCountPerformance(Integer actualCountPerformance) {
        this.actualCountPerformance = actualCountPerformance;
    }

    public Integer getCheckPointCount() {
        return checkPointCount;
    }

    public void setCheckPointCount(Integer checkPointCount) {
        this.checkPointCount = checkPointCount;
    }

    public Integer getProspectCount() {
        return prospectCount;
    }

    public void setProspectCount(Integer prospectCount) {
        this.prospectCount = prospectCount;
    }

    @Override
    public String toString() {
        return "PerformanceDto{" +
                "wpCreate='" + wpCreate + '\'' +
                ", actualCountPerformance=" + actualCountPerformance +
                ", checkPointCount=" + checkPointCount +
                ", prospectCount=" + prospectCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PerformanceDto that = (PerformanceDto) o;

        if (!wpCreate.equals(that.wpCreate)) return false;
        if (!actualCountPerformance.equals(that.actualCountPerformance)) return false;
        if (!checkPointCount.equals(that.checkPointCount)) return false;
        return prospectCount.equals(that.prospectCount);
    }

    @Override
    public int hashCode() {
        int result = wpCreate.hashCode();
        result = 31 * result + actualCountPerformance.hashCode();
        result = 31 * result + checkPointCount.hashCode();
        result = 31 * result + prospectCount.hashCode();
        return result;
    }
}
