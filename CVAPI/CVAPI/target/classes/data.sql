INSERT INTO bloodtypes (name) VALUES
 ('A+'), ('A-'), ('B+'), ('B-'), ('AB+'), ('AB-'), ('O+'), ('O-');

INSERT INTO genders (name) VALUES
('Hombre'), ('Mujer');

INSERT INTO organstypes (name) VALUES
('Riñón'), ('Pulmón'), ('Hígado'), ('Corazón');

INSERT INTO Hospitals (id_hospital, name, funds) VALUES
(1, 'Hospital General Madrid', 5000000.00),
(2, 'Clínica Barcelona', 3200000.50),
(3, 'Hospital La Paz', 7800000.75),
(4, 'Clínica San Carlos', 4500000.25),
(5, 'Hospital Virgen del Rocío', 9200000.00);

INSERT INTO Humans (name, birth_date, height, funds, smoker, email, password, id_gender, id_blood_type) VALUES
('Laura', '1990-06-15', 1.65, 1200.50, false, 'laura.martinez@example.com', 'securePass123', 2, 3),
('Julio', '1990-06-15', 1.65, 1200.50, false, 'sdafsdf.martinez@example.com', 'securePass123', 1, 5);


INSERT INTO patients (entry_date, status_active, id_human)
VALUES ('2025-01-12', true, 1);


INSERT INTO Organs (donated, price, id_organ_type, id_hospital, id_blood_type, id_patient) VALUES
(true, 65000.00, 1, 1, 1, 1),
(true, 50000.00, 2, 3, 2, 1),
(true, 70000.00, 3, 4, 3, 1),
(true, 70000.00, 4, 5, 4, 1);



INSERT INTO donors (id_human)
VALUES (2);








