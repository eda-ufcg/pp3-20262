# Identificação

* Nome: 
* Email (@ccc): 
* Matrícula: 


## O template

> O código Java fica no diretório **`src/main/java/`**.

### Compilando

Execute os comandos a partir da raiz do repositório:

```bash
javac src/main/java/*.java
```

### Executando os testes públicos

Depois de compilar, execute:

```bash
java -ea -cp src/main/java AssertsFIFOCache
```

> A opção `-ea` habilita os `asserts` usados nos testes.


## A Prova

### FIFO Cache (5,0)

Implemente um cache com política FIFO (*first in, first out*): quando o cache atinge sua capacidade máxima e uma nova chave é inserida, 
a chave mais antiga é removida para abrir espaço.

Todas as operações devem ter custo **O(1)**. Para isso, você deve implementar:

- **`Fila`** — uma fila circular com capacidade fixa, responsável por manter a ordem de inserção das chaves. O método `addLast` insere no final; se a fila estiver cheia, o elemento mais antigo (`getFirst`) é sobrescrito. Você pode adicionar outros métodos auxiliares conforme necessário.

- **`FIFOCache`** — o cache em si. O método `get(chave)` retorna `"hit"` se a chave está presente no cache, ou `"miss"` caso contrário (e então a insere, removendo a mais antiga se estiver cheio). `getNextEviction()` retorna a chave que será despejada na próxima inserção (ou `null` se o cache ainda não estiver cheio). `size()` retorna a quantidade atual de elementos.

Você **pode** usar as classes `HashMap`, `HashSet` e outras do `java.util`, desde que mantenha a complexidade O(1). Consulte os asserts em `AssertsFIFOCache.java` para entender o comportamento esperado em detalhes.

# Entregando a prova

> ⚠️ **Importante:** Todos os comandos abaixo devem ser executados no **diretório pai** do projeto, ou seja, no **diretório anterior** ao diretório `pp3-20262/`. 

---

## Passo 1: Gerar o arquivo compactado da sua solução

Execute o comando abaixo **no diretório anterior** ao diretório `pp3-20262/`:

```bash
tar zcvf nome-sobrenome-matricula.tar.gz pp3-20262/
```
---

## Passo 2: Submeter sua solução

Execute o comando abaixo **no mesmo diretório do Passo 1**:

```bash
bash pp3-20262/submit-answer.sh prova3 nome-sobrenome-matricula.tar.gz
```

Importante: a senha é `leda`

## Importante

* A correção da prova não é automática. Os testes que são executados quando você roda localmente são apenas testes de sanidade.

* Vou considerar sempre a última submissão antes do deadline final. 

* A nota será dada pelos testes no servidor e depois da correção que eu efetuar. Sempre tento corrigir o mais rápido possível. Portanto, tenha paciência.

* A nota será calculada a partir dos testes e análise manual do código. Essa análise manual vai considerar se a solução é eficiente, se não tem loops desnecessários etc.

* Só serão corrigidas as provas dos alunos que assinaram a lista de presença física no laboratório.
