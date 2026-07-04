create database in_pol;
use in_pol;
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('ADMIN','CUSTOMER') NOT NULL DEFAULT 'CUSTOMER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
desc users;
CREATE TABLE customer_profiles (
    profile_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    gender ENUM('Male','Female','Other'),
    date_of_birth DATE,
    occupation VARCHAR(100),
    annual_income DECIMAL(12,2),
    address VARCHAR(255),
    city VARCHAR(50),
    state VARCHAR(50),
    pincode VARCHAR(10),

    FOREIGN KEY (user_id)
    REFERENCES users(user_id)
    ON DELETE CASCADE
);
CREATE TABLE policy_categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL UNIQUE,
    description VARCHAR(255)
);
CREATE TABLE policies (
    policy_id INT AUTO_INCREMENT PRIMARY KEY,

    category_id INT NOT NULL,

    policy_name VARCHAR(100) NOT NULL,

    premium_amount DECIMAL(10,2) NOT NULL,

    coverage_amount DECIMAL(12,2) NOT NULL,

    duration_months INT NOT NULL,

    description TEXT,

    status ENUM('ACTIVE','INACTIVE') DEFAULT 'ACTIVE',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY(category_id)
    REFERENCES policy_categories(category_id)
);
CREATE TABLE purchases (

    purchase_id INT AUTO_INCREMENT PRIMARY KEY,

    policy_number VARCHAR(25) UNIQUE NOT NULL,

    user_id INT NOT NULL,

    policy_id INT NOT NULL,

    purchase_amount DECIMAL(10,2) NOT NULL,

    purchase_date DATE NOT NULL,

    expiry_date DATE NOT NULL,

    payment_status ENUM(
        'PAID',
        'PENDING',
        'FAILED'
    ) DEFAULT 'PENDING',

    status ENUM(
        'ACTIVE',
        'EXPIRED',
        'CANCELLED'
    ) DEFAULT 'ACTIVE',

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY(user_id)
    REFERENCES users(user_id),

    FOREIGN KEY(policy_id)
    REFERENCES policies(policy_id)
);
INSERT INTO users(full_name,email,password,role)
VALUES
('Administrator',
'admin@gmail.com',
'admin123',
'ADMIN');

