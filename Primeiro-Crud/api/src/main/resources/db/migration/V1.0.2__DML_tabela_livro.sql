ALTER TABLE livro DROP isbn;
ALTER TABLE livro ADD isbn_10 VARCHAR(10) NOT NULL;
ALTER TABLE livro ADD isbn_13 VARCHAR(13) NOT NULL;