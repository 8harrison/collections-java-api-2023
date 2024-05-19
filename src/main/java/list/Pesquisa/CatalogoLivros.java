package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {

    private List<Livro> livroList;

    public CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        if (!livroList.isEmpty()) {
            return livroList
                    .stream()
                    .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                    .toList();
        }
        return new ArrayList<>();
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        if (!livroList.isEmpty()) {
            return livroList
                    .stream()
                    .filter(livro -> livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal)
                    .toList();
        }
        return new ArrayList<>();
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro found = null;
        if (!livroList.isEmpty()) {
            List<Livro> list = livroList
                    .stream()
                    .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                    .toList();
            if (!list.isEmpty()) found = list.get(0);
        }
        return found;
    }

    public static void println(Object object) {
        System.out.println(object);
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
        catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2021);
        catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2022);
        catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2023);
        catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 1994);

        println(catalogoLivros.pesquisarPorAutor("Autor 2"));
        println(catalogoLivros.pesquisarPorIntervaloAnos(2020, 2022));
        println(catalogoLivros.pesquisarPorTitulo("Livro 1"));
    }
}
