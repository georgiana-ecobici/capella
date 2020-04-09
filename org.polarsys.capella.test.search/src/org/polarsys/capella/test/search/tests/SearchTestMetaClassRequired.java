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
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.polarsys.capella.core.ui.search.CapellaSearchSettings;
import org.polarsys.capella.test.framework.api.BasicTestCase;

public class SearchTestMetaClassRequired extends BasicTestCase {
  private static final String PROJECT_TEST_NAME = "SearchAndReplaceTests";
  private static final String TEXT_PATTERN = "Text_Pattern";
  private static final String AT_LEAST_ONE_METACLASS_STATUS_MESSAGE = "At least one metaclass must be selected";

  @Override
  public List<String> getRequiredTestModels() {
    return Arrays.asList(PROJECT_TEST_NAME);
  }

  @Override
  public void test() throws Exception {
    CapellaSearchSettings searchSettings = new CapellaSearchSettings();
    setBasicSearchSettings(searchSettings);
    Set<Object> emptySet = new HashSet<Object>();
    searchSettings.setSearchClassItems(emptySet);
    searchSettings.setSearchAttributeItems(emptySet);
    assertEquals(AT_LEAST_ONE_METACLASS_STATUS_MESSAGE, searchSettings.validate().getMessage());
  }

  private void setBasicSearchSettings(CapellaSearchSettings searchSettings) {
    getSessionForTestModel(PROJECT_TEST_NAME);
    searchSettings.setCaseSensitive(false);
    searchSettings.setRegExSearch(false);
    searchSettings.setWholeWord(false);
    searchSettings.setTextPattern(TEXT_PATTERN);
    searchSettings.addObjectToSearch(getProjectsFromWorkspace());
  }

  private IProject getProjectsFromWorkspace() {
    IProject[] projectsToCheck = ResourcesPlugin.getWorkspace().getRoot().getProjects();
    return projectsToCheck[0];
  }

}
