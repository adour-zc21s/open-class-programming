package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.ItemMap;
import com.adour.openclassprog.dto.ItemDTO;
import com.adour.openclassprog.model.Item;
import com.adour.openclassprog.repository.ItemRepository;
import com.adour.openclassprog.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 13/08/2026 - 14:38
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
     private final ItemRepository itemRepository;
     private final ItemMap itemMap;
     public ItemServiceImpl(ItemRepository itemRepository, ItemMap itemMap) {
      this.itemRepository = itemRepository;
      this.itemMap = itemMap;
     }
     @Override
     public ItemDTO createItem(ItemDTO itemDTO) {
         Item item = itemMap.toEntity(itemDTO);
         Item simpanItem = itemRepository.save(item);
         return itemMap.toDTO(simpanItem);
     }
     @Override
     @Transactional(readOnly = true)
     public List<ItemDTO> getAllItems() {
         List<Item> items = itemRepository.findAll();
         return itemMap.toDTOList(items);
     }
     @Override
     @Transactional(readOnly = true)
     public ItemDTO getItemById(Long id) {
         Item item = itemRepository.findById(id)
                 .orElseThrow(()->new RuntimeException("Item not found with id" +id));
      return itemMap.toDTO(item);
     }
     @Override
     public ItemDTO updateItemById(Long id, ItemDTO itemDTO) {
         Item existingItem = itemRepository.findById(id)
                 .orElseThrow(()->new RuntimeException("Item not found with id:" +id));
         itemMap.updateEntityFromDto(itemDTO, existingItem);
         Item updateItem = itemRepository.save(existingItem);
         return itemMap.toDTO(updateItem);
     }
     @Override
     public void deleteItem(Long id) {
         if (!itemRepository.existsById(id)) {
             throw new RuntimeException("Item not found with id:" +id);
         }
         itemRepository.deleteById(id);
     }
}
