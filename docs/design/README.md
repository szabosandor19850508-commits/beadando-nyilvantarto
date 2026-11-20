# Részletes tervezés – 4. feladat

A terv a [követelményekre](../requirements.md) és az
[elfogadott architektúrára](../architecture/README.md) épül.

| Tanári feladat | Elkészült dokumentum |
| --- | --- |
| Use case-ekhez rendelt üzleti szabályok | [Üzleti szabályok](business-rules.md) |
| Adatmodell, kapcsolatok, kényszerek | [Adatmodell és ERD](data-model.md) |
| API-szerződés | [Műveletek, kérések, válaszok és hibák](api-contract.md) |
| User flow, tevékenység leírása | [Felhasználói folyamat](user-flow.md) |
| Wireframe / Mockup / Prototype valamelyike | [Wireframe: lista és adatbeviteli űrlapok](wireframes.md) |

A képek PNG-ben és szerkeszthető drawio formátumban is szerepelnek.
A wireframe teljesíti a felsorolt három UI-tervezési lehetőség egyikét;
külön működő prototípus nem része ennek a csomagnak.

## Követhetőség

| Követelmény | Szabályok | API | Képernyő |
| --- | --- | --- | --- |
| F-01 | BR-01, BR-08–BR-10 | POST /api/tantargyak | Új tantárgy |
| F-02 | BR-02–BR-05, BR-08–BR-10 | POST /api/beadandok | Új beadandó |
| F-03 | BR-06 | GET /api/beadandok | Lista és tantárgyszűrő |
| F-04 | BR-07, BR-09 | PUT /api/beadandok/{id}/kesz | Készre jelölés a listában |

A GET /api/tantargyak az űrlap és a szűrő segédművelete.
Az NF-01 magyar feliratokkal, az NF-03 tartós mentéssel jelenik meg a tervben.
Az NF-02 és NF-04 tényleges ellenőrzése a program elkészülte után végezhető el.
