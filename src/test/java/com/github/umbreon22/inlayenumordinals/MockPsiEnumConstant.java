package com.github.umbreon22.inlayenumordinals;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.*;
import com.intellij.psi.javadoc.PsiDocComment;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MockPsiEnumConstant extends MockPsiElement implements PsiEnumConstant {

	private final PsiExpressionList expressionList;

	public MockPsiEnumConstant(PsiExpressionList expressionList) {
		this.expressionList = expressionList;
	}

	@Override
	public @Nullable PsiExpressionList getArgumentList() {
		return expressionList;
	}

	@Override
	public @Nullable PsiMethod resolveMethod() {
		return null;
	}

	@Override
	public @NotNull JavaResolveResult resolveMethodGenerics() {
		return null;
	}

	@Override
	public @Nullable PsiEnumConstantInitializer getInitializingClass() {
		return null;
	}

	@Override
	public @NotNull PsiEnumConstantInitializer getOrCreateInitializingClass() {
		return null;
	}

	@Override
	public void setInitializer(@Nullable PsiExpression initializer) throws IncorrectOperationException {

	}

	@Override
	public void normalizeDeclaration() throws IncorrectOperationException {

	}

	@Override
	public @Nullable Object computeConstantValue() {
		return null;
	}

	@Override
	public @NotNull PsiIdentifier getNameIdentifier() {
		return null;
	}

	@Override
	public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
		return null;
	}

	@Override
	public @NotNull PsiType getType() {
		return null;
	}

	@Override
	public @Nullable PsiTypeElement getTypeElement() {
		return null;
	}

	@Override
	public @Nullable PsiExpression getInitializer() {
		return null;
	}

	@Override
	public boolean hasInitializer() {
		return false;
	}

	@Override
	public @NotNull String getName() {
		return null;
	}

	@Override
	public @Nullable ItemPresentation getPresentation() {
		return null;
	}

	@Override
	public boolean isDeprecated() {
		return false;
	}

	@Override
	public @Nullable PsiClass getContainingClass() {
		return null;
	}

	@Override
	public void navigate(boolean requestFocus) {

	}

	@Override
	public boolean canNavigate() {
		return false;
	}

	@Override
	public boolean canNavigateToSource() {
		return false;
	}

	@Override
	public @Nullable PsiMethod resolveConstructor() {
		return null;
	}

	@Override
	public @Nullable PsiDocComment getDocComment() {
		return null;
	}

	@Override
	public @Nullable PsiModifierList getModifierList() {
		return null;
	}

	@Override
	public boolean hasModifierProperty(@NotNull String name) {
		return false;
	}
}
