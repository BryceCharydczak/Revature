package com.revature.pojo;

import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="Cave")
public class Cave {

	@Id
	@Column(name="CAVE_ID")
	private int id;
	
	@Column(name="CAVE_NAME")
	private String name;
	
	@Column(name="MAX_BEARS")
	private int maxBears;
	
	
	@OneToMany(mappedBy="cave", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Bear> bears;
}
