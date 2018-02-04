package com.helloxin.jdk9;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by nandiexin on 2018/2/4.   这里学习一下 java 9 中 对  Optional 类的增强
 */
public class OptionalLeaner {

    public void optionalOrTest(){

        Optional<String> greeting = Optional.empty();
        String greetingText = greeting.orElse("Hello, World");
        System.out.println(greetingText);

        String greetingText2 = greeting.orElseGet(() -> {
           Random rand = new Random();
           return "Hello CalliCoder Blog Readers - " + rand.nextInt(10);
        });
        System.out.println("orElseGet:"+greetingText2);

        Optional<String> optionalGreetingText = greeting.or(() -> {
        String text = "Nullable Greeting";
        return Optional.ofNullable(text);
        });
        System.out.println(optionalGreetingText);
    }

    public void optionalIfPresentOrElseTest() {

        Optional<String> name = Optional.ofNullable("Rajeev");
        if(name.isPresent()) {
            System.out.println("Hello " + name.get());
         } else {
            System.out.println("Hello Guest");
        }

        name.ifPresent(value -> System.out.println("Hello " + value));

        name.ifPresentOrElse(
           value -> System.out.println("Hello " + value),
           () -> System.out.println("Hello Guest")
         );
    }

    public void optionalStreamTest() {
        
        Optional<String> myOptional = Optional.of("foo");
        Stream<String> myOptionalStream = myOptional.stream();
        myOptionalStream.forEach(System.out::println);


        List<Optional<String>> animalOptionals = List.of(Optional.of("Elephant"), Optional.empty(),
                Optional.of("Lion"), Optional.of("Tiger"), Optional.empty());
        Stream<String> animals = animalOptionals.stream().flatMap(Optional::stream);
        animals.forEach(System.out::println);
        
    }



    public static void main(String[] args) {

        OptionalLeaner optionalLeaner= new OptionalLeaner();
        optionalLeaner.optionalStreamTest();
    }
}
