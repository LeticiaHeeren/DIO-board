# Desafio Dio - Board - Gerenciador de Tarefas
O Dio-Board é um sistema de gerenciamento de tarefas (Kanban) desenvolvido em Java, com funcionalidades para criar, mover, bloquear e cancelar cards em um board.

# Novas Funcionalidades Adicionadas
**1. Histórico de Movimentação de Cards**
**O que foi adicionado:**

Agora é possível rastrear todas as movimentações de cards entre colunas.

**O histórico inclui:**

- Coluna de origem.

- Coluna de destino.

- Data e hora da movimentação.

- Acessível através da opção 9 - Ver histórico de movimentos no menu do board.</br></br>

# Como funciona:

Sempre que um card é movido ou cancelado, uma entrada é automaticamente registrada no histórico.

O histórico pode ser consultado para qualquer card, mostrando todas as suas movimentações em ordem cronológica.</br></br>

**2. Novas Classes para Suporte ao Histórico**
**O que foi adicionado:**

- **CardHistoryDTO:** Representa os dados de histórico para exibição no sistema.

- **CardHistoryEntity:** Mapeia a tabela card_history no banco de dados.

- **CardHistoryDAO:** Responsável por operações de banco de dados relacionadas ao histórico.
