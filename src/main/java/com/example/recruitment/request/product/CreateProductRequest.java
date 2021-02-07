package com.example.recruitment.request.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateProductRequest {

    @NotBlank
    @ApiModelProperty(value = "Product name", example = "Example", required = true)
    private String name;

    @ApiModelProperty(value = "Product description", example = "Some description.")
    private String description;

    @NotNull
    @ApiModelProperty(value = "Product category id", example = "1", required = true)
    private Long category;
}
