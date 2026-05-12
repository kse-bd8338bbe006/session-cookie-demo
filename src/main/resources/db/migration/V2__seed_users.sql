-- Password 'student' -> BCrypt hash
INSERT INTO app_user (username, password, role)
VALUES ('student', '$2a$10$fzn9.msyD0iaLKIkFMCegepmPJO3HWoHSRqpfQIbZowqJfxyOslJm', 'USER');

-- Password 'admin' -> BCrypt hash
INSERT INTO app_user (username, password, role)
VALUES ('admin', '$2a$10$nXNdceq9RFhU8ia3A4rV5uH5ntNXsCkF.gTm/5mFwuLBWBw2xqa3.', 'ADMIN');
