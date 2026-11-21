package hu.beadando.domain;

import java.time.LocalDate;

/** Megváltoztathatatlan adatobjektum; módosításkor új példány kerül a tárolóba. */
public record Beadando(long id, String cim, Tantargy tantargy,
                       LocalDate hatarido, boolean kesz) {}
