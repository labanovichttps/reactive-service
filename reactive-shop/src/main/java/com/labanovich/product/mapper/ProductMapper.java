package com.labanovich.product.mapper;

import com.labanovich.product.dto.ProductCreateUpdateDto;
import com.labanovich.product.dto.ProductDto;
import com.labanovich.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductMapper {

    ProductDto toProductDto(Product product);

    @Mapping(target = "id", ignore = true)
    Product createDtoToProduct(ProductCreateUpdateDto productCreateUpdateDto);

    Product updateDtoToProduct(ProductCreateUpdateDto productCreateUpdateDto, String id);
}
