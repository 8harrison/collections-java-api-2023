package main.java.map.Ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static main.java.list.OperacoesBasicas.ListaTarefa.println;

public class AgendaEventos {
  private Map<LocalDate, Evento> eventosMap;

  public AgendaEventos() {
    this.eventosMap = new HashMap<>();
  }

  public void adicionarEvento(LocalDate data, String nomeEvento, String descricaoAtracao) {
    eventosMap.put(data, new Evento(nomeEvento, descricaoAtracao));
  }

  public void exibirAgenda() {
    Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
    println(eventosTreeMap);
  }

  public void obterProximoEvento() {
    LocalDate dataAtual = LocalDate.now();
    Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
    for (Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
      if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
        println("O próximo evento " + entry.getValue() + " acontecerá na data " + entry.getKey());
        break;
      }
    }
  }

  public static void main(String[] args) {
    AgendaEventos agendaEventos = new AgendaEventos();

    // Adiciona eventos à agenda
    agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
    agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
    agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
    agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
    agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");
    agendaEventos.adicionarEvento(LocalDate.of(2024, 5, 19), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");

    // Exibe a agenda completa de eventos
    agendaEventos.exibirAgenda();

    // Obtém e exibe o próximo evento na agenda
    agendaEventos.obterProximoEvento();
  }
}