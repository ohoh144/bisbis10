CREATE TABLE IF NOT EXISTS Restaurant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    averageRating INT,
    isKosher BOOLEAN,
    cuisines JSON
);