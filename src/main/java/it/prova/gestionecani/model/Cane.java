package it.prova.gestionecani.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "cane")
public class Cane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "razza")
	private String razza;
	@Column(name = "nome")
	private String nome;
	@Column(name = "eta")
	private Integer eta;
	@Column(name = "dataadozione")
	private Date dataAdozione;
	@Column(name = "peso")
	private Integer peso;

	// campi per le time info del record
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Cane() {
		super();
	}

	public Cane(String razza, String nome) {
		super();
		this.razza = razza;
		this.nome = nome;
	}

	public Cane(String razza, String nome, Integer eta, Date dataAdozione, Integer peso) {
		super();
		this.razza = razza;
		this.nome = nome;
		this.eta = eta;
		this.dataAdozione = dataAdozione;
		this.peso = peso;
	}

	public Cane(Long id, String razza, String nome, Integer eta, Date dataAdozione, Integer peso) {
		super();
		this.id = id;
		this.razza = razza;
		this.nome = nome;
		this.eta = eta;
		this.dataAdozione = dataAdozione;
		this.peso = peso;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazza() {
		return razza;
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public Date getDataAdozione() {
		return dataAdozione;
	}

	public void setDataAdozione(Date dataAdozione) {
		this.dataAdozione = dataAdozione;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}
