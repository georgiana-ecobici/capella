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
package org.polarsys.capella.test.diagram.filters.ju.cdb;

import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.core.sirius.analysis.constants.IFilterNameConstants;
import org.polarsys.capella.test.diagram.filters.ju.DiagramTitleBlockFilterTestCase;

public class HideDiagramTitleBocksTest extends DiagramTitleBlockFilterTestCase {

  private final String DIAGRAM_TITLE_BLOCK_ID = "_8t01EIXwEeqWaJq2mNMsRw";
  
  @Override
  protected String getFilterName() {
    return IFilterNameConstants.FILTER_CDB_HIDE_DIAGRAM_TITLE_BLOCKS;
  }

  @Override
  protected List<String> getFilteredObjetIDs() {
    return Arrays.asList(new String[] { DIAGRAM_TITLE_BLOCK_ID });
  }
}