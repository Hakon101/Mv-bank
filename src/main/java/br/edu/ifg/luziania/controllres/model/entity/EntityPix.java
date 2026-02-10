package br.edu.ifg.luziania.controllres.model.entity;
/// ///
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


//tabelas
@Entity
@Table(name ="entity-Pix")
public class EntityPix {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

        @Getter @Setter
    private Integer id;

    private long remetenteId;

    private long destinatarioId;

    @Getter @Setter
    private int chave;

    @Getter @Setter
    private int valor;

    protected EntityPix() {

    }

    public EntityPix(Integer id, int chave, int valor, long remetenteId, long destinatarioId) {
        this.id = id;
        this.chave = chave;
        this.valor = valor;
        this.remetenteId = remetenteId;
        this.destinatarioId = destinatarioId;
    }
}
