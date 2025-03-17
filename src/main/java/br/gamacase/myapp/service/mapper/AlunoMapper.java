package br.gamacase.myapp.service.mapper;

import br.gamacase.myapp.domain.Aluno;
import br.gamacase.myapp.service.dto.AlunoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Aluno} and its DTO {@link AlunoDTO}.
 */
@Mapper(componentModel = "spring")
public interface AlunoMapper extends EntityMapper<AlunoDTO, Aluno> {}
