package com.github.umbreon22.inlayenumordinals.settings;


import com.github.umbreon22.inlayenumordinals.settings.ui.EnumOrdinalSettingsForm;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class EnumOrdinalConfigurable implements SearchableConfigurable {

	private EnumOrdinalSettingsForm settingsPane;

	@Override
	public @NotNull String getId() {
		return "com.github.umbreon22.inlayenumordinals.settings.EnumOrdinalConfigurable";
	}

	@Nls(capitalization = Nls.Capitalization.Title)
	@Override
	public String getDisplayName() {
		return "InlayEnumOrdinals";
	}

	@Override
	public JComponent getPreferredFocusedComponent() {
		return settingsPane.getPreferredFocusedComponent();
	}

	@Override
	public @Nullable JComponent createComponent() {
		if(settingsPane == null){
			settingsPane = new EnumOrdinalSettingsForm();
		}
		return settingsPane.getPanel();
	}

	@Override
	public boolean isModified() {
		EnumOrdinalSettingsState settings = EnumOrdinalSettingsState.getInstance();
		return settingsPane != null && settingsPane.getHideHintIfArguments() != settings.getHideHintIfArguments();
	}

	@Override
	public void apply() {
		EnumOrdinalSettingsState settings = EnumOrdinalSettingsState.getInstance();
		settings.setHideHintIfArguments(settingsPane.getHideHintIfArguments());
	}

	@Override
	public void reset() {
		EnumOrdinalSettingsState settings = EnumOrdinalSettingsState.getInstance();
		settingsPane.setHideHintIfArguments(settings.getHideHintIfArguments());
	}

	@Override
	public void disposeUIResources() {
		settingsPane = null;
	}
}