package meu.curso.microservicos.procesamento.dto;

public class PeditoDTO {

    private Long id;
    private String descricao;

    @Override
    public String toString() {
        return "PeditoDTO{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
