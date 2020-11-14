/**
 * 
 */
package com.userapp.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "User")

public class User implements Serializable{
	
	private Long userId;
    private String userName;
    private String department;
    /* In User table, we defined a column BOSS_ID which is mapped to the same table’s primary key USER_ID. 
     * Thus for each user we will store its boss id also. Boss will be yet another user in this table.
       This is referenced by OneToMany and ManyToOne relationship as coded below.
     */
    private Long bossId;
    private Set<User> users; 
    private User boss;
    
    public User() {
    }
 
    public User(Long userId, String userName,String department, Long bossId) {
    	 this.userId = userId;
    	 this.userName = userName;
         this.department = department;
         this.bossId = bossId;
    }
    
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
 
    @Column(name = "user_name", nullable = false)
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name = "department", nullable = false)
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    
    /*@Column(name = "boss_id",nullable = true)
    public Long getBossId() {
        return bossId;
    }
    public void setBossId(Long bossId) {
        this.bossId = bossId;
    }*/
    
    
    @ManyToOne(cascade={CascadeType.MERGE},fetch = FetchType.LAZY)
	@JoinColumn(name="boss_id")
    
    public User getBoss() {
    	return boss;
    }
    
    public void setBoss(User boss) {
    	this.boss=boss;
    }
    
    @OneToMany(targetEntity = User.class, fetch = FetchType.LAZY, mappedBy = "boss")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    
    public Set<User> getUsers() {
    	return users;
	}
    
    public void setUsers(Set<User> users) {
		this.users = users ;
	}
 
      
}
