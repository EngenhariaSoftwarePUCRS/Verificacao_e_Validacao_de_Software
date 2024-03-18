## Exemplo 1

O valor dos ingressos de um cinema varia conforme a quantidade de ingressos adquiridos em conjunto. O valor normal do ingresso é de R$ 15,00. Compras até 5 (inclusive) ingressos pagam o preço normal, compras entre 6 e 10 (inclusive) ingressos tem 10% de desconto e compras de mais de 10 ingressos tem 15% de desconto

### Partições

Q1: Ingressos <= 5
Q2: 6 <= Ingressos <= 10
Q3: Ingressos > 10

| Partição | Entrada | Saída Esperada |
| --- | --- | --- |
| Ingressos <= 5 | 3 | 45,00 |
| 6 <= Ingressos <= 10 | 7 | 94,50 |
| Ingressos > 10 | 12 | 153,00 |

## Exemplo 2

O valor dos ingressos de um cinema varia conforme a quantidade de ingressos adquiridos em conjunto e conforme o dia da semana. O valor normal do ingresso é de R$ 15,00. Compras até 5 (inclusive) ingressos pagam o preço normal, compras entre 6 e 10 (inclusive) ingressos tem 10% de desconto e compras de mais de 10 ingressos tem 15% de desconto. Esses valores valem de segunda a sexta. Nos sábados e domingos o valor do ingresso é de R$ 20,00.

### Partições

Q1: Ingressos <= 5
Q2: 6 <= Ingressos <= 10
Q3: Ingressos > 10

D1: Segunda a Sexta
D2: Sábado e Domingo

| Quantidade x Dia da Semana | Entrada | Saída Esperada |
| --- | --- | --- |
| Q1 x D1 | 3, Terça | 45,00 |
| Q1 x D2 | 4, Sábado | 80,00 |
| Q2 x D1 | 7, Quarta | 94,50 |
| Q2 x D2 | 8, Domingo | 144,00 |
| Q3 x D1 | 12, Quinta | 153,00 |
| Q3 x D2 | 13, Domingo | 221,00 |

## Exemplo 3

A tarifa de energia em uma determinada região tem um custo básico de R$ 5,00 por MW (Megawatt).
Se o sistema estiver operando em bandeira verde não tem acréscimo, em bandeira amarela o acréscimo é de 2,5% na bandeira vermelha o acréscimo é de 5%.
Se o consumo ultrapassar 20 MW, o valor do excedente tem um adicional de 15% depois de calculado o valor com as bandeiras.
Se a residência se enquadrar no programa de tarifa social então terá 50% de desconto no valor final.

### Partições

B1: Bandeira Verde (0%)
B2: Bandeira Amarela (2,5%)
B3: Bandeira Vermelha (5%)

C1: Consumo <= 20 (0% adicional)
C2: Consumo > 20 (15% adicional)
C3: Consumo Inválido

T1: Tarifa Normal (0% desconto)
T2: Tarifa Social (50% de desconto)

| Consumo x Bandeira x Tarifa | Entrada | Saída Esperada |
| --- | --- | --- |
| C1 x B1 x T1 | 10, B1, T1 | 50,00 |
| C1 x B2 x T1 | 15, B2, T1 | 77,50 |
| C1 x B3 x T1 | 20, B3, T1 | 105,00 |
| C2 x B1 x T1 | 25, B1, T1 | 125,00 |
| C2 x B2 x T1 | 30, B2, T1 | 172,50 |
| C2 x B3 x T1 | 35, B3, T1 | 220,00 |
| C1 x B1 x T2 | 10, B1, T2 | 25,00 |
| C1 x B2 x T2 | 15, B2, T2 | 38,75 |
| C1 x B3 x T2 | 20, B3, T2 | 52,50 |
| C2 x B1 x T2 | 25, B1, T2 | 62,50 |
| C2 x B2 x T2 | 30, B2, T2 | 86,25 |
| C2 x B3 x T2 | 35, B3, T2 | 110,00 |
| C3 x B1 x T1 | -10, B1, T1 | Erro |

## Exemplo 4

Uma loja possui diversos tamanhos de embalagem para armazenar barras de chocolate. O estoque da loja contém barras de 1 Kg e de 5Kg. Quando o cliente escolhe o tamanho da embalagem, deve-se usar a maior quantidade possível de barras de 5Kg e completar o peso desejado com barras de 1kg.
As entradas do programa são a quantidade de barras de 1Kg e 5Kg disponíveis e o tamanho (capacidade em Kgs) da embalagem.
O resultado é a quantidade de barras de 1Kg e 5Kg que devem ser usadas para completar a embalagem. Deve retornar –1 se não houver no estoque barras suficientes.

### Partições

C1: Apenas barras de 1Kg
C2: Apenas barras de 5Kg
C3: Barras de 1Kg e 5Kg
C4: Capacidade Insuficiente
C5: Embalagem Inválida

Entrada = (Barras 1Kg, Barras 5Kg, Peso Embalagem)

| Teste | Entrada | Saída Esperada |
| --- | --- | --- |
| C1 | 4, 2, 3 | 3, 0 |
| C2 | 5, 3, 10 | 0, 2 |
| C3 | 5, 3, 17 | 2, 3 |
| C4 | 1, 1, 10 | -1 |
| C5 | 4, 2, -1 | -1 |
