package thetestingacademy.TestNGexamples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGEx1 {
    @BeforeMethod
    void Method1(){
        System.out.println("Before Method");
    }
@Test
void Test1(){
    System.out.println("Test 1");
}
@Test
void Test2(){
    System.out.println("Test 2");
}
@AfterMethod
Void Method2(){
    System.out.println("After Method");
    return null;
}
}
