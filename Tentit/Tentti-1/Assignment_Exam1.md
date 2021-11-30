# Java-ohjelmoinnin tentti numero 1.

Ratkaisut koodataan Javalla. Palauta vastauksesi sähköpostilla opettajalle tänään klo 11.45 mennessä. Pakkaa lähdekoodit ja lähetä pakattu tiedosto opettajalle. Paketti saa siis sisältää vain ja ainoastaan java-tiedostoja oikean nimisessä kansiossa. Pakkaa siis se kansio (paketti), jonne teit vastauksesi.

Jos on kysyttävää, niin lähettäkää kysymykset viimeistään 10.15. Sen jälkeen en vastaa enää mihinkään eli lukekaa kysymykset huolella lävitse.

1. Toteuta kaksi sisäkkäistä for-silmukkaa, jotka tulostavat silmukoiden indeksimuuttujien arvot jokaisella kierroksella.
2. Mitä seuraava koodi tekee? Selitä jokainen rivi ja kerro mitä muuttujat a1, a2 ja a3 sisältävät, kun silmukka on suoritettu.

```
int[] a1 = {1,2,3,4,5};
int[] a2 = {5,4,3,2,1};
int[] a3 = new int[a1.length+a2.length];

for ( int i = 0; i \&lt; a1.length; i++ ) {
    a3[i\*2] = (int)Math.pow ( a1[i], a2[i] );
    a3[i\*2+1] = i\*10;
    int temp = a1[i];
    a1[i] = a2[i];
    a2[i] = temp;
}
```

3. Toteuta metodi, joka arpoo 10 lukua taulukkoon ja palauttaa taulukon kutsujalle.
4. Toteuta metodi, joka saa parametrinaan kaksi int-taulukkoa. Metodi palauttaa näissä taulukoissa tallessa olevien numeroiden summan, jos taulukot ovat samankokoisia. Jos ensimmäisenä tuleva taulukko on lyhyempi, niin palautetaan -1. Jos toinen on lyhyempi, niin palautetaan 1. Mikä voisi olla ongelma tässä toiminnassa?
