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

import java.util.Arrays;
import java.util.HashSet;

import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.data.ctx.CtxPackage;
import org.polarsys.capella.core.ui.search.CapellaSearchQuery;
import org.polarsys.capella.core.ui.search.CapellaSearchResult;
import org.polarsys.capella.core.ui.search.CapellaSearchSettings;
import org.polarsys.capella.core.ui.search.searchfor.item.SearchForAttributeItem;
import org.polarsys.capella.core.ui.search.searchfor.item.SearchForClassItem;

public class SearchTestIncorrectMetaClassSelected extends AbstractSearchAndReplaceTestCase {
  private static final String TEXT_PATTERN = "Test_Function";

  @Override
  protected CapellaSearchSettings initSettings() {
    CapellaSearchSettings searchSettings = new CapellaSearchSettings();
    setBasicSearchSettings(searchSettings, false, false, false, TEXT_PATTERN);
    return searchSettings;
  }

  @Override
  protected void performChecks(CapellaSearchQuery searchQuery) {
    CapellaSearchResult searchResult = searchQuery.getSearchResult();
    Object[] matches = searchResult.getElements();
    assertTrue(matches.length == 0);
  }

  @Override
  protected void setMetaClasses(CapellaSearchSettings searchSettings) {
    SearchForClassItem item = new SearchForClassItem(CtxPackage.Literals.CAPABILITY);
    searchSettings.setSearchClassItems(new HashSet<>(Arrays.asList(item)));
  }

  @Override
  protected void setMetaAttributes(CapellaSearchSettings searchSettings) {
    SearchForAttributeItem item = new SearchForAttributeItem();
    item.addAttribute(ModellingcorePackage.Literals.ABSTRACT_NAMED_ELEMENT__NAME);
    item.addAttribute(CapellacorePackage.Literals.CAPELLA_ELEMENT__SUMMARY);
    item.addAttribute(CapellacorePackage.Literals.CAPELLA_ELEMENT__DESCRIPTION);
    searchSettings.setSearchAttributeItems(new HashSet<>(Arrays.asList(item)));
  }

}
