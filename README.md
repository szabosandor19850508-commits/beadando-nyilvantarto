# Beadandó-nyilvántartó

Egyszerű Java-alapú beadandó-nyilvántartó – kétszemélyes egyetemi projekt.

## Cél

Az alkalmazás segítségével egy hallgató tantárgyanként nyilvántarthatja
beadandóit, azok határidejét és elkészültségi állapotát.

A projekt hangsúlya a követelmények megfogalmazásán, a rendszer megtervezésén,
a dokumentáción és a követhető közös GitHub-munkán van.

## Tervezett funkciók

1. Tantárgy felvétele.
2. Beadandó rögzítése címmel, tantárggyal és határidővel.
3. Beadandók listázása és szűrése tantárgy szerint.
4. Beadandó készre jelölése.

Az első változat egyfelhasználós, helyben futó alkalmazás.
Regisztráció, bejelentkezés, e-mailes értesítés, szerkesztés és törlés
nem része az első változatnak.

## Tárolt adatok

- **Tantárgy:** azonosító, név.
- **Beadandó:** azonosító, cím, tantárgy, határidő, készültségi állapot.

Egy tantárgyhoz több beadandó tartozhat. Egy beadandó pontosan egy tantárgyhoz tartozik.

## Munkamegosztás

| Csapattag | Követelmények |
| --- | --- |
| Szabó Sándor Zoltán | F-01, F-02, NF-01, NF-02 |
| Besenyei Bendegúz (`bendeguz989`) | F-03, F-04, NF-03, NF-04 |

A táblázat a tervezett felelősségeket jelöli, nem az elkészült munka szerzőségét.

## Dokumentáció

- [Követelmények és elfogadási kritériumok](docs/requirements.md)
- [Architektúra: UML-diagramok és elfogadott ADR](docs/architecture/README.md)
- [Részletes tervezés: szabályok, ERD, API, folyamat és képernyővázlat](docs/design/README.md)

## Technológia és állapot

- Programozási nyelv: **Java**.
- A 2–4. feladat tervezési dokumentációja elkészült.
- Felület: ugyanazon helyi Java-alkalmazás által kiszolgált böngészős oldal és HTTP API.
- A tartós adattárolás technológiája és a pontos Java-verzió a megvalósításkor rögzítendő.
- Futtatható program még nem készült; az indítási és tesztelési útmutató
  a megvalósítással együtt kerül ide.

## Közös munka

A fejlesztési feladatokat GitHub issue-kban követjük, a kapcsolódó
követelményazonosítók feltüntetésével. Mindkét csapattag a saját
GitHub-fiókjával rögzíti a változtatásait. A változtatásokat a másik
csapattag is átnézi.

Egy feladat akkor kész, ha az eredménye bekerült a repóba, a kapcsolódó
dokumentáció naprakész, és az elfogadási kritériumok ellenőrzésének
eredményét rögzítettük.
