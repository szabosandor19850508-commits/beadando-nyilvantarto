# Követelmények

## A projekt célja és határai

Egyszerű Java-alapú alkalmazás, amellyel egy hallgató tantárgyanként
nyilvántarthatja beadandóit, azok határidejét és elkészültségét.
Az első változat egyfelhasználós, helyben futó alkalmazás.
Regisztráció, bejelentkezés, e-mailes értesítés, szerkesztés és törlés nem része az első változatnak.
A felület és az adattárolás technológiáját a későbbi tervezés rögzíti.

Az alábbi követelmények tervezett elvárások; teljesítésüket a megvalósítás után kell ellenőrizni.
A felelősök jelölése munkamegosztási javaslat, nem szerzőségi állítás.


## Munkamegosztás

| Csapattag | Funkcionális követelmények | Nem funkcionális követelmények |
| --- | --- | --- |
| Szabó Sándor Zoltán | F-01, F-02 | NF-01, NF-02 |
| Besenyei Bendegúz (`bendeguz989`) | F-03, F-04 | NF-03, NF-04 |

## Funkcionális követelmények

### F-01 – Tantárgy felvétele

**Felelős:** Szabó Sándor Zoltán

**Description / Felhasználói történet:** Hallgatóként szeretnék tantárgyat felvenni, hogy a beadandóimat tantárgyakhoz rendelhessem.

**Acceptance criteria / Elfogadási kritériumok:**

- **Adott**, hogy a tantárgyfelvételi felület nyitva van; **amikor** megadok egy 1–100 karakteres nevet és mentek; **akkor** létrejön egy egyedi azonosítójú tantárgy, és megjelenik a tantárgyak listájában.
- **Adott**, hogy új tantárgyat veszek fel; **amikor** üres, csak szóközöket tartalmazó vagy 100 karakternél hosszabb nevet mentek; **akkor** magyar nyelvű hibaüzenetet kapok, és nem jön létre tantárgy.
- A név elején és végén lévő szóközöket ellenőrzés és mentés előtt el kell távolítani.

### F-02 – Beadandó rögzítése

**Felelős:** Szabó Sándor Zoltán

**Description / Felhasználói történet:** Hallgatóként szeretnék címmel, tantárggyal és határidővel beadandót rögzíteni, hogy nyomon követhessem a teendőimet.

**Acceptance criteria / Elfogadási kritériumok:**

- **Adott**, hogy létezik legalább egy tantárgy; **amikor** megadok egy 1–150 karakteres címet, kiválasztok egy létező tantárgyat, megadok egy érvényes naptári dátumot és mentek; **akkor** a beadandó egyedi azonosítóval és „Nincs kész” állapottal megjelenik a listában.
- **Adott**, hogy beadandót rögzítek; **amikor** a cím üres, csak szóközökből áll vagy túl hosszú, a tantárgy hiányzik vagy nem létezik, illetve a határidő hiányzik vagy érvénytelen; **akkor** hibaüzenet jelenik meg, és nem történik mentés.
- **Adott**, hogy nincs még tantárgy; **amikor** beadandót szeretnék rögzíteni; **akkor** a felület jelzi, hogy először tantárgyat kell felvennem.
- A cím elején és végén lévő szóközöket ellenőrzés és mentés előtt el kell távolítani. Múltbeli határidő is megadható, hogy korábbi beadandók is rögzíthetők legyenek.

### F-03 – Beadandók listázása és szűrése

**Felelős:** Besenyei Bendegúz (`bendeguz989`)

**Description / Felhasználói történet:** Hallgatóként szeretném listázni és tantárgy szerint szűrni a beadandóimat, hogy áttekintsem az adott tantárgyhoz tartozó teendőket.

**Acceptance criteria / Elfogadási kritériumok:**

- **Adott**, hogy vannak mentett beadandók; **amikor** megnyitom a beadandólistát; **akkor** minden beadandó címe, tantárgya, határideje és állapota látható.
- **Adott**, hogy több tantárgyhoz tartoznak beadandók; **amikor** kiválasztok egy tantárgyat a szűrőben; **akkor** csak az ahhoz tartozó beadandók jelennek meg.
- **Adott**, hogy aktív a tantárgyszűrés; **amikor** az „Összes tantárgy” lehetőséget választom; **akkor** újra minden beadandó megjelenik.
- **Adott**, hogy a listának nincs eleme, vagy a szűrésnek nincs találata; **amikor** megtekintem a listát; **akkor** a „Nincs megjeleníthető beadandó.” üzenet látható.

