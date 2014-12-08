package org.lightadmin.demo.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.lightadmin.api.config.annotation.FileReference;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer extends AbstractEntity {

	@Column(length = 64)
    @NotEmpty
	private String firstname = "John Doe";

	@Column(length = 64)
	@NotEmpty
	private String lastname;

    @Embedded
    @Column(unique = true)
	private EmailAddress emailAddress;

    @Column(name = "REG_DATE")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate registrationDate;

    @Column(name = "REG_DATE_TIME")
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime registrationDateTime;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "CUSTOMER_ID")
	private Set<Address> addresses;

	@ManyToMany
	@JoinTable(name = "customer_discount",
			   joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "ID"),
			   inverseJoinColumns = @JoinColumn(name = "discount_program_id", referencedColumnName = "ID")
	)
	private Set<DiscountProgram> discountPrograms;

    @Column(name = "AVATAR_FILE_URL")
    @FileReference(baseDirectory = "C:/Users/charles/upload/lightadmin-demo")
    private String avatar;

	public Customer( String firstname, String lastname ) {
		Assert.hasText( firstname );
		Assert.hasText( lastname );

		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Customer() {
	}

	public void add( Address address ) {
		Assert.notNull( address );
		this.addresses.add( address );
	}

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getFirstname() {
		return firstname;
	}

	public void setFirstname( final String firstname ) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname( final String lastname ) {
		this.lastname = lastname;
	}

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress( final EmailAddress emailAddress ) {
		this.emailAddress = emailAddress;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses( final Set<Address> addresses ) {
		this.addresses = addresses;
	}

	public Set<DiscountProgram> getDiscountPrograms() {
		return discountPrograms;
	}

	public void setDiscountPrograms( final Set<DiscountProgram> discountPrograms ) {
		this.discountPrograms = discountPrograms;
	}

    public DateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public void setRegistrationDateTime(DateTime registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }
}