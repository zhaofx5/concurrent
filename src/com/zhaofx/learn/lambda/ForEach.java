/** 
 * Project Name:Concurrent 
 * File Name:TestMain.java 
 * Package Name:com.zhaofx.learn.lambda 
 * Date:2018年4月5日下午4:15:08 
 * Copyright (c) 2018, zhaofx5@qq.com All Rights Reserved. 
 * 
*/

package com.zhaofx.learn.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * ClassName:TestMain <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年4月5日 下午4:15:08 <br/>
 * 
 * @author zhaofengxiang
 * @version
 * @since JDK 1.8
 * @see
 */
public class ForEach {

	public static void main(String[] args) {
		List<Person> javaProgrammers = new ArrayList<Person>() {
			{
				add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
				add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
				add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
				add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
				add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
				add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
				add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
				add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
				add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
				add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
			}
		};

		List<Person> phpProgrammers = new ArrayList<Person>() {
			{
				add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
				add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
				add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
				add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
				add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
				add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
				add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
				add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
				add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
				add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
			}
		};
		Map<String, String> map = new HashMap<>();

		System.out.println("所有程序员的姓名:");
		javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
		phpProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

		System.out.println("给程序员加薪 5% :");
		Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());

		javaProgrammers.forEach(giveRaise);
		phpProgrammers.forEach(giveRaise);

		System.out.println("下面是月薪超过 $1,400 的PHP程序员:");
		phpProgrammers.stream().filter((p) -> (p.getSalary() > 1400))
				.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

		// 定义 filters
		Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
		Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
		Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

		System.out.println("下面是年龄大于 24岁且月薪在$1,400以上的女PHP程序员:");
		phpProgrammers.stream().filter(ageFilter).filter(salaryFilter).filter(genderFilter)
				.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

		// 重用filters
		System.out.println("年龄大于 24岁的女性 Java programmers:");
		javaProgrammers.stream().filter(ageFilter).filter(genderFilter)
				.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

		System.out.println("最前面的3个 Java programmers:");
		javaProgrammers.stream().limit(3)
				.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

		System.out.println("最前面的3个女性 Java programmers:");
		javaProgrammers.stream().filter(genderFilter).limit(3)
				.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
	}

	private static void test() {
		System.out.println();
	}
}
