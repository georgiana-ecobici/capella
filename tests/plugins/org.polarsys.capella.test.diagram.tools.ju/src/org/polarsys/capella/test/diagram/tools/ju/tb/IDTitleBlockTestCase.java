/*******************************************************************************
 * Copyright (c) 2020 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.test.diagram.tools.ju.tb;

import org.polarsys.capella.test.diagram.common.ju.context.CommonDiagram;
import org.polarsys.capella.test.diagram.common.ju.context.IDDiagram;

public abstract class IDTitleBlockTestCase extends AbstractTitleBlockTestCase {
  protected String diagramName;
  protected String interfaceID;

  public IDTitleBlockTestCase() {
    initData();
  }

  @Override
  protected CommonDiagram initDiagram() {
    return IDDiagram.openDiagram(context, diagramName);
  }

  @Override
  protected CommonDiagram createDiagram() {
    return IDDiagram.createDiagram(context, interfaceID);
  }

  protected abstract void initData();
}
