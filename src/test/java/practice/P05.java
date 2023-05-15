package practice;

import org.junit.*;

public class P05 {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class Calisti. Testler Calistirilacak");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After Class Çalisti. Testlerin çaliştirilmasi Bitti");
    }
    @Before
    public void before(){
        System.out.println("Yeni bir Test  Çalistiriliyor");
    }
    @After
    public void after(){
        System.out.println("Çalıştırılan test Sonlandiriliyor");
        System.out.println("================================");
    }
    @Test
    public void test01(){
        System.out.println("Test Case 01 Calistirildi");
    }
    @Test
    public void test02(){
        System.out.println("Test Case 02 Calistirildi");
    }
    @Test
    public void test03(){
        System.out.println("Test Case 03 Calistirildi");
    }
}
