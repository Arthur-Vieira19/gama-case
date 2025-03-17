package br.gamacase.myapp.domain;

import br.gamacase.myapp.domain.enumeration.AreaDoEnem;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Meta.
 */
@Entity
@Table(name = "meta")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Meta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nota", nullable = false)
    private Integer nota;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "materia", nullable = false)
    private AreaDoEnem materia;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "metas" }, allowSetters = true)
    private Aluno aluno;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Meta id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return this.nota;
    }

    public Meta nota(Integer nota) {
        this.setNota(nota);
        return this;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public AreaDoEnem getMateria() {
        return this.materia;
    }

    public Meta materia(AreaDoEnem materia) {
        this.setMateria(materia);
        return this;
    }

    public void setMateria(AreaDoEnem materia) {
        this.materia = materia;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Meta aluno(Aluno aluno) {
        this.setAluno(aluno);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Meta)) {
            return false;
        }
        return getId() != null && getId().equals(((Meta) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Meta{" +
            "id=" + getId() +
            ", nota=" + getNota() +
            ", materia='" + getMateria() + "'" +
            "}";
    }
}
