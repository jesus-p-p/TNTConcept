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

package com.autentia.tnt.manager.contacts;

import com.autentia.tnt.businessobject.Contact;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.autentia.tnt.businessobject.Position;
import com.autentia.tnt.businessobject.PositionChange;
import com.autentia.tnt.businessobject.Tag;
import com.autentia.tnt.dao.SortCriteria;
import com.autentia.tnt.dao.hibernate.ContactDAO;
import com.autentia.tnt.dao.hibernate.PositionDAO;
import com.autentia.tnt.dao.search.PositionSearch;
import com.autentia.tnt.manager.security.AuthenticationManager;
import com.autentia.tnt.util.SpringUtils;

public class PositionManager {
	
	public static final String FIELD_NAME = "position.name";

	public static final String FIELD_DESCRIPTION = "position.description";

	public static final String FIELD_TAGS = "position.tags";

	/* Position - generated by stajanov (do not edit/delete) */

	/** Logger */
	private static final Log log = LogFactory.getLog(PositionManager.class);

	private static final String FIELD_EMAIL = "position.email";

	private static final String FIELD_PHONE = "position.phone";

	private static final String FIELD_FAX = "position.fax";

	private static final String FIELD_COUNTRY = "position.country";

	private static final String FIELD_POSTALCODE = "position.postalCode";

	private static final String FIELD_ADDRESS = "position.address";

	private static final String FIELD_CITY = "position.city";

	private static final String FIELD_PROVINCE = "position.province";

	/** Position DAO **/
	private PositionDAO positionDAO;
	
	 private ContactDAO contactDAO;

		public void setContactDAO(ContactDAO contactDAO) {
			this.contactDAO = contactDAO;
		}

	/**
	 * AutheticationManager required for tracking injected by Spring
	 */
	private AuthenticationManager authManager;

	public AuthenticationManager getAuthManager() {
		return authManager;
	}

	public void setAuthManager(AuthenticationManager authManager) {
		this.authManager = authManager;
	}

	/**
	 * Get default PositionManager as defined in Spring's configuration file.
	 * 
	 * @return the default singleton PositionManager
	 */
	public static PositionManager getDefault() {
		return (PositionManager)SpringUtils.getSpringBean("managerPosition");
	}

	/**
	 * Empty constructor needed by CGLIB (Spring AOP)
	 */
	protected PositionManager() {
	}

	/**
	 * Default constructor
	 * 
	 * @deprecated do not construct managers alone: use Spring's declared beans
	 */
	public PositionManager(PositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}

	/**
	 * List positions.
	 * 
	 * @param search search filter to apply
	 * @param sort sorting criteria
	 * @return the list of all positions sorted by requested criterion
	 */
	public List<Position> getAllEntities(PositionSearch search, SortCriteria sort) {
		return positionDAO.search(search, sort);
	}

	/**
	 * Get position by primary key.
	 * 
	 * @return position selected by id.
	 */
	public Position getEntityById(int id) {
		Position position = positionDAO.loadById(id);
		position.initChanges();
		return position;
	}

	/**
	 * Insert position.
	 */
	public void insertEntity(Position position) {
		positionDAO.insert(position);
	}

	/**
	 * Update position.
	 */
	public void updateEntity(Position position) {
		// get changes for history
		Position changes = position.getChanges();
		
		// update the entity
		positionDAO.update(position);
		
		// tracking entity changes
		Position positionHibSession = positionDAO.loadById(position.getId());
		positionHibSession.setChanges(changes);
		this.trackEntityChanges(positionHibSession);
	}

	/**
	 * Delete position.
	 */
	public void deleteEntity(Position position) {
		positionDAO.delete(position);
	}

	/* Position - generated by stajanov (do not edit/delete) */

