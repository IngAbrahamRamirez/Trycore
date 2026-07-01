package com.pruebatecnica.api.fixtures;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public final class TestConstants {

    private TestConstants() {
    }

    // UUIDs

    public static final UUID USER_ID =
            UUID.fromString("11111111-1111-1111-1111-111111111111");

    public static final UUID PROJECT_ID =
            UUID.fromString("22222222-2222-2222-2222-222222222222");

    public static final UUID ACTIVITY_ID =
            UUID.fromString("33333333-3333-3333-3333-333333333333");

    // User

    public static final String FIRST_NAME = "Abraham";
    public static final String LAST_NAME = "Ramirez";
    public static final String EMAIL = "abraham@test.com";
    public static final String PASSWORD = "12345678";

    // Project

    public static final String PROJECT_NAME = "Sistema ERP";
    public static final String PROJECT_DESCRIPTION = "Proyecto principal";

    public static final LocalDate START_DATE =
            LocalDate.of(2026, 1, 1);

    public static final LocalDate END_DATE =
            LocalDate.of(2026, 12, 31);

    // Activity

    public static final String ACTIVITY_NAME =
            "Diseño Base de Datos";

    public static final BigDecimal BAC =
            new BigDecimal("15000");

    public static final BigDecimal PLANNED_PERCENTAGE =
            new BigDecimal("40");

    public static final BigDecimal ACTUAL_PERCENTAGE =
            new BigDecimal("35");

    public static final BigDecimal ACTUAL_COST =
            new BigDecimal("5200");

}