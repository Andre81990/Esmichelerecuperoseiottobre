package com.example.Esmichelerecuperoseiottobre;

import java.util.Optional;

public class Optn {
    public static void main(String[] args) {


    // Creating an Optional with a value
    Optional<String> optionalValue = Optional.of("Hello, Optional!");

    // Checking if a value is present
        if (optionalValue.isPresent()) {
        System.out.println("Value is present: " + optionalValue.get());
    } else {
        System.out.println("Value is not present");
    }

    // Creating an empty Optional
    Optional<String> emptyOptional = Optional.empty();

    // Using orElse() to provide a default value if the Optional is empty
    String result = emptyOptional.orElse("Default Value");
        System.out.println("Result: " + result);

    // Using map() to transform the value inside the Optional
    Optional<String> transformedOptional = optionalValue.map(s -> s + " - Transformed");
        System.out.println("Transformed Value: " + transformedOptional.orElse("No Value"));

    // Using filter() to conditionally process the value inside the Optional
    Optional<String> filteredOptional = optionalValue.filter(s -> s.contains("Hello"));
        System.out.println("Filtered Value: " + filteredOptional.orElse("No Value"));

    // Chaining multiple operations
    String finalResult = optionalValue
            .map(s -> s + " World")
            .filter(s -> s.length() > 10)
            .orElse("Default Result");
        System.out.println("Final Result: " + finalResult);
}
}



