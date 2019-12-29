package com.ssm.crud.entity;

public class MXD {
    private Integer id;
    private String name;

    public MXD(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public MXD() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
