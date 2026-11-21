# Java-egységtesztek ellenőrzése

- Dátum: 2026-11-20.
- A futtatást az előkészítés során Codex végezte a helyi Windows gépen.
- Java: 21.0.8; Maven: 3.9.16; JUnit: 5.11.4.
- Maven-cél: test.
- Eredmény: **5 teszt, 0 sikertelenség, 0 hiba, 0 kihagyás; BUILD SUCCESS.**
- A futtatás a Maven Java-indítóján keresztül történt, mert a helyi mvn.cmd
  indító hozzáférési hibát adott. A projekt szokásos tesztparancsa: mvn test.

## Ellenőrzött viselkedés

1. Tantárgynév szóközmentesítése, egyedi azonosítók és tárolás.
2. Hiányzó, üres és túl hosszú tantárgynév elutasítása; 100 karakter elfogadása.
3. Új beadandó nem kész állapota, cím tisztítása, múltbeli határidő elfogadása.
4. Nem létező tantárgy elutasítása mentés nélkül.
5. Hibás beadandóadatok elutasítása részleges mentés nélkül; 150 karakter elfogadása.

Ez a domainréteg tesztje, nem UI-, API-, Docker- vagy tartós tárolási teszt.
Bendegúz saját műveleteinek tesztjei még hátravannak.
