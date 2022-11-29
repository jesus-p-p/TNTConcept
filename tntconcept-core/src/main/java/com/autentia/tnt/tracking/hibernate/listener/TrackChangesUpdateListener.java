/**
 * TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
 * Copyright (C) 2007 Autentia Real Bussiness Solution S.L.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.autentia.tnt.tracking.hibernate.listener;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.autentia.tnt.dao.ITransferObject;
import com.autentia.tnt.tracking.Tracking;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;


public class TrackChangesUpdateListener implements PostUpdateEventListener {

    private static final long serialVersionUID = 8083135702492242171L;

    private static final Log log = LogFactory.getLog(TrackChangesUpdateListener.class);

    public void onPostUpdate(PostUpdateEvent event) {
        try {

            ITransferObject transferObject = (ITransferObject) event.getEntity();

            if (transferObject instanceof Tracking) {
                Tracking tracking = (Tracking) transferObject;
                tracking.commitCurrentChanges();

            }
        } catch (SecurityException e) {
            log.error(e);
        } catch (ClassCastException e) {
            //lo ignoramos al no tratarse de una entidad bajo el control de cambios
        }

    }

    public boolean requiresPostCommitHandling(EntityPersister entityPersister) {
        return false;
    }
}