### F-04 – Beadandó készre jelölése

**Felelős:** Besenyei Bendegúz (`bendeguz989`)

**Description / Felhasználói történet:** Hallgatóként szeretném készre jelölni a beadandómat, hogy megkülönböztethessem az elvégzett feladatokat a hátralévőktől.

**Acceptance criteria / Elfogadási kritériumok:**

- **Adott**, hogy egy beadandó állapota „Nincs kész”; **amikor** a hozzá tartozó „Készre jelölés” műveletet választom; **akkor** az állapota „Kész” lesz.
- **Adott**, hogy egy beadandót készre jelöltem; **amikor** újra megnyitom a listát; **akkor** továbbra is „Kész” állapottal jelenik meg.
- **Adott**, hogy több beadandó létezik; **amikor** egyet készre jelölök; **akkor** a többi beadandó adatai változatlanok maradnak.
- **Adott**, hogy a beadandó már kész; **amikor** megtekintem; **akkor** a „Készre jelölés” művelet nem választható ki újra. Az első változatban nincs visszaállítás.

## Nem funkcionális követelmények

### NF-01 – Magyar nyelvű felület

**Felelős:** Szabó Sándor Zoltán  
**Kategória:** Használhatóság

**Követelmény:** A felhasználónak szánt feliratok, gombok, állapotok és hibaüzenetek magyarul jelenjenek meg.

**Ellenőrzés:** Az F-01–F-04 folyamatokat és hibás adatmegadásokat végigjárva minden alkalmazás által megjelenített felirat magyar nyelvű. A felhasználó által megadott szövegek és a fejlesztői naplók nem tartoznak ide.

### NF-02 – Lista megjelenítési ideje

**Felelős:** Szabó Sándor Zoltán  
**Kategória:** Teljesítmény

**Követelmény:** Helyi futtatáskor, egy felhasználóval, legfeljebb 20 tantárgy és 100 beadandó esetén a lista megnyitása és tantárgy szerinti szűrése legfeljebb 2 másodperc alatt jelenítse meg az eredményt.

**Ellenőrzés:** Elindított alkalmazásban, 20 tantárggyal és 100 beadandóval mindkét műveletet ötször mérjük a kezdeményezéstől a megjelenésig. Mind a tíz mérés legfeljebb 2 másodperc legyen. A méréshez használt gépet, operációs rendszert és Java-verziót a tesztjegyzőkönyvben rögzítjük. Az alkalmazás indulási ideje nem része a mérésnek.

### NF-03 – Adatok megőrzése újraindítás után

**Felelős:** Besenyei Bendegúz (`bendeguz989`)  
**Kategória:** Megbízhatóság

**Követelmény:** A sikeresen mentett tantárgyak, beadandók és készültségi állapotok szabályos bezárás és újraindítás után megmaradjanak.

**Ellenőrzés:** Két tantárgyat és három beadandót rögzítünk, egy beadandót készre jelölünk, majd szabályosan bezárjuk és újraindítjuk az alkalmazást. Minden rögzített adatnak és állapotnak változatlanul meg kell jelennie.

### NF-04 – Reprodukálható helyi indítás

**Felelős:** Besenyei Bendegúz (`bendeguz989`)  
**Kategória:** Telepíthetőség

**Követelmény:** A projekt friss letöltésből elindítható legyen a README-ben felsorolt előfeltételek és parancsok alapján, forráskód-módosítás és fizetős szolgáltatás nélkül.

**Ellenőrzés:** A másik csapattag egy új mappába letölti a projektet, követi a README lépéseit, majd sikeresen felvesz egy tantárgyat és egy beadandót. A szükséges Java-verziót és egyéb eszközöket a megvalósításkor a README-ben pontosan rögzíteni kell.

## Követelmények követése

A fejlesztési issue-kban hivatkozunk a kapcsolódó követelményazonosítókra
(például F-02). A megvalósítás ellenőrzésekor a fenti elfogadási kritériumok
és ellenőrzési lépések alapján rögzítjük a tényleges eredményeket.
