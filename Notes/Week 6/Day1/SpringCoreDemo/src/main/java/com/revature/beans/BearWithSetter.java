package com.revature.beans;

public class BearWithSetter extends Bear{
	private Cave cave;
	public void setCave(Cave cave) {
		this.cave = cave;
	}
	public void methodInBear() {
		System.out.println("method in BearWithSetter this bear is: " + this.toString());
		System.out.println("cave " + this.cave.toString());
	}

}
