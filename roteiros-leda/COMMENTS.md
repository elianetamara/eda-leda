## 💡 Roteiros

Roteiro | Assunto | Total testes | Passou | Erros | Falhas | Comentário
:--: | :--: | :--: | :--: | :--: | :--: | :--:
R01  | Ordenação por comparação (BubbleSort, SelectionSort, InsertionSort) | 168 | 146 | 0 | 22 | Implementação Boa! 1. Pequenos problemas de implementação no InsertionSort, BubbleSort e BidirectionalBubbleSort.
R02  | Ordenação por comparação (MergeSort, QuickSort) | 112 | 92 | 2 | 18 | somou APPLICATIONS dentro de mergeSort e insertionSort; errou algumas verificações em HybridMergeSort ocasionando outOfBounds.
R03  | Selection sort (prova de reposição anterior) | 10 | 2 | 0 | 8 | Metodo findIndexFirstOrder representa o calculo do menor do array, e nao deveria ter parametro smallest porque obrigatoriamente iria varrer array todo. Metodo isKOrderEst compara elementos de tres indices (muito confuso e sem muito propósito). Metodo findIndexOrder nao deveria dereber leftIndex como parametro porque ele tem que procurar por todo o array (que nao pode ser modificado). o for do metodo getOrderStatistics poderia ser de 2 em diante porque a primeira estatistica de odem já é calculada antes do for.
R04  | Ordenação em tempo linear (CountingSort) | 54 | 54 | 0 | 0 | Sem comentários
R05  | Cálculo de estatística de ordem e floor (BinarySearch, QuickSelect) | 40 | 28 | 7 | 5 | Implementação confusa e errada do floor e quick com o uso de muitos return em um mesmo método.
R06  | Busca binária (prova de reposição anterior) | 8 | 8 | 0 | 0 | metodos nao precisavam ser estáticos. Metodo potencia só precisava de dois parametros. A condicao (resultPotencia == numero) nao precisava. Era so verificar se tava dentro da margem de erro.
R07  | Tipos abstratos de dados (Stack, Queue)  | 40 | 35 | 3 | 2 | Classe CircularQueue: No dequeue faltou decrementar os elements quando (head == tail). Classe QueueImpl o shiftLeft deveria ir até o i < tail.
R08  | Lista encadeada (LinkedList)  | 50 | 50 | 0 | 0 | Excelente implementação . Parabéns :)
R09  | Uso de lista encadeada (prova anterior)  | 12 | 12 | 0 | 0 | A condicao !nodeAux.getNext().isNIL() nao deveria fazer parte do while mais interno. E o nodeAux deveria ter começado com node.next.
R10  | Tabelas Hash | 24 | 24 | 0 | 0 |  Uso desnecessário de break, má prática quanto ao uso abusivo.
R11  | Árvore Binária da Busca | 47 | 45 | 0 | 2 |  
R12  | Heap binária | 54 | 54 | 0 | 0 |  
