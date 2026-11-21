package hu.beadando.domain;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BendeguzServiceTest {
    private MemoriaAdattar adattar;
    private NyilvantartoService service;

    @BeforeEach
    void elokeszit() {
        adattar = new MemoriaAdattar();
        service = new NyilvantartoService(adattar);
    }

    @Test
    void tantargySzerintSzurEsSzuroNelkulMindentListaz() {
        var java = service.tantargyLetrehoz("Java");
        var matek = service.tantargyLetrehoz("Matematika");
        var datum = LocalDate.of(2026, 12, 10);

        var elso = service.beadandoLetrehoz(
                "Java feladat", java.id(), datum);
        var masodik = service.beadandoLetrehoz(
                "Matek feladat", matek.id(), datum);

        assertEquals(
                List.of(elso),
                service.beadandokListaz(java.id()));

        assertEquals(
                List.of(elso, masodik),
                service.beadandokListaz(null));
    }

    @Test
    void csakAKivalasztottBeadandotJeloliKeszre() {
        var tantargy = service.tantargyLetrehoz("Java");
        var datum = LocalDate.of(2026, 12, 10);

        var elso = service.beadandoLetrehoz(
                "Első feladat", tantargy.id(), datum);
        var masodik = service.beadandoLetrehoz(
                "Második feladat", tantargy.id(), datum);

        service.keszreJelol(elso.id());

        var vart = new Beadando(
                elso.id(), elso.cim(), elso.tantargy(),
                elso.hatarido(), true);

        assertEquals(
                vart,
                adattar.beadandoKeres(elso.id()).orElseThrow());

        assertEquals(
                masodik,
                adattar.beadandoKeres(masodik.id()).orElseThrow());

        service.keszreJelol(elso.id());

        assertEquals(
                List.of(vart, masodik),
                adattar.beadandok());
    }
    @Test
    void nemLetezoBeadandoKeszreJeloleseHibatDob() {
        var tantargy = service.tantargyLetrehoz("Java");
        var beadando = service.beadandoLetrehoz(
                "Meglévő feladat",
                tantargy.id(),
                LocalDate.of(2026, 12, 10));

        assertThrows(
                IllegalArgumentException.class,
                () -> service.keszreJelol(beadando.id() + 1));

        assertEquals(
                List.of(beadando),
                adattar.beadandok());
    }
}
