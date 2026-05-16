Drop database db_consultas;

Create database db_consultas;

Use db_consultas;

CREATE TABLE IF NOT EXISTS Cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    cpf varchar(11) NOT NULL,
    email VARCHAR(150) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    nascimento DATE NOT NULL
);
    

CREATE TABLE IF NOT EXISTS Medico (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome varchar(150) not null,
    cpf varchar(11) not null,
    telefone varchar(11) not null,
    nomeEspecialidade varchar(30)
    );
       
    
Create table if not exists Consulta (
	Protocolo bigint primary key auto_increment,
	dataConsulta date not null,
    hora time not null,
    status varchar(15),
    id_cliente int,
    foreign key (id_cliente) references Cliente(id),
    id_medico int,
    foreign key (id_medico) references Medico(id)
);
    
    
Create table if not exists Atendente (
	id int primary key auto_increment,
	nome varchar(150) not null,
	cpf VARCHAR(11) not null
);