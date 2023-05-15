package practice;

import org.junit.Test;

public class P04 {
    /*
   @BeforeClass       // Sadece 1 kere çalışıyor
   @Before           //Her testten önce 1 kere çalışır
   @AfterClass      //Tüm testlerden sonra 1 kere çalışır
   @After          // her testten sonra 1 kere çalışır
   @Test          //Yapacağımız test kodlarının yer aldığı kısım
       */
    @Test
    public void ahmet(){
        System.out.println("Ahmet");
    }
    @Test
    public void berk(){
        System.out.println("Berk");
    }
    @Test
    public void cemil(){
        System.out.println("Cemil");
    }
}
