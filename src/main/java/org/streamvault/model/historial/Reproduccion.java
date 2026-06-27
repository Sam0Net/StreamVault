package org.streamvault.model.historial;

import java.io.Serializable;
import java.time.LocalDateTime;

public record Reproduccion(String idContenido, String titulo, LocalDateTime fecha, int duracionSeg) implements Serializable {}
