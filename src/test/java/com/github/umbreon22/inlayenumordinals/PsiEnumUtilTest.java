package com.github.umbreon22.inlayenumordinals;


import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiEnumConstant;
import com.intellij.psi.PsiExpression;
import org.junit.jupiter.api.Test;

import static com.github.umbreon22.inlayenumordinals.PsiEnumUtil.hasArguments;
import static com.github.umbreon22.inlayenumordinals.PsiEnumUtil.isEnum;
import static com.github.umbreon22.inlayenumordinals.PsiEnumUtil.isEnumReference;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PsiEnumUtilTest {

	@Test()
	public void testIsEnum() {
		PsiElement element;

		element = new MockPsiElement();
		assertFalse(isEnum(element));

		element = new MockPsiReferenceExpression(null);
		assertFalse(isEnum(element));

		element = new MockPsiReferenceExpression(new MockPsiElement());
		assertFalse(isEnum(element));

		element = new MockPsiReferenceExpression(new MockPsiEnumConstant(null));
		assertFalse(isEnum(element));

		element = new MockPsiEnumConstant(new MockPsiExpressionList(new PsiExpression[0]));
		assertFalse(isEnum(new MockPsiReferenceExpression(element)));

		assertFalse(isEnum(null));

		element = new MockPsiEnumConstant(null);
		assertTrue(isEnum(element));

		element = new MockPsiEnumConstant(new MockPsiExpressionList(new PsiExpression[0]));
		assertTrue(isEnum(element));
	}

	@Test()
	public void testIsEnumReference() {
		PsiElement element;

		element = new MockPsiElement();
		assertFalse(isEnumReference(element));

		element = new MockPsiReferenceExpression(null);
		assertFalse(isEnumReference(element));

		element = new MockPsiReferenceExpression(new MockPsiElement());
		assertFalse(isEnumReference(element));

		assertFalse(isEnumReference(null));

		element = new MockPsiReferenceExpression(new MockPsiEnumConstant(null));
		assertTrue(isEnumReference(element));

		element = new MockPsiReferenceExpression(new MockPsiEnumConstant(new MockPsiExpressionList(new PsiExpression[0])));
		assertTrue(isEnumReference(element));
	}

	@Test()
	public void testHasArguments() {
		PsiEnumConstant constant;

		constant = new MockPsiEnumConstant(null);
		assertFalse(hasArguments(constant));
		
		constant = new MockPsiEnumConstant(new MockPsiExpressionList(new PsiExpression[0]));
		assertFalse(hasArguments(constant));

		constant = new MockPsiEnumConstant(new MockPsiExpressionList(new PsiExpression[1]));
		assertTrue(hasArguments(constant));
	}


}
