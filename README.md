# Desafio DIO Projeto Sudoku

Dois projetos em Java que simulam o jogo Sudoku, as informações da tabela Sudoku podem ser inseridas como 
args no formato `linha,coluna;valor,visibilidade` contendo 81 args. Caso a quantidade de args seja diferente 
de 81 ou o formato não esteja de acordo com o exigido será gerado um jogo aleatório, respeitando as regras do Sudoku.

|  | Descrição |
|---|---|
| Linha | `número inteiro de 0 a 8` |
| Coluna | `número inteiro de 0 a 8` |
| Valor | `número inteiro de 1 a 9` |
| Visibilidade | `true` para o valor padrão (gerado pelos args ou <br>aleatóriamente pelo programa) ser visível na tabela <br>para ficar como dica para o jogador e `false` <br>para o valor padrão não ficar visível|

## Sudoku no Terminal
Permite jogar Sudoku por meio do terminal, onde é exibido um Menu que permite o usuário iniciar um novo jogo, 
inserir um número na tabela, remover um número, visualizar o jogo atual, verificar o status do jogo, limpar o 
jogo, finalizar o jogo e sair do menu, encerrando a aplicação.


## Sudoku com Interface
Permite jogar Sudoku por meio de uma interface, permitindo o usuário inserir um valor no campo selecionado da 
tabela e também apagar esse valor, além de exibir botões, um botão para resetar o jogo - removendo todos os valores inseridos 
pelo jogador, um botão para visualizar a situação atual do jogo - verifica se o jogo está completo ou não e se há algum valor 
incorreto inserido, um botão para finalizar o jogo - se o jogo estiver completo exibe uma mensagem de parabéns e desabilita 
todos os botões, e por fim um botão de X para fechar a interface.
