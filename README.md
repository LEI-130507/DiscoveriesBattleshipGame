# Discoveries Battleship Game

Projeto desenvolvido no âmbito da unidade curricular de **Engenharia de Software** (2026/2027) no Iscte - Instituto Universitário de Lisboa.

---

## 👥 Equipa: *[LEI-PL-03]*

| Curso | Número | Nome | GitHub |
| :--- | :---: | :--- | :--- |
| LEI | 130507 | João Valério | [@LEI-130507](https://github.com/LEI-130507) |
| LEI | *[Número]* | *[Nome do Colega 1]* | [@LEI-XXXXX](https://github.com/LEI-XXXXX) |

---

## 📜 Regras do Jogo

O **Discoveries Battleship Game** é uma variante da clássica Batalha Naval adaptada à época dos Descobrimentos Portugueses. O confronto desenrola-se por turnos entre dois jogadores num ambiente tático marítimo.

### 1. Tabuleiros e Posicionamento da Frota
* Cada jogador dispõe de **duas grelhas de 10×10 quadrados** (linhas de 0 a 9 e colunas de 0 a 9):
  * **O seu mar:** onde posiciona a sua frota e acompanha os ataques do oponente.
  * **O mar do adversário:** onde regista os seus disparos e mapeia as embarcações inimigas descobertas.
* Os navios devem ser dispostos obrigatoriamente na **horizontal** ou na **vertical** (nunca na diagonal).
* **Restrição de Adjacência:** Nenhum navio pode tocar noutro navio em qualquer direção (incluindo diagonais), tendo de existir pelo menos um quadrado de água entre eles. Podem, contudo, estar encostados aos limites exteriores da grelha.
* As frotas de ambos os jogadores são posicionadas em segredo no início da partida.

---

### 2. Composição da Frota (Época dos Descobrimentos)
Cada jogador comanda uma esquadra idêntica composta por **11 embarcações** (totalizando 27 quadrículas):

| Navio | English Name | Dimensão (Quadrículas) | Quantidade |
| :--- | :--- | :---: | :---: |
| **Galeão** | Galleon | 5 | 1 |
| **Fragata** | Frigate | 4 | 1 |
| **Nau** | Carrack | 3 | 2 |
| **Caravela** | Caravel | 2 | 3 |
| **Barca** | Barge | 1 | 4 |

---

### 3. Dinâmica dos Turnos e Disparos
* O jogo desenrola-se por turnos alternados entre os dois jogadores.
* **Rajada de Três Tiros:** Em cada turno, o jogador ativo dispara obrigatoriamente uma salva de **3 tiros**, indicando as coordenadas exatas `(linha, coluna)` de cada disparo na grelha do adversário.
* **Comunicação do Resultado:** O jogador atacado avalia o impacto da rajada e comunica os resultados ao atacante, especificando:
  * Quantos tiros atingiram **água**.
  * Quantos tiros **acertaram** em embarcações e **qual o tipo de navio** atingido (ex.: *"um tiro na Nau e dois tiros na água"*).
  * Se algum navio foi completamente destruído (**afundado**).
* **Registo Tático:** Cada jogador anota os dados na sua grelha do oponente para deduzir a posição restante da frota adversária.

---

### 4. Condição de Vitória
* O jogo termina de imediato assim que um jogador conseguir localizar e afundar a totalidade dos **11 navios** da frota inimiga.
* O primeiro jogador a afundar todos os navios do oponente é declarado o **Vencedor**.
