package es.rf.banco.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;


@Repository
public class CuentaMo implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@NotEmpty 
	private String mNumero;
	
	@NotEmpty 
	private String mTitular;
	public String getmNumero() {
		return mNumero;
	}
	public void setmNumero(String mNumero) {
		this.mNumero = mNumero;
	}
	public String getmTitular() {
		return mTitular;
	}
	public void setmTitular(String mTitular) {
		this.mTitular = mTitular;
	}
	
	
	
}
