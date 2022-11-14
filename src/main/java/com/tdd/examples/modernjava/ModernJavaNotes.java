package com.tdd.examples.modernjava;

public class ModernJavaNotes {
    /*
            Optional makes us deal with nullable values explicitly as a way of enforcing good programming practices.
            Optional.empty(); empty value
            Optional.of() we don't expect null values
            Optional.ofNullable() we expect null values
            opt.isPresent() verify if the value is present
            opt.isEmpty() verify if the value is empty

            opt.ifPresent(name -> System.out.println(name.length()));
            The orElse() method is used to retrieve the value wrapped inside an Optional instance. It takes one parameter, which acts as a default value. The orElse() method returns the wrapped value if it's present, and its argument otherwise:

            String nullName = null;
                String name = Optional.ofNullable(nullName).orElse("john");
                assertEquals("john", name);

            The orElseGet() method is similar to orElse(). However, instead of taking a value to return if the Optional value is not present, it takes a supplier functional interface, which is invoked and returns the value of the invocation:

            String nullName = null;
                String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
                assertEquals("john", name);

            The orElseThrow() method follows from orElse() and orElseGet() and adds a new approach for handling an absent value.

            Instead of returning a default value when the wrapped value is not present, it throws an exception:
            String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);

            Java 10 introduced a simplified no-arg version of orElseThrow() method. In case of an empty Optional it throws a NoSuchElementException:
             String name = Optional.ofNullable(nullName).orElseThrow();

            The final approach for retrieving the wrapped value is the get() method:
             String name = opt.get();
             However, unlike the previous three approaches, get() can only return a value if the wrapped object is not null; otherwise, it throws a no such element exception:
             This is the major flaw of the get() method. Ideally, Optional should help us avoid such unforeseen exceptions. Therefore, this approach works against the objectives of Optional and will probably be deprecated in a future release.

            So, it's advisable to use the other variants that enable us to prepare for and explicitly handle the null case.

            We can run an inline test on our wrapped value with the filter method. It takes a predicate as an argument and returns an Optional object. If the wrapped value passes testing by the predicate, then the Optional is returned as-is.

            However, if the predicate returns false, then it will return an empty Optional:
             Integer year = 2016;
                Optional<Integer> yearOptional = Optional.of(year);
                boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
                assertTrue(is2016);
                boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
                assertFalse(is2017);

                Another Example:
                public boolean priceIsInRange1(Modem modem) {
                boolean isInRange = false;

                if (modem != null && modem.getPrice() != null
                  && (modem.getPrice() >= 10
                    && modem.getPrice() <= 15)) {

                    isInRange = true;
                }
                return isInRange;
            }
                public boolean priceIsInRange2(Modem modem2) {
                 return Optional.ofNullable(modem2)
                   .map(Modem::getPrice)
                   .filter(p -> p >= 10)
                   .filter(p -> p <= 15)
                   .isPresent();
             }

             Transforming Value With map()
              List<String> companyNames = Arrays.asList(
                  "paypal", "oracle", "", "microsoft", "", "apple");
                Optional<List<String>> listOptional = Optional.of(companyNames);

                int size = listOptional
                  .map(List::size)
                  .orElse(0);
                assertEquals(6, size);

            Transforming Value With flatMap()
            Just like the map() method, we also have the flatMap() method as an alternative for transforming values. The difference is that map transforms values only when they are unwrapped whereas flatMap takes a wrapped value and unwraps it before transforming it.

            filter->Predicate<Integer> is function of one argument and execute a logical to see if is true or no. use Functional Interface: has only one abstract method
            map->Function<Integer,Integer> is a function that accepts one argument and produces a result use Functional Interface: has only one abstract method
            forEach->Consumer<Integer> it consumes whatever gets use Functional Interface: has only one abstract method
            BinaryOperator takes 2 arguments and return one
            Supplier: No input and return something fo example a function to generate a randomInteger
            UnaryOperator take one parameter and return one
            BiPredicate takes two arguments and return one boolean


     */
}
