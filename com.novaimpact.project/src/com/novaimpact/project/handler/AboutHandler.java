package com.novaimpact.project.handler;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

public class AboutHandler {
	@Execute
	public void execute(Shell shell) {
		MessageDialog.openInformation(shell, "About", 
				"Project (2017)\n"
				+ "experimental release\n"
				+ "Some icons by Yusuke Kamiyamane (http://p.yusukekamiyamane.com/). Licensed under a Creative Commons Attribution 3.0 License.");
	}
}
