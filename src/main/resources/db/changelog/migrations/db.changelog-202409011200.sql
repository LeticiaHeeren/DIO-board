--liquibase formatted sql
--changeset junior:202409011200
--comment: Create card history table

CREATE TABLE card_history (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    card_id BIGINT NOT NULL,
    from_column_id BIGINT NOT NULL,
    to_column_id BIGINT NOT NULL,
    moved_at TIMESTAMP WITH TIME ZONE NOT NULL,
    FOREIGN KEY (card_id) REFERENCES card(id),
    FOREIGN KEY (from_column_id) REFERENCES board_column(id),
    FOREIGN KEY (to_column_id) REFERENCES board_column(id)
);

CREATE INDEX idx_card_history_card_id ON card_history(card_id);

--rollback DROP TABLE card_history;s