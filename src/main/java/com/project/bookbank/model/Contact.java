package com.project.bookbank.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="person_id")
		private Integer personId;
	
		@Column(name="person_name")
		private String personName;
		
		@Column(name="person_email")
		private String personEmail;
		
		@Column(name="person_msg")
		private String personMsg;

		public String getPersonName() {
			return personName;
		}

		public void setPersonName(String personName) {
			this.personName = personName;
		}

		public String getPersonEmail() {
			return personEmail;
		}

		public void setPersonEmail(String personEmail) {
			this.personEmail = personEmail;
		}

		public String getPersonMsg() {
			return personMsg;
		}

		public void setPersonMsg(String personMsg) {
			this.personMsg = personMsg;
		}

		@Override
		public String toString() {
			return "Contact [personName=" + personName + ", personEmail=" + personEmail + ", personMsg=" + personMsg
					+ "]";
		}
		
		
}
