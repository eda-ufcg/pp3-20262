public class AssertsTabelaHash {

    public static void main(String[] args) {
        testaTabelaVazia();
        testaInsercaoEDuplicata();
        testaResizeAoExcederFatorDeCarga();
        testaSemPerdaDeDadosAposResize();
        testaFatorDeCargaNuncaExcedido();
        testaCapacidadeInicialUm();
        testaChavesNegativas();
    }

    // Estado inicial: tabela vazia, com a capacidade passada no construtor
    static void testaTabelaVazia() {
        System.out.print("testaTabelaVazia... ");
        TabelaHash t = new TabelaHash(4);
        assert t.size() == 0;
        assert t.capacidade() == 4;
        System.out.println("OK");
    }

    // Inserção simples e tentativa de inserir a mesma chave de novo
    static void testaInsercaoEDuplicata() {
        System.out.print("testaInsercaoEDuplicata... ");
        TabelaHash t = new TabelaHash(4);
        assert t.add(10) == true;
        assert t.size() == 1;
        assert t.add(20) == true;
        assert t.size() == 2;
        assert t.add(10) == false; // já existe, não insere de novo
        assert t.size() == 2;
        System.out.println("OK");
    }

    // resize() deve ser disparado (dobrando a capacidade) quando o fator de
    // carga ultrapassar 0.7
    static void testaResizeAoExcederFatorDeCarga() {
        System.out.print("testaResizeAoExcederFatorDeCarga... ");
        TabelaHash t = new TabelaHash(4);
        t.add(1); // 1/4 = 0.25
        t.add(2); // 2/4 = 0.50
        assert t.capacidade() == 4;
        t.add(3); // 3/4 = 0.75 > 0.7 -> deve disparar resize (dobra para 8)
        assert t.capacidade() == 8;
        System.out.println("OK");
    }

    // Depois de várias inserções e vários resizes, nenhuma chave antiga pode
    // ter sido perdida: readicioná-las deve retornar false (já presentes)
    static void testaSemPerdaDeDadosAposResize() {
        System.out.print("testaSemPerdaDeDadosAposResize... ");
        TabelaHash t = new TabelaHash(4);
        int[] chaves = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int chave : chaves) {
            assert t.add(chave) == true;
        }
        assert t.size() == chaves.length;

        for (int chave : chaves) {
            assert t.add(chave) == false; // já está na tabela, mesmo após os resizes
        }
        assert t.size() == chaves.length;
        System.out.println("OK");
    }

    // A qualquer momento, o fator de carga (size/capacidade) não pode
    // ultrapassar 0.7, mesmo com muitas inserções seguidas
    static void testaFatorDeCargaNuncaExcedido() {
        System.out.print("testaFatorDeCargaNuncaExcedido... ");
        TabelaHash t = new TabelaHash(4);
        for (int i = 0; i < 50; i++) {
            t.add(i);
            double fatorDeCarga = t.size() / (double) t.capacidade();
            assert fatorDeCarga <= 0.7 + 1e-9;
        }
        assert t.size() == 50;
        System.out.println("OK");
    }

    // Caso extremo: tabela criada com capacidade 1 já precisa de resize na
    // primeira inserção para manter o fator de carga <= 0.7
    static void testaCapacidadeInicialUm() {
        System.out.print("testaCapacidadeInicialUm... ");
        TabelaHash t = new TabelaHash(1);
        assert t.capacidade() == 1;
        assert t.add(42) == true;
        assert t.capacidade() == 2;
        assert t.add(42) == false;
        assert t.size() == 1;
        System.out.println("OK");
    }

    // A função de hash precisa mapear chaves negativas para índices válidos
    // (>= 0); usar `%` sem corrigir o sinal normalmente causa
    // ArrayIndexOutOfBoundsException aqui.
    static void testaChavesNegativas() {
        System.out.print("testaChavesNegativas... ");
        TabelaHash t = new TabelaHash(4);
        assert t.add(-1) == true;
        assert t.add(-2) == true;
        assert t.add(-10) == true;
        assert t.size() == 3;
        assert t.add(-1) == false; // duplicata negativa
        assert t.size() == 3;
        System.out.println("OK");
    }

}
