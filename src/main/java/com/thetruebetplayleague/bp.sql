DROP DATABASE IF EXISTS liga_betplay;

CREATE DATABASE liga_betplay;
USE liga_betplay;

-- locacion

CREATE TABLE IF NOT EXISTS country(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(70) NOT NULL
);
CREATE TABLE IF NOT EXISTS city(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(70) NOT NULL,
	country_id INT NOT NULL,
	FOREIGN KEY(country_id) REFERENCES country(id)
);

CREATE TABLE stadium(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	id_city INT NOT NULL,
	capacity INT NOT NULL,
	FOREIGN KEY(id_city) REFERENCES city(id)
) ;

-- EQUIPO

CREATE TABLE IF NOT EXISTS team (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    played_games INT DEFAULT 0,
    won_games INT DEFAULT 0,
    lost_games INT DEFAULT 0,
    tied_games INT DEFAULT 0,
    scored_goals INT DEFAULT 0,
    goals_conceded INT DEFAULT 0,
    total_of_Points INT DEFAULT 0
) ENGINE = INNODB;

CREATE TABLE IF NOT EXISTS team_member(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(70) NOT NULL,
	last_name VARCHAR(70) NOT NULL,
	city_id INT NOT NULL,
	team_id INT NOT NULL,
	rol ENUM('Player', 'Medic', 'Technician'),
	FOREIGN KEY(city_id) REFERENCES city(id),
	FOREIGN KEY(team_id) REFERENCES team(id)
);




-- ROLES
CREATE TABLE IF NOT EXISTS medical_roles(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(70) NOT NULL
);

CREATE TABLE IF NOT EXISTS technical_roles(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(70) NOT NULL
);

CREATE TABLE IF NOT EXISTS positions(
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(70) NOT NULL
)ENGINE = INNODB;

-- MIEMBROS DE EQUIPO

CREATE TABLE IF NOT EXISTS technician(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	team_member_id INT NOT NULL,
	rol_id INT NOT NULL,
	FOREIGN KEY (team_member_id) REFERENCES team_member(id),
	FOREIGN KEY(rol_id) REFERENCES technical_roles(id)
);

CREATE TABLE IF NOT EXISTS medic(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	team_member_id INT NOT NULL,
	rol_id INT NOT NULL,
	FOREIGN KEY (team_member_id) REFERENCES team_member(id),
	FOREIGN KEY(rol_id) REFERENCES medical_roles(id)
);

CREATE TABLE IF NOT EXISTS player (
    id INT AUTO_INCREMENT PRIMARY KEY,
    team_id INT NOT NULL,
    squad_number INT NOT NULL,
    scored_goals INT DEFAULT 0,
    yellow_cards INT DEFAULT 0,
    red_cards INT DEFAULT 0,
    position_id INT NOT NULL,
    FOREIGN KEY (team_id) REFERENCES team(id),
    FOREIGN KEY(position_id) REFERENCES positions(id)
) ENGINE = INNODB;

-- PARTIDOS Y TABLAS INTERMEDIAS

CREATE TABLE IF NOT EXISTS game(
	id INT AUTO_INCREMENT PRIMARY KEY,
	game_date DATE NOT NULL
) ENGINE =  INNODB;


CREATE TABLE IF NOT EXISTS team_game(
	team_id INT NOT NULL,
	game_id INT NOT NULL,
	goals INT DEFAULT 0,
	is_local BOOL NOT NULL,
	PRIMARY KEY(team_id, game_id),
	FOREIGN KEY(team_id) REFERENCES team(id),
	FOREIGN KEY(game_id) REFERENCES game(id)
) ENGINE =  INNODB;


CREATE TABLE IF NOT EXISTS goal(
	id INT PRIMARY KEY AUTO_INCREMENT,
	player_id INT NOT NULL,
	game_id INT NOT NULL,
	goal_minute INT NOT NULL,
	FOREIGN KEY(player_id) REFERENCES player(id),
	FOREIGN KEY(game_id) REFERENCES team(id)
) ENGINE = INNODB;



