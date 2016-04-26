/*******************************************************************************
 * Copyright (c) 2010 Denis Solonenko.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * <p/>
 * Contributors:
 * Denis Solonenko - initial API and implementation
 ******************************************************************************/
package ru.orangesoftware.financisto.activity;

import android.view.View;

import java.util.List;

import ru.orangesoftware.financisto.R;
import ru.orangesoftware.financisto.blotter.BlotterFilter;
import ru.orangesoftware.financisto.filter.Criteria;
import ru.orangesoftware.financisto.model.MyLocation;

public class LocationsListActivity extends MyEntityListActivity<MyLocation> {

    public LocationsListActivity() {
        super(MyLocation.class);
    }

    @Override
    protected List<MyLocation> loadEntities() {
        return em.getAllLocationsList(false);
    }

    @Override
    protected String getContextMenuHeaderTitle(int position) {
        return getString(R.string.location);
    }

    @Override
    protected Class getEditActivityClass() {
        return LocationActivity.class;
    }

    @Override
    protected Criteria createBlotterCriteria(MyLocation location) {
        return Criteria.eq(BlotterFilter.LOCATION_ID, String.valueOf(location.id));
    }

    @Override
    protected void deleteItem(View v, int position, long id) {
        em.deleteLocation(id);
        recreateCursor();
    }

}
