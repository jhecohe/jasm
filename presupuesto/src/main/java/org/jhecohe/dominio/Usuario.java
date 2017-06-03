package org.jhecohe.dominio;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idusuario")
	private int idUsuario;
	
	@Column(name="nombre")
	@NotEmpty(message="*Ingrese su nombre porfavor")
	private String nombre;
	
	@Column(name="apellido")
	@NotEmpty(message="*Ingrese su apellido porfavor")
	private String apellido;
	
	@Column(name="email")
	@Email(message="*Porfavor ingrese un correo valido")
	@NotEmpty(message="*Ingrese su correo porfavor")
	private String email;
	
	@Column(name="clave")
	@Length(min=6, message="por favor ingrese una clave con minimo 6 caracteres")
	@NotEmpty(message="*Ingrese su clave porfavor")
	private String clave;
	
	@Column(name="estado")
	private Long estado;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="usuario_has_role", joinColumns=@JoinColumn(name="usuario_idusuario"), inverseJoinColumns=@JoinColumn(name="role_idrole"))
	private Set<Role> role;
	
	
	public Usuario() {
		super();
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Long getEstado() {
		return estado;
	}
	public void setEstado(Long estado) {
		this.estado = estado;
	}
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ""
				+ ", email=" + email + ", clave=" + clave + ", estado=" + estado + ", role=" + role + "]";
	}
}
