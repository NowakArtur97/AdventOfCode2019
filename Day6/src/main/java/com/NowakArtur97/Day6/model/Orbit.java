package com.NowakArtur97.Day6.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Orbit)) {
			return false;
		}
		Orbit<T> other = (Orbit<T>) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Orbit [name=" + name + "]";
	}

}
