/** 
 * Project Name:Concurrent 
 * File Name:ListSort.java 
 * Package Name:com.zhaofx.learn.lambda 
 * Date:2018年4月5日下午4:35:46 
 * Copyright (c) 2018, zhaofx5@qq.com All Rights Reserved. 
 * 
*/

package com.zhaofx.learn.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ClassName:ListSort <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2018年4月5日 下午4:35:46 <br/>
 * 
 * @author zhaofengxiang
 * @version
 * @since JDK 1.8
 * @see
 */
public class ListSort {
	public static void main(String[] args) {
		String[] players = { "Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer",
				"Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner" };

		// 1.1 使用匿名内部类根据 name 排序 players
		Arrays.sort(players, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1.compareTo(s2));
			}
		});

		// 1.2 使用 lambda expression 排序 players
		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
		Arrays.sort(players, sortByName);

		// 1.3 也可以采用如下形式:
		Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));

		// 1.1 使用匿名内部类根据 surname 排序 players
		Arrays.sort(players, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
			}
		});

		// 1.2 使用 lambda expression 排序,根据 surname
		Comparator<String> sortBySurname = (String s1, String s2) -> s1.substring(s1.indexOf(" "))
				.compareTo(s2.substring(s2.indexOf(" ")));
		Arrays.sort(players, sortBySurname);

		// 1.3 或者这样,怀疑原作者是不是想错了,括号好多...
		Arrays.sort(players,
				(String s1, String s2) -> (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" ")))));

		// 2.1 使用匿名内部类根据 name lenght 排序 players
		Arrays.sort(players, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1.length() - s2.length());
			}
		});

		// 2.2 使用 lambda expression 排序,根据 name lenght
		Comparator<String> sortByNameLenght = (String s1, String s2) -> (s1.length() - s2.length());
		Arrays.sort(players, sortByNameLenght);

		// 2.3 or this
		Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));

		// 3.1 使用匿名内部类排序 players, 根据最后一个字母
		Arrays.sort(players, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
			}
		});

		// 3.2 使用 lambda expression 排序,根据最后一个字母
		Comparator<String> sortByLastLetter = (String s1,
				String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
		Arrays.sort(players, sortByLastLetter);

		// 3.3 or this
		Arrays.sort(players, (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));
	}

}
