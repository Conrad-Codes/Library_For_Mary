-- ROLLBACK;
BEGIN TRANSACTION;

DROP TABLE IF EXISTS book_author;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book_genre;
DROP TABLE IF EXISTS genre;
DROP TABLE IF EXISTS reading_list;
DROP TABLE IF EXISTS user_reading_list;
DROP TABLE IF EXISTS book_comment;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS series;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE series (
	series_id serial,
	series_name varchar,
	constraint pk_series_id primary key (series_id)
);

CREATE TABLE book (
	book_id serial,
	title varchar not null,
	isbn varchar,
	description varchar,
	published_date date not null,
	cover_art varchar,
	series_id int,
	CONSTRAINT pk_book_id PRIMARY KEY (book_id),
	constraint fk_series_series_id FOREIGN KEY (series_id) REFERENCES series(series_id)
);

CREATE TABLE author (
	author_id serial,
	author_name varchar,
	CONSTRAINT PK_author_id PRIMARY KEY (author_id)
);

CREATE TABLE book_author (
	book_author_id serial, 
	author_id int,
	book_id int,
	constraint pk_book_author primary key (book_author_id),
	constraint fk_author_author_id foreign key (author_id) references author(author_id),
	constraint fk_book_book_id foreign key (book_id) references book(book_id)	
);

CREATE TABLE genre (
	genre_id serial,
	genre_name varchar not null,
	constraint pk_genre_id primary key (genre_id)
);

CREATE TABLE book_genre (
	book_genre_id serial,
	book_id int,
	genre_id int,
	constraint pk_book_genre_id primary key (book_genre_id),
	constraint fk_book_book_id foreign key (book_id) references book(book_id),
	constraint fk_genre_genre_id foreign key (genre_id) references genre(genre_id)
);

CREATE TABLE user_reading_list (
	list_id serial,
	user_id int,
	constraint pk_list_id primary key (list_id),
	constraint fk_users_user_id foreign key (user_id) references users(user_id)
);

CREATE TABLE reading_list (
	reading_list_entry_id serial,
	list_id int,
	book_id int,
	constraint pk_reading_list_id primary key (reading_list_entry_id),
	constraint fk_book_book_id foreign key (book_id) references book(book_id),
	constraint fk_user_reading_list_list_id foreign key (list_id) references user_reading_list(list_id)
);

CREATE TABLE book_comment (
	comment_id serial,
	book_id int,
	user_id int,
	book_comment varchar,
	constraint pk_comment_id primary key (comment_id),
	constraint fk_book_book_id foreign key (book_id) references book(book_id),
	constraint fk_users_user_id foreign key (user_id) references users(user_id)
);

--create users
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

--create dummy table data
INSERT INTO series (series_name)
VALUES ('The Lord Of The Rings'), ('The Wheel Of Time'), ('Discworld'), ('The Kingkiller Chronicle'), ('A Song of Ice and Fire'), ('Hainish Cycle');

INSERT INTO author (author_name)
VALUES ('J R R Tolkien'), ('Robert Jordan'), ('Brandon Sanderson'), ('Terry Pratchett'), ('Patrick Rothfuss'), ('George R R Martin'), ('Ursula K Le Guin');

INSERT INTO genre (genre_name)
VALUES ('Science Fiction'), ('Fantasy'), ('Adventure'), ('Thriller'), ('Drama'), ('Mystery'), ('Suspense');

INSERT INTO book (title, isbn, description, published_date, cover_art, series_id)
VALUES ('The Fellowship of the Ring', '9780547928210', 'The beginning of a great adventure!', '07/29/1954', 'https://images-na.ssl-images-amazon.com/images/I/41gHG-a2OEL._SX331_BO1,204,203,200_.jpg', 1 ),
		('The Two Towers', '9780547928203', 'The middle of a great adventure!', '11/11/1954', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQRVeocJMduZrDIU2VmU5_i_TW8TGKLaMZ0LFckBxFFzJMdBy56', '1'),
		('The Return of the King', '9780547928210', 'The end of a great adventure!', '10/20/1955', 'https://i.harperapps.com/hcanz/covers/9780261103597/x293.jpg',1),
		('The Eye of the World', '9780312850098', 'The start of an Epic adventure!', '01/15/1990', 'https://images-na.ssl-images-amazon.com/images/I/81tBoQP5V+L.jpg', 2),
		('A Memory of Light', '9780765325952', 'The end of an Epic adventure!', '01/08/2013', 'https://images-na.ssl-images-amazon.com/images/I/81DcFQRTuOL.jpg', 2),
		('Mort', '9780062225719', 'Mort gets an offer he can not refuse.', '11/12/1987', 'https://m.media-amazon.com/images/I/41RwpLn8FuL.jpg', 3 ),
		('The Name of the Wind', '9780756404741', 'The tale of Kvothe begins.','03/27/2007', 'https://images-na.ssl-images-amazon.com/images/I/91b8oNwaV1L.jpg', 4),
		('The Wise man''s Fear', '9780756407919', 'The tale of Kvothe continues!', '03/01/2011', 'https://m.media-amazon.com/images/I/51qKDJ8lPeL.jpg', 4),
		('A Game of Thrones', '9780553381689', 'When you play the game of thrones, you win or you die. There is no middle ground.', '08/01/1996', 'https://images-na.ssl-images-amazon.com/images/I/914uNuOXwSL.jpg', 5),
		('A Dance with Dragons', '9780553582017', 'Spoiler: Pretty much everyone dies', '07/12/2011', 'https://images-na.ssl-images-amazon.com/images/I/81e1rZDeBBL.jpg', 5),
		('The Left Hand of Darkness', '9780441478125', 'Open yourself to Winter', '03/01/1969', 'https://images-na.ssl-images-amazon.com/images/I/81EtwGcbbpL.jpg', 6);

INSERT INTO book_genre (book_id, genre_id)
VALUES (1,2), (2,2), (3,2), (4,2), (5,2), (6,2), (7,2), (8,2), (9,2), (10,2), (11,1);

INSERT INTO book_author (author_id, book_id)
VALUES	(1,1), (1,2), (1,3), (2,4), (2,5), (3,5), (4,6), (5,7), (5,8), (6,9), (6,10), (7,11);

INSERT INTO book_comment (book_id, user_id, book_comment)
VALUES (1, 1, 'Ride on, Frodo'),
		(2,1, 'I like middle books in a series best'),
		(3,1, 'Oh my WOW!'),
		(4,1, 'EYE openeing!'),
		(5,1, 'Tai''shar Manetheren'),
		(6,1, 'Death must be the loneliest creature in the universe.'),
		(7,1, 'I want to be a traveling musician. Only without the tragic death part.'),
		(8,1, 'Spoiler alert: the sea in a storm, a night with no moon, and the anger of a gentleman'),
		(9,1, 'Not NED!'),
		(10,1, 'Dragons can''t dance, silly'),
		(11,1, 'Winter never looked so good');

INSERT INTO user_reading_list (user_id)
VALUES (1),(1);

INSERT INTO reading_list(list_id, book_id)
VALUES (1, 1), (1,2), (1,3), (2, 6), (2,11);

COMMIT TRANSACTION;
