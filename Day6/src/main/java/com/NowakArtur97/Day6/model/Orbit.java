package com.NowakArtur97.Day6.model;

import java.util.ArrayList;
import java.util.List;

public class Orbit<T> {

	private T name = null;

	private List<Orbit<T>> childrenOrbits = new ArrayList<>();

	private Orbit<T> parentOrbit = null;

	public Orbit(T name) {
		this.name = name;
	}

	public void addChildOrbit(Orbit<T> child) {
		child.setParentOrbit(this);
		this.childrenOrbits.add(child);
	}

	public void addChildrenOrbit(List<Orbit<T>> childrenOrbit) {

		childrenOrbit.forEach(each -> each.setParentOrbit(this));
		this.childrenOrbits.addAll(childrenOrbit);
	}

	public List<Orbit<T>> getChildren() {
		return childrenOrbits;
	}

	public T getName() {
		return name;
	}

	public void setName(T name) {
		this.name = name;
	}

	private void setParentOrbit(Orbit<T> parentOrbit) {
		this.parentOrbit = parentOrbit;
	}

	public Orbit<T> getParent() {
		return parentOrbit;
	}

}
