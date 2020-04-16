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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.ui.search.CapellaReplaceQuery;
import org.polarsys.capella.core.ui.search.CapellaSearchMatchEntry;
import org.polarsys.capella.core.ui.search.CapellaSearchQuery;
import org.polarsys.capella.core.ui.search.CapellaSearchResult;
import org.polarsys.capella.core.ui.search.CapellaSearchSettings;
import org.polarsys.capella.core.ui.search.searchfor.SearchForItemCache;
import org.polarsys.capella.core.ui.search.searchfor.item.SearchForAttributeItem;
import org.polarsys.capella.core.ui.search.searchfor.item.SearchForClassItem;
import org.polarsys.capella.test.framework.api.BasicTestCase;

public class ReplaceTest extends BasicTestCase {
  private static final String SEARCH_TEXT_PATTERN = "Text_Pattern";
  private static final String REPLACE_TEXT_PATTERN = "Replace_Text_Pattern";

  @Override
  public void test() throws Exception {
    CapellaSearchSettings searchSettings = new CapellaSearchSettings();
    setBasicSearchSettings(searchSettings);
    CapellaSearchQuery searchQuery = new CapellaSearchQuery(searchSettings);
    searchQuery.run(new NullProgressMonitor());
    CapellaSearchResult searchResult = searchQuery.getSearchResult();
    Set<CapellaSearchMatchEntry> allMatches = searchResult.getDisplayedMatches();

    CapellaReplaceQuery replaceQuery = new CapellaReplaceQuery(searchSettings);
    IStatus status = replaceQuery.run(new NullProgressMonitor(), allMatches, REPLACE_TEXT_PATTERN);
    assertEquals(Status.OK_STATUS, status);
  }

  private void setBasicSearchSettings(CapellaSearchSettings searchSettings) {
    searchSettings.setCaseSensitive(false);
    searchSettings.setRegExSearch(false);
    searchSettings.setWholeWord(false);
    searchSettings.setTextPattern(SEARCH_TEXT_PATTERN);
    setMetaClassesAndAttributes(searchSettings);
  }

  private void setMetaClassesAndAttributes(CapellaSearchSettings searchSettings) {
    Set<Object> searchMetaClasses = SearchForItemCache.getInstance().getClassItems().stream()
        .filter(item -> CapellacorePackage.Literals.NAMED_ELEMENT.isSuperTypeOf((EClass) item.getObject()))
        .filter(SearchForClassItem.class::isInstance).map(SearchForClassItem.class::cast).collect(Collectors.toSet());
    Map<EAttribute, Integer> topAttributes;
    topAttributes = new HashMap<>();
    topAttributes.put(ModellingcorePackage.Literals.ABSTRACT_NAMED_ELEMENT__NAME, 0);
    topAttributes.put(CapellacorePackage.Literals.CAPELLA_ELEMENT__SUMMARY, 1);
    topAttributes.put(CapellacorePackage.Literals.CAPELLA_ELEMENT__DESCRIPTION, 2);
    Set<Object> searchAttributes = SearchForItemCache.getInstance().getAttributeItems().stream()
        .filter(SearchForAttributeItem.class::isInstance).map(SearchForAttributeItem.class::cast)
        .filter(item -> topAttributes.keySet().stream().anyMatch(item::represent)).collect(Collectors.toSet());

    searchSettings.setSearchClassItems(searchMetaClasses);
    searchSettings.setSearchAttributeItems(searchAttributes);
  }

}
