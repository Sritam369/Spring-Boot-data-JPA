package com.sri.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="employee_collections")
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee implements Serializable {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "s1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Nonnull
	private String name;
	@Nonnull
	private String addrs;
	@Nonnull
	@ElementCollection
	@CollectionTable(name="FRIENDS_INFO_TAB" , joinColumns= @JoinColumn(name="EMP_ID",referencedColumnName = "id"))
	private List<String> friends;
	@Nonnull
	@ElementCollection
	@CollectionTable(name="PHONES_INFO_TAB" , joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "id"))
	private Set<Long> phones;
	@Nonnull
	@ElementCollection
	@CollectionTable(name="ID_DETAILS_INFO_TAB" , joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "id"))
	@MapKeyColumn(name="ID_TYPE")
	private Map<String,String> idDetails;
}
