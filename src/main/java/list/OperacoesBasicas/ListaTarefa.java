package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
  //atributo
  private List<Tarefa> tarefaList;

  public ListaTarefa() {
    this.tarefaList = new ArrayList<>();
  }

  public void adicionarTarefa(String descricao){
    tarefaList.add(new Tarefa(descricao));
  }

  public void removerTarefa(String descricao){
      tarefaList.removeIf(t -> t.getDescricao().equalsIgnoreCase(descricao));
  }

  public int obterNumeroTotalTarefas(){
    return tarefaList.size();
  }

  public void obterDescricoesTarefas(){
    println(tarefaList);
  }

  public static void println(Object object){
    System.out.println(object);
  }

  public static void main(String[] args) {
    ListaTarefa listaTarefa = new ListaTarefa();
    println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());
    listaTarefa.adicionarTarefa("Tarefa 1");
    listaTarefa.adicionarTarefa("Tarefa 1");
    listaTarefa.adicionarTarefa("Tarefa 2");
    listaTarefa.obterDescricoesTarefas();
    println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());
    listaTarefa.removerTarefa("Tarefa 1");
    println("O número total de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());
    listaTarefa.obterDescricoesTarefas();
  }
}
