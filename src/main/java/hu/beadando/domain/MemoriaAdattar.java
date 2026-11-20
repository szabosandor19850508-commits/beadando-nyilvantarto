package hu.beadando.domain;

import java.util.*;

/** Tesztekhez és helyi domain-gyakorlathoz; újraindításkor elveszti az adatokat. */
public final class MemoriaAdattar implements Adattar {
    private final Map<Long, Tantargy> tantargyak = new TreeMap<>();
    private final Map<Long, Beadando> beadandok = new TreeMap<>();
    private long kovetkezoTantargyId = 1;
    private long kovetkezoBeadandoId = 1;

    public Tantargy tantargyMent(Tantargy t) {
        if (t.id() != 0) throw new IllegalArgumentException("Új tantárgy azonosítója 0 legyen.");
        var mentett = new Tantargy(kovetkezoTantargyId++, t.nev());
        tantargyak.put(mentett.id(), mentett);
        return mentett;
    }

    public Optional<Tantargy> tantargyKeres(long id) {
        return Optional.ofNullable(tantargyak.get(id));
    }

    public Beadando beadandoMent(Beadando b) {
        if (!tantargyak.containsKey(b.tantargy().id()))
            throw new IllegalArgumentException("A tantárgy nem létezik.");
        if (b.id() != 0 && !beadandok.containsKey(b.id()))
            throw new IllegalArgumentException("A beadandó nem létezik.");
        long id = b.id() == 0 ? kovetkezoBeadandoId++ : b.id();
        var mentett = new Beadando(id, b.cim(), b.tantargy(), b.hatarido(), b.kesz());
        beadandok.put(id, mentett);
        return mentett;
    }

    public Optional<Beadando> beadandoKeres(long id) {
        return Optional.ofNullable(beadandok.get(id));
    }

    public List<Beadando> beadandok() {
        return List.copyOf(beadandok.values());
    }
}
