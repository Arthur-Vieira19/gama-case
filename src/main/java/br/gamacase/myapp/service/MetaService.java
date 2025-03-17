package br.gamacase.myapp.service;

import br.gamacase.myapp.domain.Meta;
import br.gamacase.myapp.repository.MetaRepository;
import br.gamacase.myapp.service.dto.MetaDTO;
import br.gamacase.myapp.service.mapper.MetaMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link br.gamacase.myapp.domain.Meta}.
 */
@Service
@Transactional
public class MetaService {

    private static final Logger LOG = LoggerFactory.getLogger(MetaService.class);

    private final MetaRepository metaRepository;

    private final MetaMapper metaMapper;

    public MetaService(MetaRepository metaRepository, MetaMapper metaMapper) {
        this.metaRepository = metaRepository;
        this.metaMapper = metaMapper;
    }

    /**
     * Save a meta.
     *
     * @param metaDTO the entity to save.
     * @return the persisted entity.
     */
    public MetaDTO save(MetaDTO metaDTO) {
        LOG.debug("Request to save Meta : {}", metaDTO);
        Meta meta = metaMapper.toEntity(metaDTO);
        meta = metaRepository.save(meta);
        return metaMapper.toDto(meta);
    }

    /**
     * Update a meta.
     *
     * @param metaDTO the entity to save.
     * @return the persisted entity.
     */
    public MetaDTO update(MetaDTO metaDTO) {
        LOG.debug("Request to update Meta : {}", metaDTO);
        Meta meta = metaMapper.toEntity(metaDTO);
        meta = metaRepository.save(meta);
        return metaMapper.toDto(meta);
    }

    /**
     * Partially update a meta.
     *
     * @param metaDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MetaDTO> partialUpdate(MetaDTO metaDTO) {
        LOG.debug("Request to partially update Meta : {}", metaDTO);

        return metaRepository
            .findById(metaDTO.getId())
            .map(existingMeta -> {
                metaMapper.partialUpdate(existingMeta, metaDTO);

                return existingMeta;
            })
            .map(metaRepository::save)
            .map(metaMapper::toDto);
    }

    /**
     * Get all the metas.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MetaDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Metas");
        return metaRepository.findAll(pageable).map(metaMapper::toDto);
    }

    /**
     * Get one meta by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MetaDTO> findOne(Long id) {
        LOG.debug("Request to get Meta : {}", id);
        return metaRepository.findById(id).map(metaMapper::toDto);
    }

    /**
     * Delete the meta by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        LOG.debug("Request to delete Meta : {}", id);
        metaRepository.deleteById(id);
    }
}
