package br.com.transpobrasil.test.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Posting")
public class Posting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posting_generator")
	@SequenceGenerator(name = "posting_generator", sequenceName = "posting_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "code", updatable = false, nullable = false)
	private Long code;
	@Temporal(TemporalType.DATE)
	@Column(name = "initial_date")
	private Date initialDate;
	@Temporal(TemporalType.DATE)
	@Column(name = "final_Date")
	private Date finalDate;

	@Column(length = 1000)
	private String note;

	@Column(precision = 8, scale = 2)
	private BigDecimal amount;

	@ManyToMany
	@JoinTable(name = "PostingItem", joinColumns = @JoinColumn(name = "code_posting"), inverseJoinColumns = @JoinColumn(name = "code_item"))
	private List<Item> items = new ArrayList<>();

	public Posting() {
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
