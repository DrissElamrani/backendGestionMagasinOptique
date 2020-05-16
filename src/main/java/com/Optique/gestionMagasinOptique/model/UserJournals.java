/***********************************************************************
 * Module:  UserJournals.java
 * Author:  pcuser9
 * Purpose: Defines the Class UserJournals
 ***********************************************************************/
package com.Optique.gestionMagasinOptique.model;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
/** @pdOid 7cd85c49-df62-44e8-9419-4f1e779e5056 */
public class UserJournals {
	 @Id
	 @SequenceGenerator(name = "USERJOURNALS_ID_SEQ", sequenceName = "USERJOURNALS_ID_SEQ", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERJOURNALST_ID_SEQ")
//	 @GeneratedValue(strategy=GenerationType.AUTO)
//	 @GeneratedValue
   /** @pdOid a0d9521b-44ba-4875-b02d-44a1b187cb05 */
   private int id;
   /** @pdOid eeddc677-b1c6-47b0-8042-a31e489fbc99 */
   private String action;
   /** @pdOid e053b1e1-dbcd-4807-86b5-6a7dc512c26f */
   private String dateAction;
//   private int iduser;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iduser")
	private User user;
//public int getIduser() {
//	return iduser;
//}
//public void setIduser(int iduser) {
//	this.iduser = iduser;
//}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAction() {
	return action;
}
public void setAction(String action) {
	this.action = action;
}

public String getDateAction() {
	return dateAction;
}
public void setDateAction(String dateAction) {
	this.dateAction = dateAction;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public UserJournals(String action, String dateAction, User user) {
	super();
	this.action = action;
	this.dateAction = dateAction;
    this.user=user;
}
public UserJournals() {
	super();
}
@Override
public String toString() {
	return "UserJournals [id=" + id + ", action=" + action + ", dateAction=" + dateAction + ", user=" + user + "]";
}


}