# Java-ohjelmoinnin tentti numero 2.

Ratkaisut koodataan Javalla. Palauta vastauksesi sähköpostilla opettajalle tänään klo 14.45 mennessä. Saatte puoli tuntia lisäaikaa sen takia, että voitte joutua selvittämään miten tenniksen pistelasku toimii. Pakkaa lähdekoodit ja lähetä pakattu tiedosto opettajalle. Paketti saa siis sisältää vain ja ainoastaan java-tiedostoja oikean nimisessä kansiossa. Pakkaa siis se kansio (paketti), jonne teit vastauksesi. Voit myös kopioida vastaukset Word-dokumenttiin, kunhan muistat muotoilla sisällön helposti luettavaksi.

Jos on kysyttävää, niin lähettäkää kysymykset viimeistään 12.45. Sen jälkeen en vastaa enää mihinkään eli lukekaa kysymykset huolella lävitse.

Tentistä pääsee lävitse vastaamalla oikein kahteen kysymykseen.

1. Toteuta seuraavaan koodiin konstruktorit ja täydennä toString-metodit. Kun opintojakso luodaan, niin opettajasta ei välttämättä ole mitään tietoa. Testaa myös, että koodisi toimii.

```
class Name {
    String forename;
    String surname;
    public String toString() {

    }

}

class StudyModule {
    String code;
    String name;
    int credit;
    Name teacher;

    public String toString() {

    }
}
```

2. Periytä luokka `StudyModule`. Uudessa luokassa tarvitaan uusina tietoina koulutusohjelma ja paikkojen lukumäärä (osallistujien maksimimäärä). Jos varustaisit kaikki ominaisuudet luokassa StudyModule avainsanalla `protected`, niin mitä hyötyä/haittaa siitä voisi olla?
3. Toteuta luokka, jonne voidaan tallentaa tennisottelun tulos. Luokassa on konstruktori, jolla luokalle välitetään pelaajien nimet. Lisäksi on oltava ainakin metodi, jolla voidaan lisätä erätulokset yksi erä kerrallaan. Tiebreakin tulosta ei tarvitse huomioida. Metodi toString palauttaa kutsujalle luokan sisällön.
4. Toteuta tehtävään kolme metodi, joka tarkistaa, että tenniserän tulos on kelvollinen. Tenniserän tulos on kelvollinen, jos voittajalla on 7 voitettua peliä ja häviäjällä 5–6 **tai** voittajalla on 6 voitettua peliä ja häviäjällä 0–4. Muista tarkistaa metodin toiminta hyvin.
