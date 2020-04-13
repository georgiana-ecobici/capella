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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.core.data.capellacore.CapellacorePackage;
import org.polarsys.capella.core.ui.search.CapellaSearchQuery;
import org.polarsys.capella.core.ui.search.CapellaSearchSettings;
import org.polarsys.capella.core.ui.search.searchfor.SearchForItemCache;
import org.polarsys.capella.core.ui.search.searchfor.item.SearchForClassItem;
import org.polarsys.capella.test.framework.api.BasicTestCase;

public abstract class AbstractSearchAndReplaceTestCase extends BasicTestCase {
  private static final String PROJECT_TEST_NAME = "SearchAndReplaceTests";
  protected static final String AT_LEAST_ONE_ATTRIBUTE_STATUS_MESSAGE = "At least one attribute must be selected";

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(PROJECT_TEST_NAME);
  }

  @Override
  public void test() throws Exception {
    CapellaSearchSettings searchSettings = initSettings();
    searchSettings.validate();

    CapellaSearchQuery searchQuery = performSearch(searchSettings);

    performChecks(searchQuery);
  }

  protected abstract CapellaSearchSettings initSettings();

  protected CapellaSearchQuery performSearch(CapellaSearchSettings searchSettings) {
    CapellaSearchQuery searchQuery = new CapellaSearchQuery(searchSettings);
    IStatus status = searchQuery.run(new NullProgressMonitor());
    assertEquals(Status.OK_STATUS, status);
    performChecks(searchQuery);
    return searchQuery;
  }

  protected abstract void performChecks(CapellaSearchQuery searchQuery);

  protected void setBasicSearchSettings(CapellaSearchSettings searchSettings, boolean isCaseSensitive, boolean isRegex,
      boolean isWholeWord, String textPattern) {
    getSessionForTestModel(PROJECT_TEST_NAME);
    searchSettings.setCaseSensitive(isCaseSensitive);
    searchSettings.setRegExSearch(isRegex);
    searchSettings.setWholeWord(isWholeWord);
    searchSettings.setTextPattern(textPattern);
    searchSettings.addObjectToSearch(getProjectsFromWorkspace());
    setMetaClasses(searchSettings);
    setMetaAttributes(searchSettings);
  }

  protected Set<Object> getDefaultMetaClasses(CapellaSearchSettings settings) {
    Set<Object> namedElementClasses = SearchForItemCache.getInstance().getClassItems().stream()
        .filter(SearchForClassItem.class::isInstance).map(SearchForClassItem.class::cast)
        .filter(item -> CapellacorePackage.Literals.NAMED_ELEMENT.isSuperTypeOf((EClass) item.getObject()))
        .collect(Collectors.toSet());
    return namedElementClasses;
  }

  /*
   * set the default meta-classes
   */
  protected void setMetaClasses(CapellaSearchSettings searchSettings) {
    Set<Object> defaultMetaClasses = getDefaultMetaClasses(searchSettings);
    searchSettings.setSearchClassItems(defaultMetaClasses);
  }

  protected abstract void setMetaAttributes(CapellaSearchSettings searchSettings);

  protected IProject getProjectsFromWorkspace() {
    IProject[] projectsToCheck = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    return projectsToCheck[0];
  }
}
