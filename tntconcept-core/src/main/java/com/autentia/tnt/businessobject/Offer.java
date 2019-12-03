/**
 * TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
 * Copyright (C) 2007 Autentia Real Bussiness Solution S.L.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.autentia.tnt.businessobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.autentia.tnt.dao.ITransferObject;

public class Offer implements Serializable, ITransferObject {

	public static final int MAX_LENGTH = 4096;

	/* Offer - generated by stajanov (do not edit/delete) */

	// Fields
	private Integer id;

	private String number;

	private String title;

	private String description;

	private String observations;

	private Date creationDate;

	private Date validityDate;

	private Date maturityDate;

	private OfferState offerState;

	private OfferPotential offerPotential;

	private Integer ownerId;

	private Integer departmentId;

	private Date insertDate;

	private Date updateDate;

	private User user;

	private Organization organization;

	private Contact contact;

	private OfferRejectReason offerRejectReason;

	private Set<Interaction> interactions;

	private Set<OfferRole> roles;

	private Set<OfferCost> costs;

	/** Utilizado para indicarle al report si debe mostrar el iva */
	private boolean showIvaIntoReport = true;

	// Setters and getters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description != null && description.length() > MAX_LENGTH) {
			description = description.substring(0, MAX_LENGTH);
		}		
		this.description = description;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		if (observations != null && observations.length() > MAX_LENGTH) {
			observations = observations.substring(0, MAX_LENGTH);
		}		
		this.observations = observations;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public OfferState getOfferState() {
		return offerState;
	}

	public void setOfferState(OfferState offerState) {
		this.offerState = offerState;
	}

	public OfferPotential getOfferPotential() {
		return offerPotential;
	}

	public void setOfferPotential(OfferPotential offerPotential) {
		this.offerPotential = offerPotential;
	}

	/**
	 * Devuelve la base imponible de la roles de la oferta
	 */
	public BigDecimal getTaxBaseRoles() {
		BigDecimal total = new BigDecimal(0);
		if (roles != null) {
			for (OfferRole offerRole : roles) {
				if (offerRole != null && offerRole.getCostPerHour() != null && offerRole.getIva() != null) {
					// product of number of hours and cost per hour
					BigDecimal hoursPerCostPerHour = new BigDecimal(offerRole.getExpectedHours()).multiply(offerRole
							.getCostPerHour());

					// total cost for this role
					total = total.add(hoursPerCostPerHour);
				}
			}
		}
		return total.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * Devuelve el IVA de los roles de la oferta
	 */
	public BigDecimal getIvaRoles() {
		BigDecimal total = new BigDecimal(0);
		if (roles != null) {
			for (OfferRole offerRole : roles) {
				if (offerRole != null && offerRole.getCostPerHour() != null && offerRole.getIva() != null) {
					// product of number of hours and cost per hour
					BigDecimal hoursPerCostPerHour = new BigDecimal(offerRole.getExpectedHours()).multiply(offerRole
							.getCostPerHour());

					// cost associated to the IVA
					BigDecimal costPerIva = hoursPerCostPerHour.multiply(offerRole.getIva())
							.divide(new BigDecimal(100));

					// total cost for this role
					total = total.add(costPerIva);
				}
			}
		}
		return total.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getTotalRoles() {

		BigDecimal totalRoles = new BigDecimal(0);
		if (roles != null) {
			for (OfferRole offerRole : roles) {
				if (offerRole != null && offerRole.getCostPerHour() != null && offerRole.getIva() != null) {
					// product of number of hours and cost per hour
					BigDecimal hoursPerCostPerHour = new BigDecimal(offerRole.getExpectedHours()).multiply(offerRole
							.getCostPerHour());

					// cost associated to the IVA
					BigDecimal costPerIva = hoursPerCostPerHour.multiply(offerRole.getIva())
							.divide(new BigDecimal(100));

					// total cost for this role
					totalRoles = totalRoles.add(hoursPerCostPerHour).add(costPerIva);
				}
			}
		}
		return totalRoles.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * Devuelve la base imponible de los costes de la oferta
	 */
	public BigDecimal getTaxBaseCosts() {
		BigDecimal totalCosts = new BigDecimal(0);
		if (costs != null) {
			for (OfferCost offerCost : costs) {

				if (offerCost.getUnits() != null && offerCost.getCost() != null && offerCost.getIva() != null
						&& offerCost.isBillable()) {

					// product of number of hours and cost per hour
					BigDecimal unitsPerCostPerUnit = offerCost.getUnits().multiply(offerCost.getCost());

					// total cost for this role
					totalCosts = totalCosts.add(unitsPerCostPerUnit);
				}
			}
		}
		return totalCosts.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * Devuelve el IVA de los costes de la oferta
	 */
	public BigDecimal getIvaCosts() {
		BigDecimal totalCosts = new BigDecimal(0);
		if (costs != null) {
			for (OfferCost offerCost : costs) {

				if (offerCost.getUnits() != null && offerCost.getCost() != null && offerCost.getIva() != null
						&& offerCost.isBillable()) {

					// product of number of hours and cost per hour
					BigDecimal unitsPerCostPerUnit = offerCost.getUnits().multiply(offerCost.getCost());

					// cost associated to the IVA
					BigDecimal costPerIva = unitsPerCostPerUnit.multiply(offerCost.getIva())
							.divide(new BigDecimal(100));

					// total cost for this role
					totalCosts = totalCosts.add(costPerIva);
				}
			}
		}
		return totalCosts.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getTotalCosts() {

		BigDecimal totalCosts = new BigDecimal(0);
		if (costs != null) {
			for (OfferCost offerCost : costs) {

				if (offerCost.getUnits() != null && offerCost.getCost() != null && offerCost.getIva() != null
						&& offerCost.isBillable()) {

					// product of number of hours and cost per hour
					BigDecimal unitsPerCostPerUnit = offerCost.getUnits().multiply(offerCost.getCost());

					// cost associated to the IVA
					BigDecimal costPerIva = unitsPerCostPerUnit.multiply(offerCost.getIva())
							.divide(new BigDecimal(100));

					// total cost for this role
					totalCosts = totalCosts.add(unitsPerCostPerUnit).add(costPerIva);
				}
			}
		}
		return totalCosts.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public BigDecimal getTotal() {
		return getTotalRoles().add(getTotalCosts());
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public OfferRejectReason getOfferRejectReason() {
		return offerRejectReason;
	}

	public void setOfferRejectReason(OfferRejectReason offerRejectReason) {
		this.offerRejectReason = offerRejectReason;
	}

	public Set<Interaction> getInteractions() {
		return interactions;
	}

	public void setInteractions(Set<Interaction> interactions) {
		this.interactions = interactions;
	}

	public Set<OfferRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<OfferRole> roles) {
		this.roles = roles;
	}

	public Set<OfferCost> getCosts() {
		return costs;
	}

	public void setCosts(Set<OfferCost> costs) {
		this.costs = costs;
	}

	public boolean isShowIvaIntoReport() {
		return showIvaIntoReport;
	}

	public void setShowIvaIntoReport(boolean showIvaIntoReport) {
		this.showIvaIntoReport = showIvaIntoReport;
	}


	@Override
	public boolean equals(Object that) {
		try {
			if (that == null)
				return false;
			else
				return this.getId().equals(((Offer)that).getId());
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int hashCode() {
		if (this.getId() == null)
			return super.hashCode();
		else
			return this.getId().intValue();
	}

	public List<Integer> getOwnersId() {
		// TODO Auto-generated method stub
		return null;
	}

	/* Offer - generated by stajanov (do not edit/delete) */

}
