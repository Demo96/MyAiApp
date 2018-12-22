package com.aiapp.role;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

@Entity
public class Role {
    @Id
    private Integer id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleName name;

    public Role() {}

    public Role(RoleName name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}