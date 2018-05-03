package com.revature.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@NamedQueries( { @NamedQuery(name="findBearByCave", query = "from Bear where cave=:caveIdVar")})

@Entity
@Table(name="BEAR")
public class Bear implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bearSequence")
	@SequenceGenerator(allocationSize=1,name="bearSequence",sequenceName="SQ_BEAR_PK")
	@Column(name="BEAR_ID")
	private int id;
	
	@Column(name="BEAR_NAME")
	private String name;
	
	@Column(name="BEAR_WEIGHT")
	private int bearWeight;
	
//	@Column(name="BEAR_TYPE_ID")
//	private int bearTypeId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="BEAR_TYPE_ID")
	private BearType bearType;
	
//	@Column(name="CAVE_ID")
//	private int caveId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CAVE_ID")
	private Cave cave;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
			name="BEAR_BEEHIVE",
			joinColumns = { @JoinColumn(name="BEEHIVE_ID")},
			inverseJoinColumns = { @JoinColumn(name="BEAR_ID")}
			)
	private List<Beehive> beehives;

	public Bear() {
		super();
	}

	public Bear(String name, int bearWeight, BearType bearType, Cave cave) {
		super();
		this.name = name;
		this.bearWeight = bearWeight;
		this.bearType = bearType;
		this.cave = cave;
	}

	public Bear(String name, int bearWeight, BearType bearType, Cave cave, List<Beehive> beehives) {
		super();
		this.name = name;
		this.bearWeight = bearWeight;
		this.bearType = bearType;
		this.cave = cave;
		this.beehives = beehives;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBearWeight() {
		return bearWeight;
	}

	public void setBearWeight(int bearWeight) {
		this.bearWeight = bearWeight;
	}

	public BearType getBearType() {
		return bearType;
	}

	public void setBearType(BearType bearType) {
		this.bearType = bearType;
	}

	public Cave getCave() {
		return cave;
	}

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	public List<Beehive> getBeehives() {
		return beehives;
	}

	public void setBeehives(List<Beehive> beehives) {
		this.beehives = beehives;
	}
	
	public void addBeehive(Beehive b) {
		this.beehives.add(b);
	}
	
	public void removeBeehive(Beehive b) {
		this.beehives.remove(b);
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", bearWeight=" + bearWeight + ", bearType=" + bearType + ", cave="
				+ cave + ", beehives=" + beehives + "]";
	}
	
	
	
}