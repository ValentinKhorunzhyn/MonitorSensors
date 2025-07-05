package com.khorunzhyn.sensors.model;

import jakarta.persistence.*;

@Entity
@Table(name = "table_authority", schema = "catalogue")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "authority")
    private String authority;

    public Authority(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Authority() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
