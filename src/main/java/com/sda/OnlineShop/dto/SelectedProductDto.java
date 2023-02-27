package com.sda.OnlineShop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectedProductDto {
    private String name;
    private String quantity;
    private String priceTimesQuantity;
}
