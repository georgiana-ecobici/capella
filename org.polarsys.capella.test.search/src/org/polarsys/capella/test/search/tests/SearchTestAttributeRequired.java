/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.test.search.tests;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.ui.search.CapellaSearchQuery;
import org.polarsys.capella.core.ui.search.CapellaSearchSettings;
import org.polarsys.capella.core.ui.search.searchfor.SearchForItemCache;
import org.polarsys.capella.core.ui.search.searchfor.item.SearchForClassItem;

public class SearchTestAttributeRequired extends AbstractSearchAndReplaceTestCase {
  private static final String TEXT_PATTERN = "Text_Pattern";
  private static final String AT_LEAST_ONE_ATTRIBUTE_STATUS_MESSAGE = "At least one attribute must be selected";

  @Override
  protected CapellaSearchSettings initSettings() {
    CapellaSearchSettings searchSettings = new CapellaSearchSettings();
    setBasicSearchSettings(searchSettings, false, false, false, TEXT_PATTERN);
    return searchSettings;
  }

  @Override
  public void test() throws Exception {
    CapellaSearchSettings searchSettings = initSettings();
    Set<Object> emptySet = new HashSet<Object>();
    searchSettings.setSearchClassItems(emptySet);
    searchSettings.setSearchAttributeItems(emptySet);
    setMetaClasses(searchSettings);
    assertEquals(AT_LEAST_ONE_ATTRIBUTE_STATUS_MESSAGE, searchSettings.validate().getMessage());
  }

  @Override
  protected void performChecks(CapellaSearchQuery searchQuery) {
    // TODO Auto-generated method stub
  }

  @Override
  protected void setMetaClasses(CapellaSearchSettings searchSettings) {
    Set<Object> searchMetaClasses = SearchForItemCache.getInstance().getClassItems().stream()
        .filter(item -> CapellacorePackage.Literals.NAMED_ELEMENT.isSuperTypeOf((EClass) item.getObject()))
        .filter(SearchForClassItem.class::isInstance).map(SearchForClassItem.class::cast).collect(Collectors.toSet());
    searchSettings.setSearchClassItems(searchMetaClasses);
  }

  @Override
  protected void setMetaAttributes(CapellaSearchSettings searchSettings) {
    // TODO Auto-generated method stub
  }

}
