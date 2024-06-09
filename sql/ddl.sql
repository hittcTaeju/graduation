CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);


CREATE TABLE COMPETITION (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE INTEGRATION_ENTRY (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    event_type VARCHAR(255) NOT NULL,
    participant_name VARCHAR(255) NOT NULL,
    participant_grade VARCHAR(255) NOT NULL,
    participant_teamname VARCHAR(255) NOT NULL,
    user_id BIGINT,
    competition_id BIGINT,
    CONSTRAINT FK_User FOREIGN KEY (user_id) REFERENCES app_user(id),
    CONSTRAINT FK_Competition FOREIGN KEY (competition_id) REFERENCES Competition(id)
);

