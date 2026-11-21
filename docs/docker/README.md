# Docker – 6. feladat

## Elkészült előkészítés

- docker/Dockerfile: saját Nginx-image.
- docker/index.html: mindkét csapattag nevét megjelenítő oldal.
- compose.yaml: web, mysql:8.4 és phpMyAdmin.
- .env.example: környezeti változók mintája.

A stackben a phpMyAdmin az adatbázishoz kapcsolódó webalkalmazás.
A névkiíró Nginx-oldal statikus. A Java beadandó-kezelő adatbázis-integrációja
külön fejlesztés; ez a Docker-gyakorlat nem helyettesíti azt.

## Telepítés, hello-world

Telepítsd és indítsd el a [Docker Desktopot](https://docs.docker.com/desktop/setup/install/windows-install/)
Linux-konténerekkel. A projekt gyökérmappájában, PowerShellben:

```powershell
docker version
docker compose version
docker run --rm hello-world
```

Sikeres próba: „Hello from Docker!” jelenik meg.

## Saját image build

```powershell
docker build -t beadando-nevek:helyi ./docker
docker run --rm -d --name beadando-nevek-proba -p 127.0.0.1:8080:80 beadando-nevek:helyi
```

Nyisd meg: http://localhost:8080. Mindkét névnek meg kell jelennie.
A Compose előtt szabadítsd fel a portot:

```powershell
docker stop beadando-nevek-proba
```

## Compose stack

Másold a .env.example fájlt .env névre, ha még nincs ilyen, és módosítsd a két
példajelszót. A .env nem tölthető fel a GitHubra.

```powershell
docker compose config --quiet
docker compose up -d --build
docker compose ps
```

- Névkiíró oldal: http://localhost:8080
- phpMyAdmin: http://localhost:8081
- Felhasználó: beadando; jelszó: a saját .env MYSQL_PASSWORD értéke.
- Adatbázis: beadando; a phpMyAdmin a db szolgáltatáshoz kapcsolódik.
- A mysql-data volume megőrzi az adatokat.
- A MySQL-jelszavak inicializálása csak üres adatkönyvtárnál történik meg.

A phpMyAdminban válaszd ki a beadando adatbázist, majd az SQL lapon futtasd:

```sql
SELECT VERSION(), DATABASE();
```

A verzió 8.4-es MySQL, az adatbázis neve beadando legyen.

Leállítás adatmegőrzéssel:

```powershell
docker compose down
```

## Bizonyítékok

A tényleges futtatás eredményét a docs/testing/docker-eredmeny.md fájlba írjátok.
Most csak a konfiguráció készült el, sikeres Docker-futtatás nincs igazolva.

Források:
[Compose](https://docs.docker.com/compose/gettingstarted/),
[Nginx](https://hub.docker.com/_/nginx),
[MySQL](https://hub.docker.com/_/mysql),
[phpMyAdmin](https://hub.docker.com/_/phpmyadmin).
