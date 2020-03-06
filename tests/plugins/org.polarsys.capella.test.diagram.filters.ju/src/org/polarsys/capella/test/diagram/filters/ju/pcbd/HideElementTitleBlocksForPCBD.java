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
package org.polarsys.capella.test.diagram.filters.ju.pcbd;

import java.util.Arrays;
import java.util.List;

import org.polarsys.capella.core.sirius.analysis.constants.IFilterNameConstants;
import org.polarsys.capella.test.diagram.filters.ju.DiagramTitleBlockFilterTestCase;

public class HideElementTitleBlocksForPCBD extends DiagramTitleBlockFilterTestCase {

  private final String ELEMENT_TITLE_BLOCK_PC1_ID = "_YttAwJQdEeqmRd48Y6X5KA";
  private final String ELEMENT_TITLE_BLOCK_PC2_ID = "_ZMAGUJQdEeqmRd48Y6X5KA";
  private final String ELEMENT_TITLE_BLOCK_PHYSICAL_ACTOR_ID = "_bD2_0JQdEeqmRd48Y6X5KA";

  @Override
  protected String getFilterName() {
    return IFilterNameConstants.FILTER_COMMON_HIDE_ELEMENT_TITLE_BLOCKS;
  }

  @Override
  protected List<String> getFilteredObjetIDs() {
    return Arrays.asList(new String[] { ELEMENT_TITLE_BLOCK_PC1_ID,
        ELEMENT_TITLE_BLOCK_PC2_ID, ELEMENT_TITLE_BLOCK_PHYSICAL_ACTOR_ID});
  }
  
  @Override
  protected String getDiagramName() {
    return "[PCBD] Physical System Title Blocks";
  }
}
