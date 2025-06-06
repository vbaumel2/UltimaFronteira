# Ultima Fronteira

Ultima Fronteira é um jogo de sobrevivência desenvolvido em Java, utilizando JavaFX para a interface gráfica. O objetivo do jogo é explorar ambientes, gerenciar recursos, enfrentar eventos e sobreviver em um mundo hostil.

## Funcionalidades Principais
- Interface gráfica interativa com JavaFX
- Exploração de diferentes ambientes (floresta, deserto, lago, montanha, caverna, ruínas, refúgio, etc.)
- Sistema de inventário e crafting (criação de itens a partir de recursos encontrados)
- Eventos dinâmicos (climáticos, criaturas, doenças, descobertas, etc.)
- Gerenciamento de jogador (status, saúde, fome, sede, etc.)
- Sistema de mapa com diferentes ambientes e desafios
- Sistema básico de combate
- Itens variados: armas, ferramentas, alimentos, remédios, recursos, etc.
- Interface modular e expansível

## Estrutura do Projeto
- `src/main/java/jogo/ClassesDoJogo/`: Lógica principal do jogo (Jogador, Inventário, Mapa, Crafter, ambientes, eventos, itens)
- `src/main/java/jogo/ClassesDaInterface/`: Componentes da interface gráfica (gerenciamento de inventário, crafting, mapa, janela principal)
- `src/main/java/jogo/builders/`: Builders para eventos e itens, facilitando a criação e expansão de novos conteúdos
- `src/main/resources/jogo/MainWindow.fxml`: Layout da janela principal do jogo
- `pom.xml`: Gerenciamento de dependências e build com Maven

## Como Funciona o Jogo
O jogador inicia em um ambiente aleatório e deve explorar o mapa, coletar recursos, fabricar itens, enfrentar eventos inesperados e sobreviver o maior tempo possível. Cada ambiente possui características e desafios próprios. O sistema de eventos traz imprevisibilidade, exigindo estratégia e adaptação.

### Ambientes
- Floresta
- Deserto
- Lago
- Montanha
- Caverna
- Ruínas
- Refúgio

### Tipos de Eventos
- Climáticos (tempestades, calor extremo, frio, etc.)
- Criaturas (ataques, encontros, etc.)
- Doenças e ferimentos
- Descobertas e explorações

### Itens
- Armas (para defesa)
- Ferramentas (para crafting e exploração)
- Alimentos e bebidas (para manter saúde)
- Remédios e antídotos
- Materiais e recursos

## Requisitos
- Java 17 ou superior
- Maven

