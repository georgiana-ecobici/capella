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
package org.polarsys.capella.test.search.testsuites;

import java.util.ArrayList;
import java.util.List;

import org.polarsys.capella.test.framework.api.BasicTestArtefact;
import org.polarsys.capella.test.framework.api.BasicTestSuite;
import org.polarsys.capella.test.search.tests.ReplaceTest;
import org.polarsys.capella.test.search.tests.SearchTestAttributeRequired;
import org.polarsys.capella.test.search.tests.SearchTestCaseSensitiveTrue;
import org.polarsys.capella.test.search.tests.SearchTestCheckBoxesFalse;
import org.polarsys.capella.test.search.tests.SearchTestCorrectMetaClassSelected;
import org.polarsys.capella.test.search.tests.SearchTestIncorrectAttributeSelected;
import org.polarsys.capella.test.search.tests.SearchTestIncorrectMetaClassSelected;
import org.polarsys.capella.test.search.tests.SearchTestMetaClassRequired;
import org.polarsys.capella.test.search.tests.SearchTestRegExTrue;
import org.polarsys.capella.test.search.tests.SearchTestRegExWholeWordNotAllowedSimultaneously;
import org.polarsys.capella.test.search.tests.SearchTestTextPatternNotFound;
import org.polarsys.capella.test.search.tests.SearchTestWholeWordTrue;

import junit.framework.Test;

public class SearchTestSuite extends BasicTestSuite {

  public static Test suite() {
    return new SearchTestSuite();
  }

  @Override
  public List<String> getRequiredTestModels() {
    return null;
  }

  @Override
  protected List<BasicTestArtefact> getTests() {
    List<BasicTestArtefact> testSuite = new ArrayList<>();

    testSuite.add(new SearchTestCheckBoxesFalse());
    testSuite.add(new SearchTestCaseSensitiveTrue());
    testSuite.add(new SearchTestRegExTrue());
    testSuite.add(new SearchTestWholeWordTrue());
    testSuite.add(new SearchTestRegExWholeWordNotAllowedSimultaneously());
    testSuite.add(new SearchTestMetaClassRequired());
    testSuite.add(new SearchTestAttributeRequired());
    testSuite.add(new SearchTestCorrectMetaClassSelected());
    testSuite.add(new SearchTestIncorrectMetaClassSelected());
    testSuite.add(new SearchTestIncorrectAttributeSelected());
    testSuite.add(new SearchTestTextPatternNotFound());
    testSuite.add(new ReplaceTest());

    return testSuite;
  }

}
