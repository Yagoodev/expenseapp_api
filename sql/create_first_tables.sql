DROP TABLE IF EXISTS tb_transactions;
DROP TABLE IF EXISTS tb_transactions_icon;
DROP TABLE IF EXISTS tb_users;

CREATE TABLE tb_users (
    id UUID DEFAULT gen_random_uuid() UNIQUE,
    created_at TIMESTAMP DEFAULT NOW() NOT NULL,
    updated_at DATE,
    username VARCHAR(255)
);

CREATE TABLE tb_transactions_icon (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    path VARCHAR(255) NOT NULL
);

CREATE TABLE tb_transactions (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT NOW() NOT NULL,
    updated_at DATE,
    user_id UUID NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    type VARCHAR(50) NOT NULL CHECK (type IN ('income', 'expense')),
    amount NUMERIC(15, 2) NOT NULL CHECK (amount > 0),
    currency VARCHAR(3) NOT NULL CHECK (char_length(currency) = 3),
    icon_id INT REFERENCES tb_transactions_icon(id),

    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE
);