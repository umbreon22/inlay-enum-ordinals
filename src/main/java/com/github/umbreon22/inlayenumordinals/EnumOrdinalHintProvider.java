package com.github.umbreon22.inlayenumordinals;

import com.github.umbreon22.inlayenumordinals.settings.EnumOrdinalSettingsState;
import com.intellij.codeInsight.hints.ImmediateConfigurable;
import com.intellij.codeInsight.hints.InlayHintsCollector;
import com.intellij.codeInsight.hints.InlayHintsProvider;
import com.intellij.codeInsight.hints.InlayHintsSink;
import com.intellij.codeInsight.hints.SettingsKey;
import com.intellij.lang.Language;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;


public class EnumOrdinalHintProvider implements InlayHintsProvider<EnumOrdinalSettingsState> {

	private static final String NAME = "Inlay enum ordinals";
	private static final String PREVIEW_TEXT = "Enum ordinals, inlay for the inLAY-Z.";
	private static final SettingsKey<EnumOrdinalSettingsState> SETTINGS_KEY = new SettingsKey<>("com.github.umbreon22.inlay-enum-ordinals");

	@Nullable
	@Override
	public InlayHintsCollector getCollectorFor(@NotNull PsiFile psiFile, @NotNull Editor editor, @NotNull EnumOrdinalSettingsState settings, @NotNull InlayHintsSink inlayHintsSink) {
		return new EnumOrdinalHintCollector(editor, settings);
	}

	@NotNull
	@Override
	public EnumOrdinalSettingsState createSettings() {
		return EnumOrdinalSettingsState.getInstance();
	}

	@Nls(capitalization = Nls.Capitalization.Sentence)
	@NotNull
	@Override
	public String getName() {
		return NAME;
	}

	@NotNull
	@Override
	public SettingsKey<EnumOrdinalSettingsState> getKey() {
		return SETTINGS_KEY;
	}

	@Nullable
	@Override
	public String getPreviewText() {
		return PREVIEW_TEXT;
	}

	@NotNull
	@Override
	public ImmediateConfigurable createConfigurable(@NotNull EnumOrdinalSettingsState settings) {
		return changeListener -> new JPanel();
	}

	@Override
	public boolean isLanguageSupported(@NotNull Language language) {
		return JavaLanguage.INSTANCE.is(language);
	}

	@Override
	public boolean isVisibleInSettings() {
		return false;
	}
}
