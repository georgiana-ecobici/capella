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
package org.polarsys.capella.test.diagram.tools.ju.tb;

import org.polarsys.capella.core.model.helpers.BlockArchitectureExt;
import org.polarsys.capella.test.diagram.common.ju.context.CommonDiagram;
import org.polarsys.capella.test.diagram.common.ju.context.XDFBDiagram;

public abstract class XDFBTitleBlockTestCase extends AbstractTitleBlockTestCase {
  protected String diagramName;
  protected BlockArchitectureExt.Type type;

  public XDFBTitleBlockTestCase() {
    initData();
  }

  @Override
  protected CommonDiagram initDiagram() {
    return XDFBDiagram.openDiagram(context, diagramName, type);
  }

  protected abstract void initData();

}
