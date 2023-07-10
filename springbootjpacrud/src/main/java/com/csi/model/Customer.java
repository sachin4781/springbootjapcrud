package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue

    private int custid;

    @Size(min = 5,message = "Customer Name Should be At Least 5 Character..")
    private String custname;

    private String custaddress;

    private double custsalary;

    @Range(min = 1000000000, max = 9999999999L, message = "Employee Contact Number must be 10 digit")
    @Column(unique = true)
    private long custcontactnumber;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date custdob;

    @Email(message = "Emaild Id Must Be Valid...")
    @Column(unique = true)
    private String custemailid;

    @Size(min = 4,message = "Customer Password Should be At Least 4 Character..")
    private String custpassword;


}
