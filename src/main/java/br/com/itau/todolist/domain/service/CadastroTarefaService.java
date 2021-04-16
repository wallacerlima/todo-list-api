package br.com.itau.todolist.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.itau.todolist.domain.exception.TarefaNaoEncontradaException;
import br.com.itau.todolist.domain.model.Tarefa;
import br.com.itau.todolist.domain.model.Usuario;
import br.com.itau.todolist.domain.repository.TarefaRepository;

@Service
public class CadastroTarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;

	public Tarefa salvar(Tarefa tarefa) {
		
		Long usuarioId = tarefa.getUsuario().getId();
		
		Usuario usuario = cadastroUsuarioService.buscarOuFalhar(usuarioId);
		
		tarefa.setUsuario(usuario);
		return tarefaRepository.save(tarefa);
	}

	public void excluir(Long tarefaId) {
		try {
			tarefaRepository.deleteById(tarefaId);

		} catch (EmptyResultDataAccessException e) {
			throw new TarefaNaoEncontradaException(tarefaId);

		} 
	}

	public Tarefa buscarOuFalhar(Long tarefaId) {
		return tarefaRepository.findById(tarefaId).orElseThrow(() -> new TarefaNaoEncontradaException(tarefaId));
	}
}
