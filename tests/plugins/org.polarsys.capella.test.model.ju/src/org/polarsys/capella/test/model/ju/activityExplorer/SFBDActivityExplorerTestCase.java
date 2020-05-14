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
package org.polarsys.capella.test.model.ju.activityExplorer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.session.Session;
import org.polarsys.capella.common.data.modellingcore.ModelElement;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.sa.NewFunctionalBreakdownDiagramAdapter;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;

public class SFBDActivityExplorerTestCase extends FunctionalDiagramActivityExplorerTestCase {

  @Override
  public void initLink() {
    link = new MyNewFunctionalBreakdownDiagramAdapter();
  }

  @Override
  public boolean getResultOfCreateDiagram() {
    return ((MyNewFunctionalBreakdownDiagramAdapter) link).myCreateDiagram(structure, session);
  }

  @Override
  public ModelElement getTestModelElement() {
    return ((MyNewFunctionalBreakdownDiagramAdapter) link).getMyModelElement(project);
  }

  @Override
  public AbstractFunction getStructure() {
    return context.getSemanticElement(SA__ROOT_SF);
  }

  @Override
  public String getDefaultName() {
    return "[SFBD] Root System Function";
  }

  @Override
  public String getDiagramName() {
    return IDiagramNameConstants.SYSTEM_FUNCTION_BREAKDOWN_DIAGRAM_NAME;
  }

  class MyNewFunctionalBreakdownDiagramAdapter extends NewFunctionalBreakdownDiagramAdapter {

    public ModelElement getMyModelElement(EObject rootSemanticModel) {
      return getModelElement(rootSemanticModel);
    }

    public boolean myCreateDiagram(final EObject project, final Session session) {
      return ActivityExplorerHelper.createDiagram(project, session,
          IDiagramNameConstants.SYSTEM_FUNCTION_BREAKDOWN_DIAGRAM_NAME);
    }
  }

}
