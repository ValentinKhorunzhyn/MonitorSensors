INSERT INTO catalogue.table_authority (authority) VALUES ('ADMIN'),('VIEWER');

INSERT INTO catalogue.table_user (user_name,password) VALUES ('mr.admin','{bcrypt}$2a$10$82R8C/aDKEUuOoywZI.pC.MtwXBYJ7OK9Oa9KW4smFFkIj5FH9yCm'),
															('mr.viewer','{bcrypt}$2a$10$UHSAQm3CykqUCtpZPxjNjucWc5E5TyriOptBlp4NFhgQGFolGqD8S');

INSERT INTO catalogue.table_user_authority (id_user,id_authority) VALUES (1,1),(2,2);