package br.com.itau.todolist.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.todolist.core.security.ApiSecurity;
import br.com.itau.todolist.core.security.CheckSecurity;
import br.com.itau.todolist.domain.filter.TarefaFilter;
import br.com.itau.todolist.domain.model.Tarefa;
import br.com.itau.todolist.domain.model.Usuario;
import br.com.itau.todolist.domain.repository.TarefaRepository;
import br.com.itau.todolist.domain.repository.specs.TarefaSpecs;
import br.com.itau.todolist.domain.service.CadastroTarefaService;

@RequestMapping("/tarefas")
@RestController
public class TarefaController {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private CadastroTarefaService cadastroTarefa;
	
	@Autowired
	private ApiSecurity apiSecurity;
	
	@GetMapping
	@CheckSecurity.Tarefas.PodeListar
	public List<Tarefa> listar(TarefaFilter filtro) {
		return tarefaRepository.findAll(TarefaSpecs.usandoFiltro(filtro));
	}
	
	@GetMapping("/{id}")
	@CheckSecurity.Tarefas.PodeBuscar
	public Tarefa buscar(@PathVariable Long id) {
		return cadastroTarefa.buscarOuFalhar(id);
	}
	
	@PostMapping
	@CheckSecurity.Tarefas.PodeCadastrar
	public ResponseEntity<Tarefa> adicionar(@RequestBody Tarefa tarefa) {
		
		tarefa.setUsuario(new Usuario());
		tarefa.getUsuario().setId(apiSecurity.getUsuarioId());
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(cadastroTarefa.salvar(tarefa));
	}
	
	@PutMapping("/{tarefaId}")
	@CheckSecurity.Tarefas.PodeGerenciar
	public Tarefa atualizar(@PathVariable Long tarefaId, @RequestBody Tarefa tarefa) {
		Tarefa tarefaBuscada = cadastroTarefa.buscarOuFalhar(tarefaId);
			
		BeanUtils.copyProperties(tarefa, tarefaBuscada, "id", "dataInclusao");
		Tarefa tarefaSalva = cadastroTarefa.salvar(tarefaBuscada);
				
		return tarefaSalva;
	}
	
	@DeleteMapping("/{tarefaId}")
	@CheckSecurity.Tarefas.PodeGerenciar
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long tarefaId) {
			cadastroTarefa.excluir(tarefaId);
	}
}
