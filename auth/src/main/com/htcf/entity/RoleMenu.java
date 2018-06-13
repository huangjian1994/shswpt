package com.htcf.entity;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


	

@Entity
@Table(name="BASE_ROLE_MENU")
public class RoleMenu implements Serializable{

	private static final long serialVersionUID = -1708173570262730381L;


		@Id
		@GeneratedValue
		private Long id;
		
		
		@OneToOne(fetch = FetchType.EAGER)
		private Menu menu;
		
		
		@OneToOne(fetch = FetchType.EAGER)
		private Role role;
		


		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}



		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public Menu getMenu() {
			return menu;
		}

		public void setMenu(Menu menu) {
			this.menu = menu;
		}
		

	}



