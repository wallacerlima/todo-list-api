package br.com.itau.todolist.domain.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.itau.todolist.domain.model.StatusTarefa;
import br.com.itau.todolist.domain.model.Tarefa;
import br.com.itau.todolist.domain.model.Usuario;
import br.com.itau.todolist.domain.repository.TarefaRepository;

@ExtendWith(SpringExtension.class)
public class CadastroTarefaServiceTest {

	@InjectMocks
	private CadastroTarefaService cadastroTarefaService;
	
	@Mock
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Mock
	private TarefaRepository tarefaRepository;
	
	@Test
	public void deveCadastrarUmaTarefa() {
		
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setNome("Usuário Teste");
		usuario.setEmail("teste@teste.com.br");
		
		Tarefa tarefa = new Tarefa();
		tarefa.setUsuario(new Usuario());
		tarefa.getUsuario().setId(1L);
		tarefa.setResumo("Tarefa teste");
		tarefa.setDescricao("Tarefa teste descrição");
		tarefa.setStatus(StatusTarefa.PENDENTE);
		
		when(cadastroUsuarioService.buscarOuFalhar(usuario.getId())).thenReturn(usuario);
		
		cadastroTarefaService.salvar(tarefa);
		
		verify(tarefaRepository).save(tarefa);
		
	}
}
