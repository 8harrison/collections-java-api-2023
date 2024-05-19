package main.java.set.Pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {

    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContatos(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }

    public static void println(Object object){
        System.out.println(object);
    }

    public void exibirContatos(){
        println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for (Contato c : contatoSet){
            if (c.getNome().startsWith(nome)){
                contatosPorNome.add(c);
            }
        }
        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;
        for (Contato c : contatoSet){
            if (c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContatos("Camila", 123456);
        agendaContatos.adicionarContatos("Camila", 0);
        agendaContatos.adicionarContatos("Camila Cavalcante", 111111);
        agendaContatos.adicionarContatos("Camila DIO", 654987);
        agendaContatos.adicionarContatos("Maria Silva", 111111);

        agendaContatos.exibirContatos();
        println(agendaContatos.pesquisarPorNome("Camila"));
        println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Maria Silva", 55555));
        agendaContatos.exibirContatos();
    }
}
