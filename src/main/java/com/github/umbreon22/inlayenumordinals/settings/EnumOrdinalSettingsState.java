package com.github.umbreon22.inlayenumordinals.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


@State(
		name = "EnumOrdinalSettings",
		storages = {
				@Storage("/EnumOrdinalSettingsPlugin.xml")
		}
)
public class EnumOrdinalSettingsState implements PersistentStateComponent<EnumOrdinalSettingsState> {

	private boolean hideHintIfArguments;

	public static EnumOrdinalSettingsState getInstance() {
		return ServiceManager.getService(EnumOrdinalSettingsState.class);
	}

	@Override
	@Nullable
	public EnumOrdinalSettingsState getState() {
		return this;
	}

	@Override
	public void loadState(@NotNull EnumOrdinalSettingsState state) {
		XmlSerializerUtil.copyBean(state, this);
	}

	public boolean getHideHintIfArguments() {
		return hideHintIfArguments;
	}

	public void setHideHintIfArguments(boolean hideHintIfArguments) {
		this.hideHintIfArguments = hideHintIfArguments;
	}
}