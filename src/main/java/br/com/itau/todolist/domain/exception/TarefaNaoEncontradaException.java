package br.com.itau.todolist.domain.exception;

public class TarefaNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	private static final String MSG_TAREFA_NAO_ENCONTRADA = "Não existe tarefa com o código %d";
	
	public TarefaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public TarefaNaoEncontradaException(Long tarefaId) {
		this(String.format(MSG_TAREFA_NAO_ENCONTRADA, tarefaId));
	}
}
