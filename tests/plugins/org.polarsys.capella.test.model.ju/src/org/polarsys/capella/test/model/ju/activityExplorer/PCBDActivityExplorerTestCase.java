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
import org.polarsys.capella.core.data.cs.ComponentPkg;
import org.polarsys.capella.core.explorer.activity.ui.hyperlinkadapter.pa.NewComponentBreakdownDiagramAdapter;
import org.polarsys.capella.core.sirius.analysis.IDiagramNameConstants;

public class PCBDActivityExplorerTestCase extends DiagramActivityExplorerTestCase {
  @Override
  public void initLink() {
    link = new MyNewComponentBreakdownDiagramAdapter();
  }

  @Override
  public boolean getResultOfCreateDiagram() {
    return ((MyNewComponentBreakdownDiagramAdapter) link).myCreateDiagram(structure, session);
  }

  @Override
  public ModelElement getTestModelElement() {
    return ((MyNewComponentBreakdownDiagramAdapter) link).getMyModelElement(project);
  }

  @Override
  public ComponentPkg getStructure() {
    return context.getSemanticElement(PA__PHYSICAL_CONTEXT);
  }

  @Override
  public String getDefaultName() {
    return "[PCBD] Structure";
  }

  @Override
  public String getDiagramName() {
    return IDiagramNameConstants.PHYSICAL_COMPONENT_BREAKDOWN_DIAGRAM_NAME;
  }

  class MyNewComponentBreakdownDiagramAdapter extends NewComponentBreakdownDiagramAdapter {

    public ModelElement getMyModelElement(EObject rootSemanticModel) {
      return getModelElement(rootSemanticModel);
    }

    public boolean myCreateDiagram(final EObject project, final Session session) {
      return ActivityExplorerHelper.createDiagram(project, session,
          IDiagramNameConstants.PHYSICAL_COMPONENT_BREAKDOWN_DIAGRAM_NAME);
    }
  }

}
