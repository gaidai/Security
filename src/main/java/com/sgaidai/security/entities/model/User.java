package com.sgaidai.security.entities.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;






@Entity        
@Table(name="user"
    ,catalog="testing",uniqueConstraints = @UniqueConstraint(
		columnNames = {"user_name","password" })        
)
@ToString
@Getter
@Setter
public class User  implements Serializable {

    @Id 
    @Column(name="user_id", unique=true, nullable=false)
    private int userId;
    
    @Column(name="first_name", nullable=false, length=50)
    private String firstName;
    
    @Column(name="last_name", nullable=false, length=50)
    private String lastName;
    
    @Column(name="email", nullable=false, length=50)
    private String email;
    
    @Column(name="user_name", nullable=false, length=50)
    private String username;
    
    @Column(name="password", nullable=false, length=100)
    private String password;
    
    @Column(name="enabled", nullable=false)  
    private Boolean enabled; 
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="user")
    private Set<Role> roles = new HashSet<Role>(0);

 
public void reset(){
        this.userId = 0;
        this.firstName ="";
        this.lastName ="";
        this.email ="";
        this.password = "";
        this.username ="";
        this.roles = null;
        this.enabled= true;
        
    }   
}


