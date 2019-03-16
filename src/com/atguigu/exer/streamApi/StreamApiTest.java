package com.atguigu.exer.streamApi;

import com.atguigu.java8.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApiTest {

    //2. 中间操作
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );
    @Test
    public void test(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        System.out.println("---------------------------------------------");

        // 将每个字符串转换成大写然后输出
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::print);

        System.out.println("---------------------------------------------");

        // 提取每个员工的姓名然后输出
        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::print);

        System.out.println("---------------------------------------------");

        // 这里的map会返回一个流，这个流里面保存的是另外的filterCharacter返回的多个流，形式如：{{a,a,a},{b,b,b},{c,c,c}}，类似于add（集合）
        Stream<Stream<Character>> stream= list.stream().map(str->filterCharacter(str));
        // 遍历的时候需要先遍历外层的流，然后再遍历里层的流
        stream.forEach(streamChar -> {
            streamChar.forEach(System.out::println);
        });

        System.out.println("---------------------------------------------");

        // 这里的flatMap接收一个Function函数，然后将function函数返回的流组合成一个新流，最后返回这个个流，
        // 形式如：{a,a,a,b,b,b,c,c,c}，类似于addAll
        list.stream().flatMap(StreamApiTest ::filterCharacter).forEach(System.out::println);

    }

    @Test
    public void test2(){

        List<Employee> emps = Arrays.asList(
                new Employee(102, "李四", 59, 6666.66),
                new Employee(101, "张三", 18, 9999.99),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(104, "赵六", 23, 7777.77),
                new Employee(104, "赵六", 35, 7777.77),
                new Employee(104, "赵六", 4, 7777.77),
                new Employee(104, "赵六", 23, 7777.77),
                new Employee(104, "赵六", 4, 7777.77),
                new Employee(105, "田七", 48, 5555.55)
        );
        // 先按姓名排序，姓名一样按照年龄
        emps.stream().sorted((emp1,emp2) -> {
            if(emp1.getName().equals(emp2.getName())){
                return emp1.getAge()-emp2.getAge();
            }
            return emp1.getName().compareTo(emp2.getName());
        }).forEach(System.out::println);
    }

    // 把字符串转换成一个char集合，然后转换成流返回
    private static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character c:str.toCharArray()) {
             list.add(c);
        }
        return list.stream();
    }
    public static void main(String[] args) {
        //1、通过集合框架获取流
        List<String> list = new ArrayList<>();
        Stream stream = list.stream();

        //2、通过Arrays中的静态方法 Stream() 获取数组流
        String[] arrayStr = {"1","2","3"};
        Stream streamArray = Arrays.stream(arrayStr);

        //3、通过Stream类中的of() 方法创建流
        Stream<String> stream3 = Stream.of("32","dd","asd");


        //4、无限流 迭代
        // iterate(final T seed, final UnaryOperator<T> f)
        // 第一个参数未起始值，第二个参数为 一个一元操作，UnaryOperator，是Function接口的子类。
        Stream<Integer> stream4 = Stream.iterate(0,(x)->x+1);
        //stream4.forEach(System.out::println);

        // 也可以只要前十个
        stream4.limit(10).forEach(System.out::println);

        //5、无限流 生成
        // generate(Supplier<T> s) 参数为一个供给型结构的实现
        Stream<Double> stream5 = Stream.generate(Math::random);
        stream5.forEach(System.out::println);

    }
}
