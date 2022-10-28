package marechal.loan.projetbackend.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Email
	@NotNull
	private String mailAddress;
	
	@NotNull
	private String phoneNumber;
	
	@NotNull
	private String civility;
	
	@NotNull
	private String fname;
	
	@NotNull
	private String lname;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull
	private Date dob;
	
	@NotNull
	private String idNumber;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull
	private Date dateStartActivity;
	
	@NotNull
	private double monthlyIncome;
	
	private boolean oldClient;
	
	@OneToMany(mappedBy = "client")
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<Simulation> simulations;
}
