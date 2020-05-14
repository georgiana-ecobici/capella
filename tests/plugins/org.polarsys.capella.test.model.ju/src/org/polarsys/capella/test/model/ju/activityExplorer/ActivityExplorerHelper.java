package org.polarsys.capella.test.model.ju.activityExplorer;

import java.util.Collection;

import org.eclipse.amalgam.explorer.activity.ui.internal.util.ActivityExplorerLoggerService;
import org.eclipse.amalgam.explorer.activity.ui.internal.viewer.diagram.actions.NewRepresentationAction;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

public class ActivityExplorerHelper {

  public static boolean createDiagram(final EObject project, final Session session, String diagramName) {
    final boolean flag[] = { true };

    if (project != null && session != null) {
      RecordingCommand cmd = new RecordingCommand(TransactionUtil.getEditingDomain(project)) {
        @Override
        protected void doExecute() {
          //
          EObject modelElement = project;
          RepresentationDescription diagramRepresentation = getDiagramRepresentation(session, modelElement,
              diagramName);

          NewRepresentationAction newDiagramAction = new NewRepresentationAction(diagramRepresentation,
                modelElement, session, true, true);
            newDiagramAction.run();

        }
      };
      TransactionUtil.getEditingDomain(project).getCommandStack().execute(cmd);
    } else {
      flag[0] = false;
    }

    return flag[0];
  }

  protected static RepresentationDescription getDiagramRepresentation(Session session, EObject modelElement,
      String diagramName) {
    try {
      // Get active viewpoints.
      Collection<Viewpoint> activeViewpoints = session.getSelectedViewpoints(false);
      Collection<RepresentationDescription> diagramDescriptions = DialectManager.INSTANCE
          .getAvailableRepresentationDescriptions(activeViewpoints, modelElement);
      // Loop over retrieved diagram descriptions to search one matching
      // search diagram name.
      for (RepresentationDescription diagramDescription : diagramDescriptions) {
        if (diagramName.equals(diagramDescription.getName())) {
          return diagramDescription;
        }
      }
    } catch (Throwable e) {
      StringBuilder message = new StringBuilder();

      message.append("AvstractNewDiagramHyperlinkAdapter.getDiagramRepresentation(..) _ "); //$NON-NLS-1$
      message
          .append("Could not retrieve a representation name from contribution. See the error stack for more details."); //$NON-NLS-1$

      ActivityExplorerLoggerService.getInstance().log(IStatus.ERROR, message.toString(), e);
    }

    return null;
  }


}

