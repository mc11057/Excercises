package com.tdd.examples.Excercises;

public class Notes {

    /*
        The FIRST Principle
            Fast: Unite tests run fast
            Independent: Unites tests are independent
            Repeatable: Unit tests are repeatable if you run them multiple times
            Self-Validating: Unit tests validate itself, not make manual check after the test
            Thorough & Timely: Cover edge cases, consider happy path and negative scenarios

         Tests should be isolated: Use Dependency Injection, also use Mocks to inject dependencies in the class that we want to test

         Unit tests
         Integration Tests: Similar to Unit tests, except not use mock.
         End-To-End Testing: Testing software functionality from the beginning to end
         The goal of a Unit test is to test each application method separately, isolated from all its dependencies.
         The goal of an Integration test is to test method under test in combination with its dependencies.
         Integration tests verify that method under test works well with its external dependencies.
         Run all the test using maven: mvn test
         skip tests: mvn package -Dmaven.test.skip=true
         pattern name for tests: test<System Under Test>_<Condition or State Change>_<Expected Result>
         fail("Failed"): Intenionally fail a unit test
         LifeCycle Tests:
              for each method Junit will create an instance for a class, the execution order is not obvious
              @BeforeAll annotation execute this method before all tests, is to prepare all the resources: setup()
              @AfterAll annotation execute this method after all tests, is to release all the resources: cleanup()
              @BeforeEach annotation execute this method before each unit test method
              @AfterEach annotation execute this method after each unit test method
         @Disabled("Still need to work on it") annotation to disable unit test
     */

}
