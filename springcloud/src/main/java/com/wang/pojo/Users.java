package com.wang.pojo;

import java.io.Serializable;

public class Users implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6714712543470520173L;

	private Integer id;

    private String name;

    public Users(Integer id, String name, Integer age, String data) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.data = data;
	}

	private Integer age;

    private String data;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getData() {
        return data;
    }

    public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String name, Integer age, String data) {
		super();
		this.name = name;
		this.age = age;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", age=" + age + ", data=" + data + "]";
	}

	public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }
}