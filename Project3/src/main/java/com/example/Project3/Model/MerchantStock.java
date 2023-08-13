package com.example.Project3.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@RequiredArgsConstructor
public class MerchantStock {
    @NotEmpty(message = "in MerchantStock class your Id where is't ?!")
    private String id;
    @NotEmpty(message = "in MerchantStock class your productId where is't ?!")
    private String productId;
    @NotEmpty(message = "in MerchantStock class your MerchantId where is't ?!")
    private String merchantId;
    @NotNull(message = "in MerchantStock class your Stock Why is null!!")
    @Range(message = "in MerchantStock class your stock is should be not more than 10 and our whereHose  can't stor more than 100",max = 1000,min = 11)
    private Integer stock;

}
