# Tantárgy és beadandó létrehozása Java-domainréteggel

Az F-01 és F-02 service-műveletei ellenőrzik a kötelező adatokat, a szöveghosszakat
és a tantárgy létezését. Az új beadandó „Nincs kész” állapotú, múltbeli határidővel
is rögzíthető.

Maven-projekt, memóriabeli teszttároló és öt JUnit-teszt készült.
Ellenőrzés: 5 teszt, 0 hiba, 0 sikertelenség; BUILD SUCCESS.
A tároló még nem teljesíti az NF-03 tartós mentési követelményét.
Ez a domainréteg első része, nem teljes webalkalmazás.

A Docker-gyakorlathoz névkiíró image és MySQL 8.4 + phpMyAdmin Compose-konfiguráció
is szerepel a csomagban. Docker-futtatás még nincs igazolva.
Bendegúz két service-művelete és saját tesztjei külön feladatként maradtak meg.

A PR végére írd: Closes #N
Az N helyére a Sándor-feladathoz létrehozott issue valódi számát írd.
