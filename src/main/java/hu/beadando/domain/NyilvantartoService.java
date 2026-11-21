package hu.beadando.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.List;

public final class NyilvantartoService {
    private final Adattar adattar;

    public NyilvantartoService(Adattar adattar) {
        this.adattar = Objects.requireNonNull(adattar);
    }

    public Tantargy tantargyLetrehoz(String nev) {
        return adattar.tantargyMent(new Tantargy(0, szoveg(nev, 100, "Tantárgynév")));
    }

    public Beadando beadandoLetrehoz(String cim, long tantargyId, LocalDate hatarido) {
        String tisztaCim = szoveg(cim, 150, "Cím");
        if (tantargyId <= 0) throw new IllegalArgumentException("A tantárgyazonosító pozitív legyen.");
        if (hatarido == null) throw new IllegalArgumentException("A határidő kitöltése kötelező.");
        var tantargy = adattar.tantargyKeres(tantargyId)
                .orElseThrow(() -> new IllegalArgumentException("A tantárgy nem létezik."));
        return adattar.beadandoMent(new Beadando(0, tisztaCim, tantargy, hatarido, false));
    }

    private String szoveg(String ertek, int maxHossz, String mezo) {
        if (ertek == null) throw new IllegalArgumentException(mezo + ": kötelező mező.");
        String tiszta = ertek.strip();
        if (tiszta.isEmpty() || tiszta.codePointCount(0, tiszta.length()) > maxHossz)
            throw new IllegalArgumentException(mezo + ": 1–" + maxHossz + " karakter szükséges.");
        return tiszta;
    }

    public List<Beadando> beadandokListaz(Long tantargyId) {
        if (tantargyId == null) {
            return adattar.beadandok();
        }

        if (tantargyId <= 0 || adattar.tantargyKeres(tantargyId).isEmpty()) {
            throw new IllegalArgumentException("A tantárgy nem létezik.");
        }

        return adattar.beadandok().stream()
                .filter(beadando -> beadando.tantargy().id() == tantargyId)
                .toList();
    }
     public void keszreJelol(long beadandoId) {
        if (beadandoId <= 0) {
            throw new IllegalArgumentException(
                    "A beadandóazonosító pozitív legyen.");
        }

        var beadando = adattar.beadandoKeres(beadandoId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "A beadandó nem létezik."));

        if (beadando.kesz()) {
            return;
        }

        var keszBeadando = new Beadando(
                beadando.id(),
                beadando.cim(),
                beadando.tantargy(),
                beadando.hatarido(),
                true
        );

        adattar.beadandoMent(keszBeadando);
    }
}
