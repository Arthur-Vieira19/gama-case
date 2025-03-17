package br.gamacase.myapp.domain;

import static br.gamacase.myapp.domain.AlunoTestSamples.*;
import static br.gamacase.myapp.domain.MetaTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import br.gamacase.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MetaTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Meta.class);
        Meta meta1 = getMetaSample1();
        Meta meta2 = new Meta();
        assertThat(meta1).isNotEqualTo(meta2);

        meta2.setId(meta1.getId());
        assertThat(meta1).isEqualTo(meta2);

        meta2 = getMetaSample2();
        assertThat(meta1).isNotEqualTo(meta2);
    }

    @Test
    void alunoTest() {
        Meta meta = getMetaRandomSampleGenerator();
        Aluno alunoBack = getAlunoRandomSampleGenerator();

        meta.setAluno(alunoBack);
        assertThat(meta.getAluno()).isEqualTo(alunoBack);

        meta.aluno(null);
        assertThat(meta.getAluno()).isNull();
    }
}
