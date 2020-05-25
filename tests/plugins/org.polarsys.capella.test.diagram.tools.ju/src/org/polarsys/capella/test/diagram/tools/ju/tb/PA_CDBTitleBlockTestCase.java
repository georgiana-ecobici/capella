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

public class PA_CDBTitleBlockTestCase extends CDBTitleBlockTestCase {

  private static final String CLASS_ID = "1907b8ab-6058-4964-a53d-abbc86a9b6c0";
  private static final String DATA_ID = "b6a3203f-af0a-438c-beea-666327cf46df";
  private static final String BOOLEAN_ID = "3f5abbf2-54b5-487a-b9e5-cd1351389229";
  private static final String DIAGRAM_NAME = "[CDB] Data Physical";
  private static final String DATA_PKG = "56938bb5-311a-4f97-b9dc-28674e4b50cd";

  @Override
  public void initData() {
    elementsId.add(CLASS_ID);
    elementsId.add(DATA_ID);
    elementsId.add(BOOLEAN_ID);
    diagramName = DIAGRAM_NAME;
    dataPKG = DATA_PKG;
  }
}
