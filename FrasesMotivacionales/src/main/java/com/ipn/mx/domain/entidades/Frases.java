// package com.ipn.mx.domain.entidades;

// import java.io.Serializable;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import jakarta.persistence.GenerationType;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @Entity
// public class Frases implements Serializable {
//     private static final long serialVersionUID = 1L;

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "idFrase", nullable = false)
//     private long id;

//     @Column(name = "textoFrase", nullable = false, length = 500)
//     private String textoFrase;

//     @Column(name = "autorFrase", nullable = false, length = 100)
//     private String autorFrase;
// }

package com.ipn.mx.domain.entidades;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank; // <-- Importación nueva
import jakarta.validation.constraints.Size;   // <-- Importación nueva
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Frases implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFrase", nullable = false)
    private long id;

    @NotBlank(message = "El texto de la frase no puede estar vacío.") // <-- Anotación añadida
    @Size(max = 500, message = "El texto de la frase no puede exceder los 500 caracteres.") // <-- Anotación añadida
    @Column(name = "textoFrase", nullable = false, length = 500)
    private String textoFrase;

    @NotBlank(message = "El autor de la frase no puede estar vacío.") // <-- Anotación añadida
    @Size(max = 100, message = "El autor no puede exceder los 100 caracteres.") // <-- Anotación añadida
    @Column(name = "autorFrase", nullable = false, length = 100)
    private String autorFrase;
}  