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
package org.polarsys.capella.test.diagram.common.ju.step.tools.titleblocks;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.viewpoint.description.DAnnotation;
import org.polarsys.capella.core.diagram.helpers.TitleBlockHelper;
import org.polarsys.capella.core.sirius.analysis.DiagramServices;
import org.polarsys.capella.test.diagram.common.ju.context.DiagramContext;
import org.polarsys.capella.test.diagram.common.ju.step.tools.DeleteElementTool;

public class DeleteTitleBlockTool extends DeleteElementTool {
  List<DAnnotation> annotationsToDelete;
  
  public DeleteTitleBlockTool(DiagramContext context, DiagramContext containingToolDiagramContext, String toolName) {
    super(context, containingToolDiagramContext, toolName);
  }
  
  public void delete(DAnnotation titleBlock) {
    DDiagramElement titleBlockView = DiagramServices.getDiagramServices().getDiagramElement(getDiagramContext().getDiagram(),
        titleBlock);
    super.delete(titleBlockView);
    
    annotationsToDelete = TitleBlockHelper.getAllAnnotationsForTitleBlock(titleBlock);
  }

  @Override
  protected void postRunTest() {
    EList<DAnnotation> annotationsAfter = getDiagramContext().getDiagram().getEAnnotations();
    annotationsAfter.removeAll(annotationsAfter);
  }

}
