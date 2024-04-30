package com.RestfullJaxx.hotel.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "locales")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Agrega un nombre de local")
    private String name;
    private String floor;
    @Length(min = 4, max = 10)
    private String code;


}
