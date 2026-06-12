package com.adour.openclassprog.payload.res;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/06/2026 - 17:29
 */
@Data
@AllArgsConstructor
public class WebResponse <T>{
    private String message;
    private T data;
}
