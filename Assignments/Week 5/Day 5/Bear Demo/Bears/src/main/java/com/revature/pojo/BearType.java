package com.revature.pojo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="BEAR_TYPE")
public class BearType implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bearTypeSequence")
	@SequenceGenerator(allocationSize=1,name="bearTypeSequence",sequenceName="SQ_BEAR_TYPE_PK")
	@Column(name="BEAR_TYPE_ID")
	private int bearTypeId;
	
	@Column(name="BEAR_TYPE_NAME")
	private String name;

	public BearType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BearType(String name) {
		super();
		this.name = name;
	}

	public int getBearTypeId() {
		return bearTypeId;
	}

	public void setBearTypeId(int bearTypeId) {
		this.bearTypeId = bearTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BearType [bearTypeId=" + bearTypeId + ", name=" + name + "]";
	}
	
	

}