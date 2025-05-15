-- Table: medicine (master data)
CREATE TABLE IF NOT EXISTS medicine (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    dosage VARCHAR(50),
    CONSTRAINT unique_medicine UNIQUE (name, dosage)
);

-- Table: medicine_schedule (timing & usage tracking)
CREATE TABLE IF NOT EXISTS medicine_schedule (
    id INT PRIMARY KEY AUTO_INCREMENT,
    medicine_id INT NOT NULL,
    start_date DATE,
    end_date DATE,
    timing VARCHAR(50),
    taken_today BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (medicine_id) REFERENCES medicine(id) ON DELETE CASCADE
);

-- Table: medicine_stock (current stock and price info)
CREATE TABLE IF NOT EXISTS medicine_stock (
    id INT PRIMARY KEY AUTO_INCREMENT,
    medicine_id INT NOT NULL,
    stock_count INT,
    price_per_unit DOUBLE,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (medicine_id) REFERENCES medicine(id) ON DELETE CASCADE
);

-- Table: expense (one entry per refill)
CREATE TABLE IF NOT EXISTS expense (
    id INT PRIMARY KEY AUTO_INCREMENT,
    medicine_stock_id INT NOT NULL,
    refill_date DATE,
    quantity INT,
    total_amount DOUBLE,
    FOREIGN KEY (medicine_stock_id) REFERENCES medicine_stock(id) ON DELETE CASCADE
);
