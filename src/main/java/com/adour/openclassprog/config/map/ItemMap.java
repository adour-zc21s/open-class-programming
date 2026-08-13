package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.ItemDTO;
import com.adour.openclassprog.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 13/08/2026 - 14:31
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ItemMap {
    ItemDTO toDTO(Item item);

    Item toEntity(ItemDTO dto);

    List<ItemDTO> toDTOList(List<Item> items);

    void updateEntityFromDto(ItemDTO dto, @MappingTarget Item item);
}
