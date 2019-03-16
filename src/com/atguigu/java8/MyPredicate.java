package com.atguigu.java8;

@FunctionalInterface
public interface MyPredicate<T> {

	/**
	 * 这是一个函数式接口
	 * @param t
	 * @return
	 */
	public boolean test(T t);
	
}
