package com.github.umbreon22.inlayenumordinals;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.JavaResolveResult;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiExpression;
import com.intellij.psi.PsiReferenceExpression;
import com.intellij.psi.PsiReferenceParameterList;
import com.intellij.psi.PsiType;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MockPsiReferenceExpression extends MockPsiElement implements PsiReferenceExpression {

	private final PsiElement resolve;

	public MockPsiReferenceExpression(PsiElement resolve) {
		this.resolve = resolve;
	}

	@Override
	public @Nullable PsiExpression getQualifierExpression() {
		return null;
	}

	@Override
	public PsiElement bindToElementViaStaticImport(@NotNull PsiClass qualifierClass) throws IncorrectOperationException {
		return null;
	}

	@Override
	public void setQualifierExpression(@Nullable PsiExpression newQualifier) throws IncorrectOperationException {

	}

	@Override
	public @Nullable PsiType getType() {
		return null;
	}

	@Override
	public @Nullable PsiElement getReferenceNameElement() {
		return null;
	}

	@Override
	public @Nullable PsiReferenceParameterList getParameterList() {
		return null;
	}

	@Override
	public PsiType @NotNull [] getTypeParameters() {
		return new PsiType[0];
	}

	@Override
	public boolean isQualified() {
		return false;
	}

	@Override
	public String getQualifiedName() {
		return null;
	}

	@Override
	public void processVariants(@NotNull PsiScopeProcessor processor) {

	}

	@Override
	public @NotNull JavaResolveResult advancedResolve(boolean incompleteCode) {
		return null;
	}

	@Override
	public JavaResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
		return new JavaResolveResult[0];
	}

	@Override
	public @Nullable PsiElement getQualifier() {
		return null;
	}

	@Override
	public @Nullable String getReferenceName() {
		return null;
	}

	@Override
	public @NotNull PsiElement getElement() {
		return null;
	}

	@Override
	public @NotNull TextRange getRangeInElement() {
		return null;
	}

	@Override
	public @Nullable PsiElement resolve() {
		return resolve;
	}

	@Override
	public @NotNull String getCanonicalText() {
		return null;
	}

	@Override
	public PsiElement handleElementRename(@NotNull String newElementName) throws IncorrectOperationException {
		return null;
	}

	@Override
	public PsiElement bindToElement(@NotNull PsiElement element) throws IncorrectOperationException {
		return null;
	}

	@Override
	public boolean isReferenceTo(@NotNull PsiElement element) {
		return false;
	}

	@Override
	public boolean isSoft() {
		return false;
	}
}
