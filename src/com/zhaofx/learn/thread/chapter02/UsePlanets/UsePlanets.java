package com.zhaofx.learn.thread.chapter02.UsePlanets;

public class UsePlanets {
	public static void main(String[] args) {
		Planets planets = new Planets();
		System.out.println(planets.isPlanet("Earth"));
		System.out.println(planets.isPlanet("Vulcan"));
		System.out.println(planets.isPlanet("1"));
	}
}