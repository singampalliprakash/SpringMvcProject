package com.sathya.mvc.model;

<<<<<<< HEAD
import jakarta.validation.constraints.Min;   
=======
import jakarta.validation.constraints.Min;
>>>>>>> a6786815b5313ca26a241520e49137625c14d96f
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;   
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductModel 
{
	@NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price must be a positive number")
    private Double price;

    @NotNull(message = "Quantity cannot be null")
    @PositiveOrZero(message = "Quantity must be zero or a positive number")
    private Integer quantity;

    @NotBlank(message = "Brand cannot be blank")
    private String brand;

    @NotBlank(message = "Country of origin cannot be blank")
    private String madein;

}
