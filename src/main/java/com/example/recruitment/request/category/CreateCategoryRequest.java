package com.example.recruitment.request.category;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateCategoryRequest {

    @NotBlank
    @ApiModelProperty(value = "Category name", example = "Example", required = true)
    private String name;

    @ApiModelProperty(value = "Category description", example = "Some description.")
    private String description;
}