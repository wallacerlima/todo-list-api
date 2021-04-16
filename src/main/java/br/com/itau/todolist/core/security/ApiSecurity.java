package br.com.itau.todolist.core.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.itau.todolist.domain.model.Tarefa;
import br.com.itau.todolist.domain.model.Usuario;
import br.com.itau.todolist.domain.repository.UsuarioRepository;
import br.com.itau.todolist.domain.service.CadastroTarefaService;

@Component
public class ApiSecurity {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CadastroTarefaService cadastroTarefaService;
	
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	public boolean isAutenticado() {
		return getAuthentication().isAuthenticated();
	}
	
	public Long getUsuarioId() {
		Optional<Usuario> usuario = 
				usuarioRepository.findByEmail(getAuthentication().getPrincipal().toString());
		
		return usuario.get().getId();
	}
	
	public boolean usuarioAutenticadoIgual(Long usuarioId) {
		return getUsuarioId() != null && usuarioId != null && getUsuarioId().equals(usuarioId);
	}
	
	public boolean podeGerenciarTarefa(Long tarefaId) {
		Tarefa tarefa = cadastroTarefaService.buscarOuFalhar(tarefaId);
		return getUsuarioId() != null && tarefaId != null && getUsuarioId().equals(tarefa.getUsuario().getId());
	}
	
}
