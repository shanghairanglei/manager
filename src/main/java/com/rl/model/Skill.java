package com.rl.model;

public class Skill {
    private Integer id;

    private String tUserId;

    private String skill;

    private Integer level;

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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill == null ? null : skill.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill1 = (Skill) o;

        if (!id.equals(skill1.id)) return false;
        if (!tUserId.equals(skill1.tUserId)) return false;
        if (!skill.equals(skill1.skill)) return false;
        return level.equals(skill1.level);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + tUserId.hashCode();
        result = 31 * result + skill.hashCode();
        result = 31 * result + level.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", tUserId='" + tUserId + '\'' +
                ", skill='" + skill + '\'' +
                ", level=" + level +
                '}';
    }

    public Skill(Integer id, String tUserId, String skill, Integer level) {
        this.id = id;
        this.tUserId = tUserId;
        this.skill = skill;
        this.level = level;
    }

    public Skill() {
    }
}