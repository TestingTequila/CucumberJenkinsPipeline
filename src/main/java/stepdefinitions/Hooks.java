package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        System.out.println("This will execute before every test cases");
    }

    @After
    public void tearDown() {
        System.out.println(" This will execute after every test case");
    }
}
