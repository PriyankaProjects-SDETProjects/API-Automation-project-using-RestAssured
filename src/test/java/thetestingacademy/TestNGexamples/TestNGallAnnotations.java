package thetestingacademy.TestNGexamples;

import org.testng.annotations.*;

public class TestNGallAnnotations {
@BeforeSuite
    void Demo1(){
        System.out.println("BeforeSuite");
    }
@BeforeTest
    void Demo2(){
        System.out.println("BeforeTest");
    }
@BeforeClass
    void Demo3(){
        System.out.println("BeforeClass");
    }
@BeforeMethod
    void Demo4(){
        System.out.println("BeforeMethod");
    }
@Test
    void Demo5(){
        System.out.println("Test");
    }
    @AfterMethod
    void Demo6(){
        System.out.println("AfterMethod");
    }
@AfterClass
    void Demo7(){
        System.out.println("AfterClass");
    }
@AfterTest
    void Demo8(){
        System.out.println("AfterTest");
    }

    @AfterSuite

    void Demo9(){
        System.out.println("AfterSuite");
    }
}
