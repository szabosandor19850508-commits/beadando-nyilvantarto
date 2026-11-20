package hu.beadando.domain;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NyilvantartoServiceTest {
    private MemoriaAdattar adattar;
    private NyilvantartoService service;

    @BeforeEach void elokeszit() {
        adattar = new MemoriaAdattar();
        service = new NyilvantartoService(adattar);
    }

    @Test void tantargySzokozokNelkulEgyediAzonositovalMentodik() {
        var elso = service.tantargyLetrehoz("  Java  ");
        var masodik = service.tantargyLetrehoz("Java");
        assertEquals("Java", elso.nev());
        assertTrue(elso.id() > 0);
        assertNotEquals(elso.id(), masodik.id());
        assertEquals(elso, adattar.tantargyKeres(elso.id()).orElseThrow());
    }

    @Test void hibasTantargynevNemMentodik() {
        assertThrows(IllegalArgumentException.class, () -> service.tantargyLetrehoz(null));
        assertThrows(IllegalArgumentException.class, () -> service.tantargyLetrehoz("   "));
        assertThrows(IllegalArgumentException.class, () -> service.tantargyLetrehoz("a".repeat(101)));
        assertTrue(adattar.tantargyKeres(1).isEmpty());
        assertEquals(100, service.tantargyLetrehoz("a".repeat(100)).nev().length());
    }

    @Test void ujBeadandoNemKeszEsMultbeliHataridovelIsMentheto() {
        var t = service.tantargyLetrehoz("Java");
        var b = service.beadandoLetrehoz("  Első feladat  ", t.id(), LocalDate.of(2020, 1, 1));
        assertEquals("Első feladat", b.cim());
        assertFalse(b.kesz());
        assertEquals(t, b.tantargy());
        assertEquals(LocalDate.of(2020, 1, 1), b.hatarido());
        assertEquals(b, adattar.beadandoKeres(b.id()).orElseThrow());
    }

    @Test void nemLetezoTantargyhozNincsBeadando() {
        assertThrows(IllegalArgumentException.class,
                () -> service.beadandoLetrehoz("Feladat", 999, LocalDate.of(2026, 12, 1)));
        assertTrue(adattar.beadandok().isEmpty());
    }

    @Test void hibasBeadandoAdatokNemOkoznakReszlegesMentest() {
        var t = service.tantargyLetrehoz("Java");
        var datum = LocalDate.of(2026, 12, 1);
        assertThrows(IllegalArgumentException.class, () -> service.beadandoLetrehoz(null, t.id(), datum));
        assertThrows(IllegalArgumentException.class, () -> service.beadandoLetrehoz("  ", t.id(), datum));
        assertThrows(IllegalArgumentException.class, () -> service.beadandoLetrehoz("a".repeat(151), t.id(), datum));
        assertThrows(IllegalArgumentException.class, () -> service.beadandoLetrehoz("Feladat", t.id(), null));
        assertThrows(IllegalArgumentException.class, () -> service.beadandoLetrehoz("Feladat", 0, datum));
        assertTrue(adattar.beadandok().isEmpty());
        assertEquals(150, service.beadandoLetrehoz("a".repeat(150), t.id(), datum).cim().length());
    }
}
