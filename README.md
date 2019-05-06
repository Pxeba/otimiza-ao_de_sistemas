# Trabalho de Otimização

## Para executar:

### Backend
Comandos dentro do diretório *backend*:

- set CLASSPATH=glpk-java.jar;
- javac Modelo.java
- java Modelo

### Frontend
Abrir index.html com navegador. Ou, se preferir :<br>
https://glpk.000webhostapp.com/

As entradas precisam ser digitadas manualmente, é aceito qualquer problema linear<br>
com solução. Apenas no primeiro passo, definição de objetivo, não é possível adicionar linhas

### Mathprog
É necessário ter o path glpsol previamente endereçado, após:<br>
glpsol -m modelo.mod -o modelo.sol
