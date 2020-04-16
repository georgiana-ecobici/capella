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
package org.polarsys.capella.test.search.activator;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class SearchTestActivator extends Plugin {
  public static final String PLUGIN_ID = "org.polarsys.capella.test.search";
  private static SearchTestActivator plugin;

  public static SearchTestActivator getDefault() {
    return plugin;
  }

  @Override
  public void start(BundleContext bundleContext) throws Exception {
    super.start(bundleContext);
    plugin = this;
  }

  @Override
  public void stop(BundleContext bundleContext) throws Exception {
    plugin = null;
    super.stop(bundleContext);
  }

}
