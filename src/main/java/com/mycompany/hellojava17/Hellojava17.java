/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.hellojava17;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author peterkipping
 */
public class Hellojava17 {

    //Fruit enum
    enum Fruit {
        APPLE, PEAR, ORANGE, LEMON
    };

    enum Color {
        WHITE, BLUE
    };

    public record GrapeRecord2(Color color, int nbrOfPits) {

    }

    //Base Sealed class
    public abstract sealed class FruitSealed permits AppleSealed, GrapeSealed, PearSealed {
    }

    public non-sealed class AppleSealed extends FruitSealed {
    }

    public final class PearSealed extends FruitSealed {
    }

    public final class GrapeSealed extends FruitSealed {
    }

	//main class
    public static void main(String[] args) {

        var test = "  testing var type.";

        System.out.println("Hello World!" + test);

        String text = """
            {
              "name": "John Doe",
              "age": 45,
              "address": "Doe Street, 23, Java Town"
            }
            """;
        System.out.println(text);

        //Switch statement
        var fruit = Fruit.LEMON;
        oldStyleWithBreak(fruit);
        withSwitchExpression(fruit);
        basicRecord();
        oldStyle();
        patternMatching();

        HashMap<String, GrapeClass> grapes = new HashMap<>();
        grapes.put("grape1", new GrapeClass(Color.BLUE, 2));
        grapes.put("grape2", new GrapeClass(Color.WHITE, 4));
        grapes.put("grape3", null);
        var color = ((GrapeClass) grapes.get("grape2")).getColor();
        
        oldStyleList();
        streamToList();
        
    }

    private static void oldStyleWithBreak(Fruit fruit) {
        switch (fruit) {
            case APPLE, PEAR:
                System.out.println("Common fruit");
                break;
            case ORANGE, LEMON:
                System.out.println("Exotic fruit");
                break;
            default:
                System.out.println("Undefined fruit");
        }
    }

    private static void withSwitchExpression(Fruit fruit) {
        switch (fruit) {
            case APPLE, PEAR ->
                System.out.println("Common fruit");
            case ORANGE, LEMON ->
                System.out.println("Exotic fruit");
            default ->
                System.out.println("Undefined fruit");
        }
    }

    private static void basicRecord() {
        record GrapeRecord(Color color, int nbrOfPits) {

        }
        GrapeRecord grape1 = new GrapeRecord(Color.BLUE, 1);
        GrapeRecord grape2 = new GrapeRecord(Color.WHITE, 2);
        System.out.println("Grape 1 is " + grape1);
        System.out.println("Grape 2 is " + grape2);
        System.out.println("Grape 1 equals grape 2? " + grape1.equals(grape2));
        GrapeRecord grape1Copy = new GrapeRecord(grape1.color(), grape1.nbrOfPits());
        System.out.println("Grape 1 equals its copy? " + grape1.equals(grape1Copy));
    }

    private void sealedClasses() {
        AppleSealed apple = new AppleSealed();
        PearSealed pear = new PearSealed();
        FruitSealed fruit = apple;
        class Avocado extends AppleSealed {
        };
    }

    private static void oldStyle() {
        Object o = new GrapeClass(Color.BLUE, 2);
        if (o instanceof GrapeClass) {
            GrapeClass grape = (GrapeClass) o;
            System.out.println("This grape has " + grape.getNbrOfPits() + " pits.");
        }
    }

    private static void patternMatching() {
        Object o = new GrapeClass(Color.BLUE, 2);
        if (o instanceof GrapeClass grape) {
            System.out.println("This grape has " + grape.getNbrOfPits() + " pits.");
        }
    }

    private static void oldStyleList() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.collect(Collectors.toList());
        for (String s : stringList) {
            System.out.println(s);
        }
    }

    private static void streamToList() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        List<String> stringList = stringStream.toList();
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
