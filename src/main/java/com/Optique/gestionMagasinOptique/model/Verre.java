package com.Optique.gestionMagasinOptique.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Verre")
public class Verre extends Produit {
	/** @pdOid c6dd8abe-9663-49a0-a88c-31d7e2769517 */
	private Float sph;
	/** @pdOid ac2e735f-3e53-4bdc-85a9-d54bc60e87b8 */
	private float cyl;
	/** @pdOid edebead1-1c22-4516-ba6f-5ef899cd166f */
	private Float axe;
	/** @pdOid 0974bd35-e79f-4512-a76b-1be98adea090 */
	private float addV;
	/** @pdOid 4ed29fb5-d6ac-432e-972e-c48cabc11957 */
	private Float visionPres;
	/** @pdOid 732b0941-c517-4bba-bfbd-cfcf5d77a66a */
	private Float visionLoin;
	/** @pdOid c7cef989-e816-43c5-9f4e-d2591eb605c2 */
	private String nature;
	/** @pdOid 60d8f6d1-55ac-40d8-8a91-170fee865bee */
	private String oeilGaucheDroit;

	public Float getSph() {
		return sph;
	}

	public void setSph(Float sph) {
		this.sph = sph;
	}

	public float getCyl() {
		return cyl;
	}

	public void setCyl(float cyl) {
		this.cyl = cyl;
	}

	public Float getAxe() {
		return axe;
	}

	public void setAxe(Float axe) {
		this.axe = axe;
	}

	public float getAddV() {
		return addV;
	}

	public void setAddV(float addV) {
		this.addV = addV;
	}

	public Float getVisionPres() {
		return visionPres;
	}

	public void setVisionPres(Float visionPres) {
		this.visionPres = visionPres;
	}

	public Float getVisionLoin() {
		return visionLoin;
	}

	public void setVisionLoin(Float visionLoin) {
		this.visionLoin = visionLoin;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getOeilGaucheDroit() {
		return oeilGaucheDroit;
	}

	public void setOeilGaucheDroit(String oeilGaucheDroit) {
		this.oeilGaucheDroit = oeilGaucheDroit;
	}
}
