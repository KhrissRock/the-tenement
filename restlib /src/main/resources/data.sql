
-- Tabela de autores
INSERT INTO autor (id, nome, nacionalidade) VALUES (123456, 'Machado de Assis', 'Brasileiro');
INSERT INTO autor (id, nome, nacionalidade) VALUES (963852, 'Clarice Lispector', 'Ucraniana');

-- Tabela de livros
INSERT INTO livro (id, titulo, isbn, status, id_autor) VALUES (123456, 'Dom Casmurro', '978-85-01-00001-1', 'DISPONIVEL', 123456);
INSERT INTO livro (id, titulo, isbn, status, id_autor) VALUES (963852, 'A Hora da Estrela', '978-85-01-00002-2', 'DISPONIVEL', 963852);
INSERT INTO livro (id, titulo, isbn, status, id_autor) VALUES (77777777777, 'Memórias Póstumas', '978-85-01-00003-3', 'DISPONIVEL', 123456);

-- Tabela de usuários
INSERT INTO usuario (id, nome, email) VALUES (123456, 'João Silva', 'usuario123456@gmail.com');
INSERT INTO usuario (id, nome, email) VALUES (963852, 'Maria Souza', 'usuario963852@gmail.com');

-- Tabela de empréstimos
INSERT INTO emprestimo (id, data_emprestimo, data_devolucao, id_usuario) VALUES (123456, '2025-08-01', '2025-08-15', 123456);
INSERT INTO emprestimo (id, data_emprestimo, data_devolucao, id_usuario) VALUES (963852, '2025-08-10', '2025-08-20', 963852);

-- Itens do empréstimo (livros emprestados)
INSERT INTO item_emprestimo (emprestimo_id, livro_id) VALUES (123456, 123456);
INSERT INTO item_emprestimo (emprestimo_id, livro_id) VALUES (123456, 963852);
INSERT INTO item_emprestimo (emprestimo_id, livro_id) VALUES (963852, 77777777777);

