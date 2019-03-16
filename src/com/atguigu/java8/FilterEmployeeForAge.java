package com.atguigu.java8;

public class FilterEmployeeForAge implements MyPredicate<Employee>{

    /**
     * 我这边加了点注释
     * @param t
     * @return
     */
	@Override
	public boolean test(Employee t) {
		return t.getAge() <= 35;
	}
	public boolean test2(Employee t) {
		return t.getAge() <= 35;
	}
	public boolean test3(Employee t) {
		return t.getAge() <= 35;
	}
	public boolean test4(Employee t) {
		return t.getAge() <= 35;
	}

}
