package br.com.dio.dto;

import java.time.OffsetDateTime;

public record CardHistoryDTO(
    Long id,
    Long cardId,
    String fromColumnName,
    String toColumnName,
    OffsetDateTime movedAt
) {}