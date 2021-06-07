package com.github.umbreon22.inlayenumordinals.settings.ui;

import javax.swing.*;

/**
 * @author Arnah
 * @since Jun 06, 2021
 **/
public class EnumOrdinalSettingsForm {

	private JCheckBox hideHintIfArgumentsCheckBox;
	private JPanel panel;

	public JPanel getPanel() {
		return panel;
	}

	public boolean getHideHintIfArguments() {
		return hideHintIfArgumentsCheckBox.isSelected();
	}

	public void setHideHintIfArguments(boolean hideHintIfArguments) {
		hideHintIfArgumentsCheckBox.setSelected(hideHintIfArguments);
	}

	public JComponent getPreferredFocusedComponent() {
		return hideHintIfArgumentsCheckBox;
	}
}
