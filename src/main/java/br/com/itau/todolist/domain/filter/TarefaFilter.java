package br.com.itau.todolist.domain.filter;

import br.com.itau.todolist.domain.model.StatusTarefa;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TarefaFilter {
	
	private Long usuarioId;
	private StatusTarefa status;
}
