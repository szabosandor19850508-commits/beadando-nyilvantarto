# Közös Java-teszteredmény

- Ellenőrzés dátuma: 2026-11-21.
- Ellenőrzött változat: bcae2109497809f54a94a7a4cb37d3b60d8c683c,
  Bendegúz #4-es PR-jának javított változata.
- A teszteket Codex futtatta a helyi Windows gépen,
  a GitHubról lekért források elkülönített másolatán.
- Környezet: Java 21, Maven 3.9.16, JUnit 5.
- Maven-cél: test.

## Eredmény

| Tesztosztály | Tesztek | Sikertelen | Hiba | Kihagyott |
| --- | ---: | ---: | ---: | ---: |
| NyilvantartoServiceTest | 6 | 0 | 0 | 0 |
| BendeguzServiceTest | 3 | 0 | 0 | 0 |
| Összesen | 9 | 0 | 0 | 0 |

**BUILD SUCCESS**

A tesztek ellenőrzik a tantárgyak és beadandók létrehozását,
a hibás bemenetek kezelését, a listázást és szűrést,
valamint a készre jelölést.

A review során hozzáadott tesztek ellenőrzik az azonos című
beadandók külön tárolását és a nem létező beadandó
készre jelölésének elutasítását is.

Ez a domainréteg ellenőrzése. A Docker-próbák eredményét
a docker-eredmeny.md dokumentum tartalmazza.

A sandor-eredmeny.md és junit-eredmeny.txt fájlok a korábbi,
2026-11-20-i, öt tesztből álló futtatás eredményét őrzik.
