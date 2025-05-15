-- Insert medicines
-- Remove any existing record with the same name and dosage before inserting
DELETE FROM medicine WHERE name = 'Paracetamol' AND dosage = '500mg';

-- Now insert the record
INSERT INTO medicine (name, dosage) VALUES ('Paracetamol', '500mg');

INSERT INTO medicine (name, dosage) VALUES ('Amoxicillin', '250mg');

-- Insert schedules
INSERT INTO medicine_schedule (medicine_id, start_date, end_date, timing, taken_today)
VALUES (1, '2025-05-01', '2025-05-10', 'Morning', FALSE);

INSERT INTO medicine_schedule (medicine_id, start_date, end_date, timing, taken_today)
VALUES (2, '2025-05-05', '2025-05-15', 'Night', FALSE);

-- Insert stock
INSERT INTO medicine_stock (medicine_id, stock_count, price_per_unit)
VALUES (1, 10, 2.5);  -- Paracetamol

INSERT INTO medicine_stock (medicine_id, stock_count, price_per_unit)
VALUES (2, 15, 3.0);  -- Amoxicillin

-- Insert expenses
INSERT INTO expense (medicine_stock_id, refill_date, quantity, total_amount)
VALUES (1, '2025-05-01', 10, 25.0);  -- Paracetamol

INSERT INTO expense (medicine_stock_id, refill_date, quantity, total_amount)
VALUES (2, '2025-05-06', 15, 45.0);  -- Amoxicillin
