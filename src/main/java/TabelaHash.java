public class TabelaHash {

    private static final double FATOR_DE_CARGA_MAXIMO = 0.7;

    private Integer[] tabela;
    private int tamanho;

    public TabelaHash(int capacidadeInicial) {
        this.tabela = new Integer[capacidadeInicial];
        this.tamanho = 0;
    }

    // TODO: implemente a função de hash. Deve mapear `chave` (que pode ser
    // negativa) para um índice válido na tabela.
    // Cuidado: o operador `%` do Java pode devolver um valor negativo
    // quando `chave` é negativa.
    private int hash(int chave) {
        return 0;
    }

    // TODO: insira `chave` na tabela resolvendo colisões por sondagem linear.
    //
    // - Se `chave` já estiver na tabela, não faça nada e retorne false.
    // - Caso contrário, insira `chave` no primeiro slot livre a partir de
    //   hash(chave), percorrendo a tabela circularmente, incremente o
    //   tamanho e retorne true.
    // - Depois de inserir, se o fator de carga (tamanho / capacidade)
    //   ultrapassar FATOR_DE_CARGA_MAXIMO, chame resize() para manter o
    //   custo médio das operações O(1).
    //
    // Não existe operação de remoção nesta tabela, então você não precisa
    // se preocupar com marcas de "removido" (DELETED/tombstone) nem com
    // como elas afetariam a sondagem linear.
    public boolean add(int chave) {
        return false;
    }

    public int size() {
        return tamanho;
    }

    public int capacidade() {
        return tabela.length;
    }

    // Dobra a capacidade da tabela e reposiciona todos os elementos (rehash).
    private void resize() {
        Integer[] tabelaAntiga = tabela;
        tabela = new Integer[tabelaAntiga.length * 2];
        rehash(tabelaAntiga);
    }

    // Reinsere, por sondagem linear, cada chave de `tabelaAntiga` na nova
    // `tabela` (já maior, atribuída em resize()), usando hash(chave).
    private void rehash(Integer[] tabelaAntiga) {
        for (Integer chave : tabelaAntiga) {
            if (chave != null) {
                int indice = hash(chave);
                while (tabela[indice] != null) {
                    indice = (indice + 1) % tabela.length;
                }
                tabela[indice] = chave;
            }
        }
    }

}
