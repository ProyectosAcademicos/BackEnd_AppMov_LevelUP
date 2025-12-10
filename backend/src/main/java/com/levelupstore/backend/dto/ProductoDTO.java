package com.levelupstore.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

    // No guardes manualmente la URL en BD
    private String imagenUrl;

    // Nombre del archivo real del backend
    private String imagenFile;

    private Integer stock;
    private String categoria;
    private Boolean activo;

    // 🔥 Genera automáticamente la URL completa
    public String getImagenUrl() {
        if (imagenFile == null || imagenFile.isEmpty()) {
            return null;
        }

        // IMPORTANTE:
        // Android NO usa "localhost", usa 10.0.2.2 para acceder al backend
        return "http://10.0.2.2:8080/uploads/" + imagenFile;
    }
}
