package com.revature.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="BEEHIVE")
public class Beehive implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="beehiveSequence")
	@SequenceGenerator(allocationSize=1, name="beehiveSequence", sequenceName="SQ_BEEHIVE_PK")
	@Column(name="BEEHIVE_ID")
	private int id;
	
	@Column(name="BEEHIVE_WEIGHT")
	private int weight;
	
	@ManyToMany(mappedBy="beehives")
	private List<Bear> hungryBears;

	public Beehive() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Beehive(int weight) {
		super();
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<Bear> getHungryBears() {
		return hungryBears;
	}

	public void setHungryBears(List<Bear> hungryBears) {
		this.hungryBears = hungryBears;
	}

	@Override
	public String toString() {
		return "Beehive [id=" + id + ", weight=" + weight + "]";
	}
	
	
	
}