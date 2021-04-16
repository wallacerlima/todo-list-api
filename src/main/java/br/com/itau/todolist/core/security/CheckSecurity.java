package br.com.itau.todolist.core.security;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

public @interface CheckSecurity {
	
	public @interface Tarefas {
		
		@PreAuthorize("(hasAuthority('ROLE_PESQUISAR_TAREFA') and @apiSecurity.usuarioAutenticadoIgual(#filtro.usuarioId)) "
						+ "or hasAuthority('ROLE_ADMINISTRADOR')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeListar { }

		@PreAuthorize("hasAuthority('ROLE_PESQUISAR_TAREFA') or hasAuthority('ROLE_ADMINISTRADOR')")
		@PostAuthorize("@apiSecurity.usuarioAutenticadoIgual(returnObject.usuario.id) or hasAuthority('ROLE_ADMINISTRADOR')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeBuscar { }
		
		@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TAREFA')")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeCadastrar { }
		
		@PreAuthorize("hasAuthority('ROLE_REMOVER_TAREFA') and @apiSecurity.podeGerenciarTarefa(#tarefaId)")
		@Retention(RUNTIME)
		@Target(METHOD)
		public @interface PodeGerenciar { }
	}
	
}
