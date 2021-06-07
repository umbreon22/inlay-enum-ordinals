package com.github.umbreon22.inlayenumordinals;

import com.github.umbreon22.inlayenumordinals.settings.EnumOrdinalSettingsState;
import com.intellij.codeInsight.hints.FactoryInlayHintsCollector;
import com.intellij.codeInsight.hints.InlayHintsSink;
import com.intellij.codeInsight.hints.presentation.InlayPresentation;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class EnumOrdinalHintCollector extends FactoryInlayHintsCollector {

	private final EnumOrdinalSettingsState settings;

	public EnumOrdinalHintCollector(@NotNull Editor editor, EnumOrdinalSettingsState settings) {
		super(editor);
		this.settings = settings;
	}

	@Override
	public boolean collect(@NotNull PsiElement element, @NotNull Editor editor, @NotNull InlayHintsSink inlayHintsSink) {
		if(element instanceof PsiJavaFile) {
			PsiJavaFile file = (PsiJavaFile) element;
			List<PsiElement> elements = collectEnumElements(file, settings.getHideHintIfArguments());
			elements.forEach(elem -> addOrdinalHint(elem, inlayHintsSink));
		}
		return true;
	}

	private static List<PsiElement> collectEnumElements(PsiJavaFile file, boolean hideHintIfArguments) {
		List<PsiElement> elements = new LinkedList<>();
		PsiTreeUtil.processElements(file, element -> {
			if(PsiEnumUtil.isEnum(element, hideHintIfArguments)) {
				elements.add(element);
			}
			return true;
		});
		return elements;
	}

	private void addOrdinalHint(PsiElement element, InlayHintsSink sink) {
		int ordinal = PsiEnumUtil.ordinal(element);
		InlayPresentation ordinalText = getFactory().text(Integer.toString(ordinal));
		InlayPresentation roundOrdinalText = getFactory().roundWithBackground(ordinalText);
		sink.addInlineElement(
			element.getTextRange().getEndOffset(), true, roundOrdinalText
		);
	}

}
