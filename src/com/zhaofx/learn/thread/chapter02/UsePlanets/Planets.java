package com.zhaofx.learn.thread.chapter02.UsePlanets;

import java.util.Set;
import java.util.TreeSet;

public final class Planets {
	private final Set<String> planets = new TreeSet<>();

	public Planets() {
		planets.add("Mercury");
		planets.add("Venus");
		planets.add("Earth");
		planets.add("Mars");
		planets.add("Jupiter");
		planets.add("Saturn");
		planets.add("Uranus");
		planets.add("Neptune");

	}

	public boolean isPlanet(String planetName) {
		planets.add("1");
		return planets.contains(planetName);
	}
}