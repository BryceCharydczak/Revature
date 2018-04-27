package com.revature.pojo;

import javax.persistence.*;

@Entity
@Table(name="BEAR")
public class Bear {

	
	@Id
	@Column(name="BEAR_ID")
	private int id;
	
	@Column(name="BEAR_NAME")
	private String name;
	
	@Column(name="BEAR_WEIGHT")
	private int bearWeight;
	
	@Column(name="BEAR_TYPE_ID")
	private int bearTypeId;
	
	@Column(name="CAVE_ID")
	private int caveId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="BEAR_TYPE_ID")
	private BearType bearType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CAVE_ID")
	private Cave cave;
}
