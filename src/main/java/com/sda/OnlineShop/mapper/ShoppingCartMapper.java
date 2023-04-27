package com.sda.OnlineShop.mapper;

import com.sda.OnlineShop.dto.SelectedProductDto;
import com.sda.OnlineShop.dto.ShoppingCartDto;
import com.sda.OnlineShop.entities.SelectedProduct;
import com.sda.OnlineShop.entities.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

@Component
public class ShoppingCartMapper {
    @Autowired
    private SelectedProductMapper selectedProductMapper;

    public ShoppingCartDto map(ShoppingCart shoppingCart) {
        ShoppingCartDto shoppingCartDto = new ShoppingCartDto();
        List<SelectedProductDto> selectedProductDtosList = createSelectedProductDtosList(shoppingCart);

        Integer subtotal = computeSubtotal(selectedProductDtosList);
        shoppingCartDto.setSelectedProductDtos(selectedProductDtosList);
        shoppingCartDto.setSubtotal(String.valueOf(subtotal));
        shoppingCartDto.setShipping("30$");
        shoppingCartDto.setTotal(String.valueOf(subtotal + 30));
        return shoppingCartDto;
    }
    private Integer computeSubtotal(List<SelectedProductDto> selectedProductDtoList){
        int subtotal =0;
        for(SelectedProductDto selectedProductDto : selectedProductDtoList){
            int priceTimesQuantity = Integer.parseInt(selectedProductDto.getPriceTimesQuantity());
            subtotal += priceTimesQuantity;

        }
        return subtotal;
    }

    private List<SelectedProductDto> createSelectedProductDtosList(ShoppingCart shoppingCart) {
        List<SelectedProductDto> selectedProductDtosList = new ArrayList<>();
        for (SelectedProduct selectedProduct : shoppingCart.getSelectedProducts()) {
            SelectedProductDto selectedProductDto = selectedProductMapper.map(selectedProduct);
            selectedProductDtosList.add(selectedProductDto);
        }
        return selectedProductDtosList;
    }
}
