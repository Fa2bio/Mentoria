create table Livro_autores (
	Livro_id BIGINT NOT NULL,
	autores VARCHAR(255),
	
	constraint livro_autores_livro 
	foreign key (Livro_id) 
	references livro (id)
);