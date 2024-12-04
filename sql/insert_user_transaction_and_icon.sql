-- INSERT INTO transactions_icon (name, path) VALUES 
-- ('dollar_sign', ''),
-- ('shopping_cart', ''),
-- ('exchange_alt', ''),
-- ('home', '');

-- INSERT INTO users (username) VALUES ('yagodev');

INSERT INTO transactions (
    user_id,
    title,
    description,
    type,
    amount,
    currency,
    icon_id
) VALUES 
('3e8bc6d7-52eb-404b-a325-18ceeaf40402', 'Primeira inserção', '', 'income', 349.90, 'BRL', 1),
('3e8bc6d7-52eb-404b-a325-18ceeaf40402', 'Segunda inserção', '', 'expense', 1349.90, 'BRL', 2)

