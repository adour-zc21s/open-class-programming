package com.adour.openclassprog.service;

import com.adour.openclassprog.dto.ItemDTO;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 13:50
 */
public interface ItemService {
    ItemDTO createItem(ItemDTO itemDTO);
    List<ItemDTO> getAllItem();
}
