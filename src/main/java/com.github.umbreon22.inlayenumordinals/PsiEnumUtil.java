package com.github.umbreon22.inlayenumordinals;

import com.intellij.psi.*;

final class PsiEnumUtil {

	private PsiEnumUtil() {}

	private static final int NO_ORDINAL = -1;

	/**
	 * Retrieves an enum ordinal from a {@link PsiEnumConstant} instance
	 */
	static int ordinal(PsiEnumConstant psiEnumConstant) {
		PsiClass parentClass = psiEnumConstant.getContainingClass();
		if(parentClass != null) {
			PsiField[] fields = parentClass.getFields();
			for (int ordinal = 0; ordinal < fields.length; ordinal++) {
				if (fields[ordinal] == psiEnumConstant) {
					return ordinal;
				}
			}
		}
		return NO_ORDINAL;
	}

	/**
	 * Retrieves an enum ordinal from a {@link PsiElement} instance
	 */
	static int ordinal(PsiElement psiElement) {
		if(psiElement instanceof PsiEnumConstant) {
			return ordinal((PsiEnumConstant) psiElement);
		} else if(psiElement instanceof PsiReferenceExpression) {
			return ordinal(((PsiReferenceExpression) psiElement).resolve());
		} else {
			return NO_ORDINAL;
		}
	}

	/**
	 * Determines if the {@link PsiElement} represents an enum
	 */
	static boolean isEnum(PsiElement element) {
		return element instanceof PsiEnumConstant;
	}

	/**
	 * Determines if the {@link PsiElement} represents an enum reference
	 */
	static boolean isEnumReference(PsiElement element) {
		if(element instanceof PsiReferenceExpression) {
			PsiReferenceExpression expr = ((PsiReferenceExpression) element);
			PsiElement resolved = expr.resolve();
			return resolved instanceof PsiEnumConstant;
		} else {
			return false;
		}
	}
	/**
	 * Determines if the {@link PsiEnumConstant} has any arguments
	 */
	static boolean hasArguments(PsiEnumConstant constant) {
		PsiExpressionList argList = constant.getArgumentList();
		return argList == null || argList.isEmpty();
	}

}