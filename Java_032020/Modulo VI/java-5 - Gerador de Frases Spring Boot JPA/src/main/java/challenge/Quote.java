package challenge;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "scripts")
public class Quote implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String actor;

	@Column(name = "detail")
	private String quote;

	@JsonIgnore
	private String type;


	public Quote() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Quote quote1 = (Quote) o;

		if (id != null ? !id.equals(quote1.id) : quote1.id != null) return false;
		if (actor != null ? !actor.equals(quote1.actor) : quote1.actor != null) return false;
		return quote != null ? quote.equals(quote1.quote) : quote1.quote == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (actor != null ? actor.hashCode() : 0);
		result = 31 * result + (quote != null ? quote.hashCode() : 0);
		return result;
	}


}
