/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.test.diagram.filters.ju.crb;

import java.util.ArrayList;
import java.util.List;

import org.polarsys.capella.test.framework.api.BasicTestArtefact;
import org.polarsys.capella.test.framework.api.BasicTestSuite;

public class CRBDiagramFiltersTestSuite extends BasicTestSuite {

  @Override
  protected List<BasicTestArtefact> getTests() {
    List<BasicTestArtefact> tests = new ArrayList<>();
    tests.add(new HideCapabilityRealizations());
    tests.add(new HideInvolvements());
    tests.add(new HideCapabilityExtends());
    tests.add(new HideCapabilityIncludes());
    tests.add(new HideCapabilityRealizationGeneralizations());
    tests.add(new HideComponents());
    tests.add(new HideActors());
    tests.add(new HideActorGeneralizations());
    tests.add(new HidePropertyValues());
    tests.add(new HideDiagramTitleBlocksForCRB());
    tests.add(new HideElementTitleBlocksForCRB());
    return tests;
  }
}
