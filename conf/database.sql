USE model;

drop table if exists AuthorsToBooks;
drop table if exists Books;
drop table if exists Authors;

/* Main tables */
CREATE TABLE Books (
    Id INTEGER PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Author VARCHAR(100) NOT NULL,
    Year INTEGER NOT NULL,
    Title VARCHAR(100) NOT NULL
)
CREATE TABLE Authors (
    Id INTEGER PRIMARY KEY IDENTITY(1,1) NOT NULL,
    Name VARCHAR(100) NOT NULL,
)

/* Linking table */
CREATE TABLE AuthorsToBooks (
    BookId INTEGER NOT NULL FOREIGN KEY REFERENCES Books (Id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    AuthorId INTEGER NOT NULL FOREIGN KEY REFERENCES Authors (Id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (BookId, AuthorId)
)