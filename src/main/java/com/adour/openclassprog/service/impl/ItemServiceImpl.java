package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.config.map.ItemMap;
import com.adour.openclassprog.dto.ItemDTO;
import com.adour.openclassprog.model.Customer;
import com.adour.openclassprog.model.Item;
import com.adour.openclassprog.repository.ItemRepository;
import com.adour.openclassprog.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 13:51
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
        Item saveItem = itemRepository.save(item);
        return itemMap.toDTO(saveItem);
    }

    @Override
    public List<ItemDTO> getAllItem() {
        List<Item> list = itemRepository.findAll();
        return itemMap.toDTOList(list);
    }
}
