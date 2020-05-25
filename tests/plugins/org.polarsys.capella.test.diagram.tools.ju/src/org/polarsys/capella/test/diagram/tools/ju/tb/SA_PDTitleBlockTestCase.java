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

public class SA_PDTitleBlockTestCase extends PDTitleBlockTestCase {
  private static final String DATA_ID = "7da31f5f-5ce1-454e-916a-e8593af47236";
  private static final String DIAGRAM_NAME = "[PD] Interfaces System";
  private static final String INTERFACES_PKG = "07ee5900-7c31-4cb8-a391-cfa22b60c7a1";

  @Override
  protected void initData() {
    elementsId.add(DATA_ID);
    diagramName = DIAGRAM_NAME;
    interfacesPKG = INTERFACES_PKG;
  }

}
