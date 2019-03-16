package com.atguigu.java8;

public class FilterEmployeeForAge implements MyPredicate<Employee>{

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
