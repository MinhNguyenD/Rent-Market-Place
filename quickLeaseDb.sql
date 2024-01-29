CREATE DATABASE mlproject;

USE mlproject;

CREATE TABLE `user`(
	id INT PRIMARY KEY AUTO_INCREMENT,
	full_name VARCHAR(100),
	email VARCHAR(100),
    `password` VARCHAR(255),
	phone_num VARCHAR(20),
	date_of_birth DATE,
	gender BOOLEAN,
	`role` VARCHAR(50),
	avatar VARCHAR(1000)
);

CREATE TABLE location(
	id INT primary KEY auto_increment,
    location_name varchar(1000),
    country varchar(100),
    province varchar(100),
    city varchar(100),
    picture varchar(1000)
);
    
CREATE TABLE room(
	id INT PRIMARY KEY AUTO_INCREMENT,
	num_bed_room INT,
    num_bath_room INT,
    num_bed INT,
    room_description VARCHAR(1000),
    location_id INT, 
    foreign key (location_id) references location(id),
	cost_per_day FLOAT,
    picture VARCHAR(1000)
);

CREATE TABLE `comment`(
	id INT PRIMARY KEY AUTO_INCREMENT,
    room_id INT,
    FOREIGN KEY (room_id) REFERENCES room(id),
    user_id INT,
    foreign key (user_id) references `user`(id),
    comment_date DATE,
    content varchar(1000)
);

CREATE TABLE booking(
	id INT PRIMARY KEY AUTO_INCREMENT,
	room_id INT,
	FOREIGN KEY (room_id) REFERENCES room(id),
	user_id INT,
	FOREIGN KEY (user_id) REFERENCES `user`(id),
	start_date DATE,
	end_date DATE,
    num_guest INT
);