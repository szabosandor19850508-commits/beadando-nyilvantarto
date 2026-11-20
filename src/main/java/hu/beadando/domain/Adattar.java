package hu.beadando.domain;

import java.util.List;
import java.util.Optional;

/** Tárolási határ. A tartós megvalósítás későbbi feladat. */
public interface Adattar {
    Tantargy tantargyMent(Tantargy tantargy);
    Optional<Tantargy> tantargyKeres(long id);
    Beadando beadandoMent(Beadando beadando);
    Optional<Beadando> beadandoKeres(long id);
    List<Beadando> beadandok();
}
