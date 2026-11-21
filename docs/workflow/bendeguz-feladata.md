# Bendegúz saját feladata – F-03 és F-04

A két service-művelet és saját tesztjei még nincsenek megírva.
A tárolási segédműveletek már rendelkezésre állnak.

## 1. Listázás és szűrés

A NyilvantartoService osztályba kerül:

```java
public List<Beadando> beadandokListaz(Long tantargyId)
```

- null szűrővel minden beadandó visszatér, azonosító szerint növekvően.
- Létező tantárgyazonosítóval csak annak beadandói térnek vissza.
- A kész beadandók is megmaradnak a listában.
- Nem pozitív vagy nem létező tantárgyazonosítónál IllegalArgumentException.
- Találat nélkül üres lista.

Saját tesztötlet: két tantárgyhoz hozz létre beadandókat, szűrj az egyikre,
és ellenőrizd, hogy kizárólag annak beadandója tér vissza.

## 2. Készre jelölés

```java
public void keszreJelol(long beadandoId)
```

- A kiválasztott beadandó kész állapottal mentődik.
- A többi adat és beadandó változatlan marad.
- Az ismételt készre jelölés ne okozzon hibát vagy új rekordot.
- Nem pozitív vagy nem létező azonosítónál IllegalArgumentException.
- A Beadando record változtathatatlan: új, azonos azonosítójú példányt kell
  elmenteni. Ezt a MemoriaAdattar már támogatja.

Saját tesztötlet: két beadandóból jelöld készre az egyiket, és ellenőrizd mindkettő állapotát.

## Saját GitHub-munka

1. A bendeguz989 fiókkal fogadd el a repó együttműködői meghívását.
2. Nézd át Sándor PR-jét: keress valódi javítási lehetőséget a követelmények,
   tesztek vagy dokumentáció alapján; írd le a review-ban.
3. Ellenőrizd a javítást is. Nem építünk mesterséges hibát a programba.
4. A merge után a friss main ágból indulj saját issue-hoz kapcsolt branchen:
   feature/bendeguz-listazas-keszre-jeloles.
5. Írd meg a két műveletet és legalább két saját tesztet a BendeguzServiceTest.java fájlban.
6. Futtasd az összes tesztet: mvn test.
7. Nyiss PR-t; ezt Sándor nézi át.

A leírás feladatkijelölés, nem már elvégzett munka igazolása.
