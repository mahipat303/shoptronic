package com.shoptronic.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long id;

	@Size(min = 3, max = 15, message = "First name should have 3-15 characters")
	private String firstName;
	@Size(min = 3, max = 15, message = "Last name should have 3-15 characters")
	private String lastName;

	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private List<Address> addresses;

	private String password;

	@Lob
	@Column(name = "image", columnDefinition = "MEDIUMBLOB")
	private String image;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Cart shoppingCart;

//	    @OneToMany(mappedBy = "customer")
//	    private List<Order> orders;

//	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	    @JoinTable( name = "customers_roles",
//	            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customer_id"),
//	            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
//	    private Collection<Role> roles;

}
