# Docker-ellenőrzés

## Környezet

- Végrehajtó: Szabó Sándor Zoltán
- Docker Compose ellenőrzésének dátuma: 2026-11-23
- Operációs rendszer: Windows, Docker Desktop, WSL 2
- Docker verzió: 29.9.3, build 5457199
- Docker Compose verzió: v5.7.0

## Eredmények

| Ellenőrzés | Tényleges eredmény |
| --- | --- |
| hello-world | Korábbi futtatáskor megjelent a „Hello from Docker!” üzenet. |
| Saját image build | Sikeres; az Nginx-alapú image elkészült. |
| Mindkét név a böngészőben | A localhost:8080 oldalon megjelent Szabó Sándor Zoltán és Besenyei Bendegúz neve. |
| docker compose config --quiet | Hibaüzenet nélkül lefutott. |
| docker compose up -d --build | Mindhárom szolgáltatás elindult. |
| docker compose ps | A web és phpmyadmin szolgáltatás Up, a db Up (healthy) állapotú. |
| phpMyAdmin és MySQL | A localhost:8081 oldalon sikeres bejelentkezés; a beadando adatbázis elérhető. A használt image mysql:8.4. |

## Adatmegőrzési próba

A beadando adatbázisban létrehoztuk a docker_proba táblát,
és elmentettük az alábbi sort:

- id: 1
- szoveg: Az adatmegorzes mukodik

A docker compose down, majd docker compose up -d futtatása után,
a phpMyAdmin oldalának frissítését követően a sor megmaradt.
Az adatokat a mysql-data nevű Docker-kötet őrzi.

## A próba hatóköre

A Docker-weboldal a neveket megjelenítő bemutatóoldal.
A phpMyAdmin kapcsolódik a MySQL-adatbázishoz.
A Java domainkód külön, memóriában tárolt adatokkal működik;
a Java–MySQL kapcsolat nem része ennek a megvalósításnak.
