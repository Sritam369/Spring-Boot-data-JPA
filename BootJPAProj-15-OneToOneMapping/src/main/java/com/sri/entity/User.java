package com.sri.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name="user_mapping")
public class User {

	@Id
	@SequenceGenerator(name="gen1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String email;
	@NonNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="User_profiles" , referencedColumnName = "id")
	private Profile profiles;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
