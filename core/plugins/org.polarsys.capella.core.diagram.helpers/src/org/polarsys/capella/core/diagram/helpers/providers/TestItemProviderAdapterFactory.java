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
package org.polarsys.capella.core.diagram.helpers.providers;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.sirius.viewpoint.description.provider.DescriptionItemProviderAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class TestItemProviderAdapterFactory extends DescriptionItemProviderAdapterFactory {

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.DAnnotation}
   * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected TitleBlockItemProvider dAnnotationItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.DAnnotation}. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Adapter createDAnnotationAdapter() {
    if (dAnnotationItemProvider == null) {
      dAnnotationItemProvider = new TitleBlockItemProvider(this);
    }
    return dAnnotationItemProvider;
  }
}
