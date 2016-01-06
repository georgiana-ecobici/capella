/*******************************************************************************
 * Copyright (c) 2006, 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.core.ui.metric;

import org.eclipse.osgi.util.NLS;

/**
 * Messages for the metric plugin.
 */
public class MetricMessages extends NLS {
	private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$
	
	// Action
	public static String progressMonitorMsg;
	public static String metricAction_lbl;

	// Dialog
	public static String metricDialogShellTitle;
	public static String metricDialogDefaultTitle;
	public static String metricDialogTitleFromEObj;
	public static String metricDialogTitleFromFile;

	public static String treeObjectColumnLabel;
	public static String treeResultColumnLabel;

	public static String layer;

	//
	// Progress Monitoring
	//
	public static String progressMonitoring_menu_lbl;
	public static String progressMonitoring_setAction_lbl;
	public static String progressMonitoring_overviewAction_lbl;

	public static String progressMonitoring_setAction_dialog_title;
	public static String progressMonitoring_setAction_dialog_main_lbl;
	public static String progressMonitoring_setAction_dialog_clear_lbl;
	public static String progressMonitoring_setAction_dialog_combo_lbl;
	public static String progressMonitoring_setAction_cmd_lbl;
	public static String progressMonitoring_setAction_nochanges_info;
	public static String progressMonitoring_setAction_changes_info;

	public static String progressMonitoring_dialog_title;
	public static String progressMonitoring_dialog_msg;

	public static String progressMonitoring_dialog_combo_lbl;
	public static String progressMonitoring_dialog_combo_allStatus;

	public static String progressMonitoring_dialog_header_col0;
	public static String progressMonitoring_dialog_header_col1;
	public static String progressMonitoring_dialog_header_col2;

	public static String progressMonitoring_dialog_propagate_button_lbl;
	public static String progressMonitoring_dialog_propagate_button_tooltip;

	public static String progressMonitoring_dialog_propagate_to_representation_button_lbl;
	public static String progressMonitoring_dialog_propagate_to_representation_button_tooltip;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, MetricMessages.class);
	}

	/**
	 * Constructor.
	 */
	private MetricMessages() {
		// Do nothing.
	}
}
