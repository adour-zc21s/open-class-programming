package com.adour.openclassprog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/06/2026 - 13:10
 */

@Data
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String name;
    private String nik;
    private Double balance;
    private String accountNumber;
    private String hp;
    private String address;
    private String email;
}
