package br.com.itau.todolist.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	private static final String MSG_USUARIO_NAO_ENCONTRADO = "Não existe usuário com o código %d";
	
	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioNaoEncontradoException(Long usuarioId) {
		this(String.format(MSG_USUARIO_NAO_ENCONTRADO, usuarioId));
	}
}
