package com.wanzhon.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class User {
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
    private Integer id;//User的ID

    public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@NotEmpty
    private String username;//User的姓名

    private String password;//User的密码
    private List<Role> roles;
    private Role role;
    public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}