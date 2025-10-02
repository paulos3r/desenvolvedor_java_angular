-- Garante que o script pare se houver um erro de tipo ENUM (caso você não tenha rodado a DDL)
SET client_min_messages TO WARNING;

-- Script de INSERT com 30 Tarefas Variadas
INSERT INTO tarefa (nome, descricao, prioridade, situacao, data_prevista_conclusao, data_criacao) VALUES
-- 10 Tarefas de ALTA Prioridade
('Revisar Código do Módulo X', 'Tarefa crítica de desenvolvimento.', 'ALTA', 'PENDENTE', '2025-10-15', '2025-10-02 00:00:00'),
('Configurar Servidor de Produção', 'Instalação e testes de ambiente.', 'ALTA', 'ABERTA', '2025-10-10', '2025-10-02 00:05:00'),
('Bug Fix: Login Intermitente', 'Corrigir falha reportada pelos usuários.', 'ALTA', 'PENDENTE', '2025-10-05', '2025-10-02 00:10:00'),
('Planejar Sprint 3', 'Definir escopo e prioridades da próxima iteração.', 'ALTA', 'ABERTA', '2025-10-25', '2025-10-02 00:15:00'),
('Documentação de API (v2)', 'Atualizar documentação técnica no Swagger.', 'ALTA', 'CONCLUIDA', '2025-09-20', '2025-10-02 00:20:00'), -- Passada e Concluída
('Teste de Performance', 'Simular 1000 usuários simultâneos.', 'ALTA', 'PENDENTE', '2025-11-01', '2025-10-02 00:25:00'),
('Deploy da Versão Beta', 'Preparar e executar a migração.', 'ALTA', 'ABERTA', '2025-10-30', '2025-10-02 00:30:00'),
('Treinamento para Equipe', 'Sessão sobre novas tecnologias.', 'ALTA', 'PENDENTE', '2025-11-15', '2025-10-02 00:35:00'),
('Análise de Logs', 'Investigar lentidão no banco de dados.', 'ALTA', 'CONCLUIDA', '2025-10-01', '2025-10-02 00:40:00'), -- Concluída
('Modelagem do Banco de Dados', 'Finalizar o design da tabela de usuários.', 'ALTA', 'ABERTA', '2025-10-20', '2025-10-02 00:45:00'),

-- 10 Tarefas de MÉDIA Prioridade
('Reunião Semanal de Status', 'Agenda: Andamento do projeto e bloqueios.', 'MEDIA', 'ABERTA', '2025-10-07', '2025-10-02 00:50:00'),
('Criar Mockups para App Móvel', 'Design UI/UX da tela de listagem.', 'MEDIA', 'PENDENTE', '2025-11-05', '2025-10-02 00:55:00'),
('Integrar Notificações via Email', 'Configurar serviço de envio de email.', 'MEDIA', 'ABERTA', '2025-11-20', '2025-10-02 01:00:00'),
('Limpeza de Código (Refatoração)', 'Remover código obsoleto e refatorar classes antigas.', 'MEDIA', 'PENDENTE', '2025-12-01', '2025-10-02 01:05:00'),
('Pesquisa de Mercado', 'Analisar concorrentes na área de To-Do.', 'MEDIA', 'CONCLUIDA', '2025-09-10', '2025-10-02 01:10:00'),
('Atualizar Dependências Angular', 'Rodar `npm update` e testar quebras.', 'MEDIA', 'PENDENTE', '2025-10-28', '2025-10-02 01:15:00'),
('Escrever Testes Unitários CRUD', 'Garantir cobertura básica de testes.', 'MEDIA', 'ABERTA', '2025-11-10', '2025-10-02 01:20:00'),
('Configurar CI/CD', 'Automatizar deploy para ambiente de staging.', 'MEDIA', 'CONCLUIDA', '2025-09-25', '2025-10-02 01:25:00'),
('Implementar Cache Redis', 'Melhorar a velocidade de leitura de dados.', 'MEDIA', 'PENDENTE', '2025-12-15', '2025-10-02 01:30:00'),
('Design do Logo do Projeto', 'Criar três opções de logotipo.', 'MEDIA', 'ABERTA', '2025-11-30', '2025-10-02 01:35:00'),

-- 10 Tarefas de BAIXA Prioridade
('Comprar Café para Escritório', 'Estoque baixo.', 'BAIXA', 'ABERTA', '2025-10-03', '2025-10-02 01:40:00'),
('Organizar Pasta de Documentos', 'Arquivar relatórios antigos.', 'BAIXA', 'PENDENTE', '2026-01-01', '2025-10-02 01:45:00'),
('Responder Email Genérico', 'Resposta padrão a um inquérito de vendas.', 'BAIXA', 'ABERTA', '2025-12-31', '2025-10-02 01:50:00'),
('Atualizar Perfil do LinkedIn', 'Adicionar novas habilidades.', 'BAIXA', 'CONCLUIDA', '2025-09-01', '2025-10-02 01:55:00'),
('Lembrar de Regar as Plantas', 'Avisar a equipe sobre as plantas da sala de reuniões.', 'BAIXA', 'PENDENTE', '2025-10-04', '2025-10-02 02:00:00'),
('Fazer Backup Local', 'Cópia de segurança dos arquivos da máquina.', 'BAIXA', 'ABERTA', '2026-02-15', '2025-10-02 02:05:00'),
('Pesquisar Férias 2026', 'Definir datas para o recesso.', 'BAIXA', 'PENDENTE', '2026-03-01', '2025-10-02 02:10:00'),
('Ler Artigo sobre Java 21', 'Aprender sobre as últimas features.', 'BAIXA', 'CONCLUIDA', '2025-08-15', '2025-10-02 02:15:00'),
('TAREFA TESTE (Busca)', 'Usada para verificar o filtro por nome.', 'BAIXA', 'ABERTA', '2026-12-20', '2025-10-02 02:20:00'),
('TAREFA TESTE 2 (Busca)', 'Outra tarefa para busca textual.', 'BAIXA', 'PENDENTE', '2026-11-20', '2025-10-02 02:25:00');