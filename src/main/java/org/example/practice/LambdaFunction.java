package org.example.practice;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaFunction {


    /*
What is a Functional Interface?
A Functional Interface is an interface that has exactly one abstract method.
It can have multiple default or static methods (Java 8 feature), but only one abstract method.
This Single Abstract Method (SAM) is the target for Lambda Expressions.
Java 8 introduced the @FunctionalInterface annotation to mark them — not mandatory, but helps catch errors.

Java 8 comes with ready-made functional interfaces so you don’t always need to create your own.
| Interface       | Method Signature    | Example Use                       |
| --------------- | ------------------- | --------------------------------- |
| `Consumer<T>`   | `void accept(T t)`  | Process a value without returning |
| `Supplier<T>`   | `T get()`           | Supply/generate a value           |
| `Function<T,R>` | `R apply(T t)`      | Transform a value                 |
| `Predicate<T>`  | `boolean test(T t)` | Test a condition                  |



What Are Method References?
A Method Reference is just a short-hand for a Lambda expression that calls an existing method.
It’s cleaner when your Lambda only calls one method.

Syntax Types
Static Method Reference — ClassName::staticMethod
Instance Method Reference — instance::instanceMethod
Reference to Instance Method of an Arbitrary Object — ClassName::instanceMethod
Constructor Reference — ClassName::new


Why Use Method References?
Removes redundant syntax
Improves readability
Works seamlessly with Streams & Functional Interfaces



Default & Static Methods in Interfaces
Before Java 8:
Interfaces could only have abstract methods (no body).
If we added a new method in an interface, all implementing classes had to override it → big pain in large projects.
Java 8 solved this by introducing:
Default methods → methods with body inside interface.
Static methods → utility/helper methods inside interface.
need to tackle diamond problem ( if two interface have same name default method , then we have to override the method and tell it to explicitly use A_Interface.super.methodName )

optionsal

DateTime
Why New API?
Before Java 8 → Date and Calendar were mutable, confusing, not thread-safe.
Java 8 introduced a brand-new package java.time → inspired by JodaTime.
Immutable, thread-safe, cleaner API.
Key Classes :-
LocalDate → date (no time)
LocalTime → time (no date)
LocalDateTime → date + time
ZonedDateTime → date + time + timezone
Period and Duration → represent differences
DateTimeFormatter → formatting/parsing

What is a Stream?
A Stream is a sequence of data that supports functional-style operations (map, filter, reduce, etc.).
It does not store data, it processes from a source (Collection, Array, I/O).
Operations are chained and executed lazily (only when needed).

A stream works in 3 stages:
Source → Collection, Array, File, etc.
Intermediate Operations → transform/filter (lazy).
Examples: map, filter, sorted, distinct.
Terminal Operation → produce a result (eager).
Examples: forEach, collect, reduce, count.


Common Intermediate Operations
filter(Predicate) → keeps matching elements
map(Function) → transforms elements
sorted() → sorts
distinct() → removes duplicates
limit(n) → take first n elements
skip(n) → skip first n elements


Common Terminal Operations
forEach(Consumer) → processes each element
collect(Collectors.toList()) → converts back to list
count() → counts elements
reduce(...) → reduce elements into single result


What are Collectors?
Collectors is a utility class in Java 8 that provides many useful methods to collect results from a Stream.
You can use it with collect() (a terminal operation) to gather results into a List, Set, Map, String, etc.

// what is the difference between map and flatmap
map() — transform each element
Used to apply a function to each element of the stream.
Returns a new stream with transformed elements.

flatMap() — flatten nested structures
Used when you have nested lists/collections.
Flattens them into a single stream.

val nums = List(1, 2, 3)
val mapped = nums.map(n => List(n, n * 10))
// Result: List(List(1, 10), List(2, 20), List(3, 30))

val nums = List(1, 2, 3)
val flatMapped = nums.flatMap(n => List(n, n * 10))
// Result: List(1, 10, 2, 20, 3, 30)

What is a Parallel Stream?
A parallel stream divides the work into multiple parts and runs them on different CPU cores using the ForkJoinPool.
This can speed up performance for large datasets.

	*/

    public static void main(String[] arg) {

        Runnable r = () -> {
            System.out.println("this is testing of lambda.");
        };
        r.run();


        List<String> nameOfPeople = Arrays.asList("tushar", "kartik", "prajwal");
        nameOfPeople.forEach(System.out::println);

        List<Integer> listOfNumber = Arrays.asList(1, 2, 3, 4, 5);
        listOfNumber.forEach(number -> System.out.println(number * 2));
        Runnable secondTask = () -> {
            System.out.println("Task running.");
        };
        secondTask.run();

        MyPrintMethod printMethod = (message) -> {
            System.out.println(message + " Example of function interface basic.");
        };
        printMethod.printMethodFromInterface("This is input.");

        //consumer
        Consumer<String> consumerFunction = message -> System.out.println("Consumer interface ->" + message);
        consumerFunction.accept("It will accept.");

        //Supplier
        Supplier<String> supplierFunction = () -> {
            return "this function will give u the value perform get only like get random number ->" + Math.random() * 10;
        };
        System.out.println(supplierFunction.get());

        //function
        Function<Integer, Integer> squareFunction = x -> x * x;
        System.out.println(squareFunction.apply(5));

        //predicate  true or false
        Predicate<Integer> isEvenNumber = number -> number % 2 == 0;
        System.out.println(isEvenNumber.test(5));

        Function<Integer, Integer> squareOfEvenNumber = (num) -> num * num;
        Consumer<Integer> printTheSquareValue = message -> System.out.println("Square is _>" + message);

        for (Integer num : listOfNumber) {
            if (isEvenNumber.test(num)) {
                printTheSquareValue.accept(squareOfEvenNumber.apply(num));
            }
        }

        /// Method reference
        //Static reference
        Function<String, Integer> findLengthOfString = String::length;
        System.out.println(findLengthOfString.apply("tushar") + " -> this is the length of the string.");

        //instance method reference
        String inputString = "THis is for test.";
        Supplier<Integer> getLengthOfString = inputString::length;
        System.out.println("Get the length of String ->" + getLengthOfString.get());

        //arbiterry object
        List<String> names = Arrays.asList("tushar", "kartik", "prajwal");
        names.forEach(System.out::println);

        //constructor reference
        Supplier<List<Integer>> getListObj = ArrayList::new;
        List<Integer> newListObject = getListObj.get();

        Function<String, String> applyUpperCase = String::toUpperCase;
        names.forEach(a -> System.out.println(applyUpperCase.apply(a)));


        //default and static method
        vehicle_B.callStaticMethodOfClassB();  //static method of interface vehicle B
        vehicle_A.turnLeft();  // static method of interface vehicle A
        Car car = new Car();
        car.drive();
        car.start();
        car.testCommonMethod();

        //Streams
        List<String> listofNames = Arrays.asList("Savio", "Tushar", "Kartik");
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        listofNames.stream()
                .filter(name -> name.startsWith("S"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        List<Integer> listOfNumberForStreams = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumOfSquareNumber = listOfNumberForStreams.stream()
                .filter(num -> num % 2 == 0)
                .map(number -> number * number)
                .reduce(0, Integer::sum);
        System.out.println(sumOfSquareNumber);

        listOfNumberForStreams.stream()
                .filter(num -> num % 2 != 0)
                .map(n -> n * n)
                .toList()
                .forEach(System.out::println);


        //using the collectors

        List<String> namesListCollectors = listofNames.stream().filter(n -> n.length() > 5).collect(Collectors.toList());
        System.out.println(namesListCollectors);

        Set<String> nameListUpperCaseInSet = listofNames.stream().map(String::toUpperCase).collect(Collectors.toSet());
        System.out.println(nameListUpperCaseInSet);

        Map<String, Integer> map = listofNames.stream().collect(Collectors.toMap(n -> n, String::length));
        System.out.println(map);

        //joining two string
        String resultString = listofNames.stream().collect(Collectors.joining(", "));
        System.out.println(resultString);

        long countNumberOfEntryes =  listofNames.stream().filter(n -> n.length()>4).count();
        System.out.println(countNumberOfEntryes);

        long count =  listofNames.stream().collect(Collectors.counting());
        System.out.println(count);

        Map<Integer , List<String>>  mapOfNames =  listofNames.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(mapOfNames);

        int sumOfListNumber =  listOfNumberForStreams.stream().collect(Collectors.summingInt(n ->n));
        System.out.println(sumOfListNumber);
        List<String> fruits = Arrays.asList("apple", "banana", "orange", "mango", "kiwi", "avocado");

        Set<String>  setOfFruits =  fruits.stream().collect(Collectors.toSet());
        Map<String,Integer> mapOfFruits =  fruits.stream().collect(Collectors.toMap(x->x , String::length));
        String joinAllFruitsByPipe =  fruits.stream().collect(Collectors.joining(" | "));
        System.out.println(joinAllFruitsByPipe);
        Map<Character, List<String>>  listOFFruitsBYStaringNames = fruits.stream().collect(Collectors.groupingBy(n-> n.charAt(0)));
        System.out.println(listOFFruitsBYStaringNames);

        //parallel streams
        List<Integer> numbersForParallelStream = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbersForParallelStream.stream().forEach(x -> System.out.println(Thread.currentThread().getName() +" ->list number -> "+ x));
        numbersForParallelStream.parallelStream().forEach(x -> System.out.println(Thread.currentThread().getName() +"->parallel list number -> "+x));

        int parallelSum =  numbersForParallelStream.parallelStream().reduce(0,Integer::sum);
        System.out.println(parallelSum);


    }

    @FunctionalInterface
    interface MyPrintMethod {
        void printMethodFromInterface(String str);
    }

    interface vehicle_A {
        static void turnLeft() {
            System.out.println("vehicle A turing left.");
        }

        void drive();

        default void start() {
            System.out.println("Vehicle a will be start.");
        }

        default void testCommonMethod() {
            System.out.println("Common method of A.");
        }
    }

    interface vehicle_B {
        static void callStaticMethodOfClassB() {
            System.out.println(" Static method of class B.");
        }

        default void testCommonMethod() {
            System.out.println("Common method of B.");
        }
    }

    public static class Car implements vehicle_A, vehicle_B {
        @Override
        public void drive() {
            System.out.println("calling the start method from interface A.");
        }

        @Override
        public void start() {
            vehicle_A.super.start();
        }

        @Override
        public void testCommonMethod() {
            vehicle_B.super.testCommonMethod();
        }
    }
}



