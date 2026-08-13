package com.adour.openclassprog.controller;

import com.adour.openclassprog.config.map.ItemMap;
import com.adour.openclassprog.dto.ItemDTO;
import com.adour.openclassprog.service.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 13/08/2026 - 14:53
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/items")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@Tag(name = "Authorization", description = "The Authorization API. Contains a secure hello method")
public class ItemController {
    private final ItemService itemService;
    private final ItemMap itemMap;

    public ItemController(ItemService itemService, ItemMap itemMap) {
        this.itemService = itemService;
        this.itemMap = itemMap;
    }
    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {
        ItemDTO create = itemService.createItem(itemDTO);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<ItemDTO>> getAllItem() {
        return ResponseEntity.ok(itemService.getAllItems());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItemById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> updateItemById(
        @PathVariable Long id,
                @RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok(itemService.updateItemById(id, itemDTO));
    }
    public ResponseEntity<Void> deleteItemById(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
