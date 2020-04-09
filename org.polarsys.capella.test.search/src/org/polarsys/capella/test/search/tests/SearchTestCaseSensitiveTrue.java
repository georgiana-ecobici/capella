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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.common.data.modellingcore.ModellingcorePackage;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.ui.search.CapellaSearchQuery;
import org.polarsys.capella.core.ui.search.CapellaSearchResult;
import org.polarsys.capella.core.ui.search.CapellaSearchSettings;
import org.polarsys.capella.core.ui.search.searchfor.SearchForItemCache;
import org.polarsys.capella.core.ui.search.searchfor.item.SearchForAttributeItem;
import org.polarsys.capella.core.ui.search.searchfor.item.SearchForClassItem;
import org.polarsys.capella.test.framework.api.BasicTestCase;

public class SearchTestCaseSensitiveTrue extends BasicTestCase {
  private static final String PROJECT_TEST_NAME = "SearchAndReplaceTests";
  private static final String TEXT_PATTERN = "Text_Pattern";

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(PROJECT_TEST_NAME);
  }

  @Override
  public void test() throws Exception {
    CapellaSearchSettings searchSettings = new CapellaSearchSettings();
    setBasicSearchSettings(searchSettings);
    searchSettings.validate();
    CapellaSearchQuery searchQuery = new CapellaSearchQuery(searchSettings);
    IStatus status = searchQuery.run(new NullProgressMonitor());
    assertEquals(Status.OK_STATUS, status);
    testResultFound(searchQuery);
  }

  private void setBasicSearchSettings(CapellaSearchSettings searchSettings) {
    getSessionForTestModel(PROJECT_TEST_NAME);
    searchSettings.setCaseSensitive(true);
    searchSettings.setRegExSearch(false);
    searchSettings.setWholeWord(false);
    searchSettings.setTextPattern(TEXT_PATTERN);
    searchSettings.addObjectToSearch(getProjectsFromWorkspace());
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

  private void testResultFound(CapellaSearchQuery searchQuery) {
    CapellaSearchResult searchResult = searchQuery.getSearchResult();
    Object[] matches = searchResult.getElements();
    assertTrue(matches.length == 1);
  }

  private IProject getProjectsFromWorkspace() {
    IProject[] projectsToCheck = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    return projectsToCheck[0];
  }

}
