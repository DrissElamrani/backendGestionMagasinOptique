package com.Optique.gestionMagasinOptique.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("lentille")
public class Lentille extends Produit {
	/** @pdOid abdf9b9a-8216-46c8-afc0-4b1912e5897f */
	private Float sph;
	/** @pdOid 397e2b05-88c5-47f5-bddb-d1988a3ce92b */
	private Float cyl;
	/** @pdOid 58e9d472-b1de-4687-9a33-6bbd06b57d6d */
	private Float axe;
	/** @pdOid 3c6035d5-37bf-41e6-91be-7e43853b50b3 */
	private Float rc;
	/** @pdOid 87e104bb-0142-4a52-b7d1-b3c36d7b81f8 */
	private String oeilGaucheDroit;
	/** @pdOid 2978a485-18d3-4268-b164-4e16c54734ab */
	private String nature;
	/** @pdOid d712eda1-2f31-406d-bd04-d22773811e20 */
	private String type;

	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Float getSph() {
		return sph;
	}

	public void setSph(Float sph) {
		this.sph = sph;
	}

	public Float getCyl() {
		return cyl;
	}

	public void setCyl(Float cyl) {
		this.cyl = cyl;
	}

	public Float getAxe() {
		return axe;
	}

	public void setAxe(Float axe) {
		this.axe = axe;
	}

	public Float getRc() {
		return rc;
	}

	public void setRc(Float rc) {
		this.rc = rc;
	}

	public String getOeilGaucheDroit() {
		return oeilGaucheDroit;
	}

	public void setOeilGaucheDroit(String oeilGaucheDroit) {
		this.oeilGaucheDroit = oeilGaucheDroit;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
