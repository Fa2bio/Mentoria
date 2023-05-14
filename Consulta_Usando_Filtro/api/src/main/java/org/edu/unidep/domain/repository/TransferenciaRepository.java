package org.edu.unidep.domain.repository;

import java.util.List;

import org.edu.unidep.domain.filter.TransferenciaFilter;
import org.edu.unidep.domain.model.Transferencia;

public interface TransferenciaRepository {
	List<Transferencia> getWithFilter(TransferenciaFilter transferenciaFilter);
}
