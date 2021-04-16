package br.com.itau.todolist.domain.repository.specs;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import br.com.itau.todolist.domain.filter.TarefaFilter;
import br.com.itau.todolist.domain.model.Tarefa;

public class TarefaSpecs {
	
	public static Specification<Tarefa> usandoFiltro(TarefaFilter filtro) {
		
		return (root, query, builder) -> {
			if (Tarefa.class.equals(query.getResultType())) {
				root.fetch("usuario");
			}

			var predicates = new ArrayList<Predicate>();

			if (filtro.getUsuarioId() != null) {
				predicates.add(builder.equal(root.get("usuario"), filtro.getUsuarioId()));
			}

			if (filtro.getStatus() != null) {
				predicates.add(builder.equal(root.get("status"), filtro.getStatus()));
			}
			
			query.orderBy(builder.desc(root.get("status")));

			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
