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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.polarsys.capella.core.ui.search.CapellaSearchQuery;
import org.polarsys.capella.core.ui.search.CapellaSearchSettings;

public class SearchTestRegExWholeWordNotAllowedSimultaneously extends AbstractSearchAndReplaceTestCase {
  private static final String TEXT_PATTERN = "Text_Pattern";
  private static final String WHOLE_WORD_UNSUPPORTED_WITH_REGEX_STATUS_MESSAGE = "assertion failed: isWholeWord unsupported together with isRegex";

  @Override
  protected CapellaSearchSettings initSettings() {
    CapellaSearchSettings searchSettings = new CapellaSearchSettings();
    setBasicSearchSettings(searchSettings, false, true, true, TEXT_PATTERN);
    return searchSettings;
  }

  @Override
  public void test() throws Exception {
    CapellaSearchSettings searchSettings = initSettings();
    CapellaSearchQuery searchQuery = new CapellaSearchQuery(searchSettings);
    IStatus status = searchQuery.run(new NullProgressMonitor());
    assertEquals(WHOLE_WORD_UNSUPPORTED_WITH_REGEX_STATUS_MESSAGE, status.getMessage());
  }

  @Override
  protected void performChecks(CapellaSearchQuery searchQuery) {
    // TODO Auto-generated method stub
  }

  @Override
  protected void setMetaAttributes(CapellaSearchSettings searchSettings) {
    // TODO Auto-generated method stub
  }

}
