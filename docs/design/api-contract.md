# API-szerződés

A böngészős felület és a helyben futó Java-alkalmazás HTTP-kérésekkel kommunikál.
Az alapútvonal /api. A kérések és válaszok JSON-formátumúak, UTF-8 kódolással.
A dátum formátuma YYYY-MM-DD (például 2026-12-10).
Ez tervezési szerződés; az API még nincs megvalósítva.

## Műveletek

| Művelet | API | Metódus | Sikeres válasz | Megjegyzés |
| --- | --- | --- | --- | --- |
| Tantárgyak listázása | /api/tantargyak | GET | 200, tantárgyak tömbje | Az űrlap és a szűrő feltöltéséhez; üresen []. |
| Tantárgy felvétele | /api/tantargyak | POST | 201, létrehozott tantárgy | F-01; BR-01, BR-08–BR-10. |
| Beadandók listázása | /api/beadandok | GET | 200, beadandók tömbje | F-03; üresen []. |
| Tantárgy szerinti szűrés | /api/beadandok?tantargyId=1 | GET | 200, szűrt tömb | F-03; csak létező tantárgyra. |
| Beadandó rögzítése | /api/beadandok | POST | 201, létrehozott beadandó | F-02; kezdőállapot false. |
| Készre jelölés | /api/beadandok/{id}/kesz | PUT | 200, frissített beadandó | F-04; nincs kérésbody; ismételve is kész marad. |

A listák azonosító szerint növekvők. Az első változatban nincs lapozás.
A kérésbody Content-Type fejléce application/json.
Az azonosítók pozitív, Java long tartományú egész számok.
A csak olvasható mezőket (id, kesz, tantargyNev) a kliens nem küldheti létrehozáskor.
Ismeretlen mezőre 400-as válasz érkezik.

## Tantárgy létrehozása

POST /api/tantargyak

Kérés:

```json
{"nev":"Programozás"}
```

Válasz (201):

```json
{"id":1,"nev":"Programozás"}
```

A GET /api/tantargyak ugyanilyen objektumok tömbjét adja vissza.

## Beadandó létrehozása

POST /api/beadandok

Kérés:

```json
{"cim":"Osztálydiagram","tantargyId":1,"hatarido":"2026-12-10"}
```

Válasz (201):

```json
{"id":1,"cim":"Osztálydiagram","tantargyId":1,"tantargyNev":"Programozás","hatarido":"2026-12-10","kesz":false}
```

A lista ugyanilyen objektumok tömbje. A tantargyNev a kapcsolódó tantárgyból
származó megjelenítési adat; a beadandó tárolásában nem kell megismételni.

## Készre jelölés

PUT /api/beadandok/1/kesz – kérésbody nélkül.

Válasz (200):

```json
{"id":1,"cim":"Osztálydiagram","tantargyId":1,"tantargyNev":"Programozás","hatarido":"2026-12-10","kesz":true}
```

A cím, a tantárgy és a határidő nem változik. Ugyanezen kérés ismétlése 200-as
választ ad, változatlan kész állapottal.

## Hibaválaszok

| Kód | Eset | Példa |
| --- | --- | --- |
| 400 | Hibás JSON, hiányzó/hibás mező, ismeretlen mező vagy hibás azonosítóformátum | Üres cím, érvénytelen dátum, negatív azonosító. |
| 404 | A megfelelő formátumú azonosítóhoz nincs rekord | Nem létező tantárgy szűréskor/rögzítéskor; nem létező beadandó készre jelöléskor. |
| 415 | A JSON-kérést nem application/json típussal küldik | Hibás Content-Type a POST-kérésben. |
| 500 | Belső vagy adattárolási hiba | A mentés nem sikerült. |

Egységes hibatörzs:

```json
{"kod":"HIBAS_ADAT","uzenet":"A cím kitöltése kötelező.","mezo":"cim"}
```

A kod értékei: HIBAS_ADAT (400), NEM_TALALHATO (404),
NEM_TAMOGATOTT_FORMATUM (415), BELSO_HIBA (500).
A mezo mező értéke null, ha a hiba nem köthető egyetlen mezőhöz.
Az uzenet magyar nyelvű, nem tartalmaz belső technikai részleteket.

A service először a bemenet formáját és értékeit ellenőrzi, majd a hivatkozott
rekord létezését. Hibánál nincs részleges mentés.
A felület hiba esetén megtartja a beírt adatokat; sikeres mentés után frissíti a listát.

## Helyi működés

Az alkalmazás kizárólag a helyi gépről érhető el, nincs bejelentkezés.
A felületet és az API-t ugyanaz az alkalmazás szolgálja ki.
Az indítási portot és a futtatási parancsot a megvalósítás README-je rögzíti.