	/**
	 * Mira los campos de la entidad a ver si se han producido cambios
	 * 
	 * @return true si se produjo algun cambio
	 */
	private boolean trackEntityChanges(Position position) {

		int previousHistorySize = position.getHistory().size();
		int finalHistorySize = previousHistorySize;
		final Position changes = position.getChanges();
		// TODO ¿podría ser por reflexion para obtener los atributos persistentes?
		if (changes != null) {
            if (changes.getName() != null && !changes.getName().equals(position.getName())) {
				position.getHistory().add(getChange(position, FIELD_NAME, changes.getName(), position.getName()));
                this.trackContactChanges(position);
			}

			position.getHistory().add(
					getChange(position, FIELD_DESCRIPTION, changes.getDescription(), position.getDescription()));
			position.getHistory().add(getChange(position, FIELD_EMAIL, changes.getEmail(), position.getEmail()));
			position.getHistory().add(getChange(position, FIELD_PHONE, changes.getPhone(), position.getPhone()));
			position.getHistory().add(getChange(position, FIELD_FAX, changes.getFax(), position.getFax()));
			position.getHistory().add(getChange(position, FIELD_COUNTRY, changes.getCountry(), position.getCountry()));
			position.getHistory().add(
					getChange(position, FIELD_POSTALCODE, changes.getPostalCode(), position.getPostalCode()));
			position.getHistory().add(getChange(position, FIELD_ADDRESS, changes.getAddress(), position.getAddress()));
			position.getHistory().add(getChange(position, FIELD_CITY, changes.getCity(), position.getCity()));

			position.getHistory().add(getProvinceChange(position));

			position.getHistory().addAll(getPositionTagChanges(position));

			finalHistorySize = position.getHistory().size();
		}
		// if has changes previousHistorySize != finalHistorySize
		return previousHistorySize != finalHistorySize;
	}

	private PositionChange getProvinceChange(Position position) {
		String previous = "";
		String now = "";
		Position changes = position.getChanges();
		// no vamos a compara la entidad (su ID) vamos a hacerlo
		// por el nombre de la provincia, ya que aunque sea la misma entidad (mismo ID)
		// si durante la edición del puesto ha cambiado el nombre de la entidad
		// no está de más reflejarlo
		if (changes.getProvince() != null) {
			previous = StringUtils.defaultIfEmpty(changes.getProvince().getName(), "");
		}
		if (position.getProvince() != null) {
			now = StringUtils.defaultIfEmpty(position.getProvince().getName(), "");
		}
		return getChange(position, FIELD_PROVINCE, previous, now);
	}

	public PositionChange getChange(Position position, String field, String oldValue, String newValue) {
		PositionChange change = null;
		if (!StringUtils.equals(oldValue, newValue)) {
			oldValue = StringUtils.defaultIfEmpty(oldValue, "");
			newValue = StringUtils.defaultIfEmpty(newValue, "");
			change = new PositionChange();
			change.setField(field);
			change.setOldValue(oldValue);
			change.setNewValue(newValue);
			change.setPosition(position);
			change.setUser(authManager.getCurrentPrincipal().getUser());
			change.setInsertDate(new Date());
		}
		return change;
	}

	private List<PositionChange> getPositionTagChanges(Position position) {
		final List<PositionChange> changes = new ArrayList<PositionChange>();
		for (Tag tag : position.getTags()) {
			if (!position.getChanges().getTags().contains(tag)) {
				changes.add(getChange(position, FIELD_TAGS, "", tag.getName()));
			}
		}
		for (Tag tag : position.getChanges().getTags()) {
			if (!position.getTags().contains(tag)) {
				changes.add(getChange(position, FIELD_TAGS, tag.getName(), ""));
			}
		}
		return changes;
	}

    private void trackContactChanges(Position position) {
        if (!position.getName().equals(position.getChanges().getName()))
        {
            final List<Contact> contacts = positionDAO.getContactsForPosition(position);
            for (Contact contact : contacts) {
                
                contact.addEntityChange(Contact.FIELD_POSITION,
                        position.getChanges().getName(), position.getName(),position.getId().toString());
                contactDAO.update(contact);
            }
        }
    }
}
