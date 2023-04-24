package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

  /**
   * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
   */
  @Test
  void kdyMaSvatek() {
    Svatky svatky = new Svatky();
    assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
    assertNull(svatky.kdyMaSvatek("Eva"));
  }

  /**
   * Testuje metodu {@link Svatky#jeVSeznamu(String)}
   */
  @Test
  void jeVSeznamu() {
    //TODO Otestovat, že najde v seznamu existující jméno a nenajde neexistující jméno
    Svatky svatky = new Svatky();
    assertTrue(svatky.getSeznamJmen().contains("Valdemar"));
    assertFalse(svatky.getSeznamJmen().contains("Waldemar"));
  }

  /**
   * Testuje metodu {@link Svatky#getPocetJmen()}
   */
  @Test
  void getPocetJmen() {
    //TODO Otestovat, že vrací počet jmen, která máme v seznamu
    Svatky svatky = new Svatky();
    assertEquals(svatky.getPocetJmen(),37);

  }

  /**
   * Testuje metodu {@link Svatky#getSeznamJmen()}
   */
  @Test
  void getSeznamJmen() {
    //TODO Zkontrolovat, že seznam jmen má správný počet položek.
    Svatky svatky = new Svatky();
    // Predpokladam, ze se tim mini pocet zaznamu v mape..
    assertEquals(svatky.pocetZaznamu(),37);
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
   */
  @Test
  void pridatSvatekDenMesicInt() {
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Silvestr", 31, 12);
    assertTrue(svatky.jeVSeznamu("Silvestr"));
    //takto se otestuje spravny mesic
    assertEquals(svatky.kdyMaSvatek("Silvestr").getMonthValue(),12);
    assertEquals(svatky.kdyMaSvatek("Silvestr").getDayOfMonth(),31);
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
   */
  @Test
  void pridatSvatekDenMesicMonth() {
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Pravoslav", 12, Month.JANUARY);
    //takto se otestuje spravny mesic
    assertEquals(svatky.kdyMaSvatek("Pravoslav").getMonthValue(),1);
    assertEquals(svatky.kdyMaSvatek("Pravoslav").getDayOfMonth(),12);
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
   */
  @Test
  void prridatSvatekMonthDay() {
    //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Milena", MonthDay.of(1, 24));
    //takto se otestuje spravny mesic
    assertEquals(svatky.kdyMaSvatek("Milena").getMonthValue(),1);
    assertEquals(svatky.kdyMaSvatek("Milena").getDayOfMonth(),24);

  }

  /**
   * Testuje metodu {@link Svatky#smazatSvatek(String)}
   */
  @Test
  void smazatSvatek() {
    //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
    Svatky svatky = new Svatky();
    assertEquals(svatky.getPocetJmen(), 37);
    // Jmeno Valdemar se tam vyskytuje, takze to z duvodu zadani tuto skutecnost netestuji
    svatky.smazatSvatek("Valdemar");
    assertEquals(svatky.getPocetJmen(),36);
  }
}
