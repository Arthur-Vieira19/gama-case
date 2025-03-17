package br.gamacase.myapp.service.mapper;

import static br.gamacase.myapp.domain.MetaAsserts.*;
import static br.gamacase.myapp.domain.MetaTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MetaMapperTest {

    private MetaMapper metaMapper;

    @BeforeEach
    void setUp() {
        metaMapper = new MetaMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getMetaSample1();
        var actual = metaMapper.toEntity(metaMapper.toDto(expected));
        assertMetaAllPropertiesEquals(expected, actual);
    }
}
