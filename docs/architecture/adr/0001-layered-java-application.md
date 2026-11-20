# ADR-001 – Egyszerű réteges Java-alkalmazás

- **Állapot:** Elfogadva.
- **Dátum:** 2026-11-20
- **Kapcsolódó követelmények:** F-01–F-04, NF-03, NF-04.

## Helyzet

Kétszemélyes oktatási projektet készítünk négy alapfunkcióval.
A hangsúly az érthető terveken, a dokumentáción és a közös munkán van.
Az alkalmazás egy felhasználó számára, helyben fut. A mentett adatoknak
újraindítás után is meg kell maradniuk.

## Megvizsgált lehetőségek

1. Minden működés egyetlen osztályban: rövid induló kód, de összekeveri
   a megjelenítést, az ellenőrzést és az adattárolást.
2. Egy alkalmazás, külön felelősségű rétegekkel: egyszerűen indítható,
   a működési szabályok önállóan is ellenőrizhetők.
3. Több külön futó szolgáltatás: a négy funkcióhoz aránytalanul sok
   beállítást és szolgáltatások közötti kommunikációt igényelne.

## Döntés

A második lehetőséget választjuk: egyetlen, helyben indítható
Java-alkalmazást tervezünk, három felelősségi körrel.

| Rész | Felelősség | Példa |
| --- | --- | --- |
| Megjelenítés és kéréskezelés | Adatbevitel, eredmények és hibák megjelenítése; a kérések átadása | Beadandó űrlap és HTTP-végpont |
| Működési szabályok | Kötelező adatok ellenőrzése, műveletek végrehajtásának irányítása | NyilvantartoService |
| Adattárolás | Tantárgyak és beadandók tartós mentése, lekérdezése | Adattar |

A felület egyszerű böngészős oldal lesz; azt és a HTTP API-t ugyanaz
a Java-alkalmazás szolgálja ki a helyi gépen. Az API részletes szerződését
a 4. feladatban rögzítjük. Nem szükséges nyilvános szerverre telepíteni.

A felület nem ír közvetlenül az adattárolóba: a kéréskezelő a szolgáltatási
réteget hívja, az pedig az adattárolót. A Tantargy és Beadando osztályok
az adatokat írják le.

A Java-verzió, a keretrendszer és a tartós tárolás konkrét technológiája
későbbi döntés. Az Adattar nem pusztán memóriabeli lista: az NF-03 miatt
a végleges megoldásnak a folyamat leállítása után is meg kell őriznie az adatokat.

## Következmények

**Előnyök:**

- Egyetlen alkalmazást kell elindítani.
- A részek feladata könnyen elmagyarázható.
- A működési szabályok a képernyőtől elkülönítve tesztelhetők.
- A két csapattag külön részeken is dolgozhat.

**Hátrányok:**

- Több osztály szükséges, mint egy mindent tartalmazó megoldásnál.
- A rétegek helyes használatára a fejlesztés során figyelni kell.
- Az egyes részek nem telepíthetők külön; ebben a projektben ez nem igény.

## Mikor vizsgáljuk felül?

Ha a tanári elvárás más felületet ír elő, vagy többfelhasználós,
interneten elérhető rendszerre bővül a feladat.
