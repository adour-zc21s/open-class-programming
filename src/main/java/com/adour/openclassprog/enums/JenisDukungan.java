package com.adour.openclassprog.enums;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 21/08/2026 - 15:11
 */
public enum JenisDukungan {
    Installation("Installation"),
    Configuration("Configuration"),
    Replacement("Replacement"),
    Throubleshoot("Throubleshoot"),
    Request("Request");
    private final String JenisDukungan;

    JenisDukungan(String jenisDukungan) {
        JenisDukungan = jenisDukungan;
    }
}
