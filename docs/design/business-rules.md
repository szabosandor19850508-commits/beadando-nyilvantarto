# Üzleti szabályok

A szabályok a [követelményekhez](../requirements.md) és a használati esetekhez kapcsolódnak.
Az első változat egyetlen hallgató helyben futó nyilvántartása.

| ID | Használati eset | Szabály |
| --- | --- | --- |
| BR-01 | F-01 – Tantárgy felvétele | A tantárgy neve kötelező, a szélső szóközök eltávolítása után 1–100 karakter. |
| BR-02 | F-02 – Beadandó rögzítése | A cím kötelező, a szélső szóközök eltávolítása után 1–150 karakter. |
| BR-03 | F-02 | Minden beadandó pontosan egy létező tantárgyhoz tartozik. Tantárgy nélkül nem menthető. |
| BR-04 | F-02 | A határidő kötelező, érvényes naptári dátum. Múltbeli dátum is megengedett. |
| BR-05 | F-02 | Az új beadandó állapota mindig „Nincs kész” (kesz = false). |
| BR-06 | F-03 – Listázás és szűrés | Szűrő nélkül minden beadandó látható; tantárgyszűrővel csak a kiválasztott tantárgyéi. A kész beadandók is megmaradnak a listában. |
| BR-07 | F-04 – Készre jelölés | Csak a kiválasztott beadandó állapota változik „Kész”-re. Visszaállítás nincs. |
| BR-08 | F-01–F-04 | Minden tantárgynak és beadandónak rendszer által kiosztott, egyedi, pozitív azonosítója van. |
| BR-09 | F-01, F-02, F-04 | Sikerjelzés csak sikeres tartós mentés után jelenhet meg. Hibás bevitel nem módosíthatja a tárolt adatokat. |
| BR-10 | F-01, F-02 | Azonos tantárgynév és azonos beadandócím megengedett; az azonosító különbözteti meg a rekordokat. |

## Határesetek

- Tantárgy nélkül az „Új beadandó” művelet helyett útmutatás jelenik meg: „Először vegyél fel egy tantárgyat.”
- Üres lista vagy találat nélküli szűrés: „Nincs megjeleníthető beadandó.”
- Kész beadandónál a készre jelölés gomb inaktív. Az API ismételt azonos kérésre is kész állapotot ad vissza, új rekordot nem hoz létre.
- A listák azonosító szerint növekvő sorrendben jelennek meg.
- Szerkesztés, törlés, bejelentkezés és értesítések nem részei ennek a változatnak.
