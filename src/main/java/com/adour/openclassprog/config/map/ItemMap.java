package com.adour.openclassprog.config.map;

import com.adour.openclassprog.dto.ItemDTO;
import com.adour.openclassprog.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 13:46
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ItemMap {
    ItemDTO toDTO(Item item);
    Item toEntity(ItemDTO itemDTO);
    List<ItemDTO> toDTOList(List<Item> itemsList);
    @Mapping(target = "code", ignore = true)
    void updateEntityFromDto(
            ItemDTO itemDTO,
            @MappingTarget Item item
    );
}
