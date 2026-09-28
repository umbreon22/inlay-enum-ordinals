package com.github.umbreon22.inlayenumordinals;

import com.github.umbreon22.inlayenumordinals.settings.EnumOrdinalSettingsState;
import com.intellij.testFramework.utils.inlays.InlayHintsProviderTestCase;

/**
 * Runs {@link EnumOrdinalHintProvider} on real Java PSI. The expected texts mark each inlay hint
 * with an inline comment holding the hint's text, placed at the hint's offset.
 */
public class EnumOrdinalHintProviderTest extends InlayHintsProviderTestCase {

	public void testEnumConstantsAndReferences() {
		doTestProvider("Usage.java", """
				enum Color {
				    RED/*<# 0 #>*/, GREEN/*<# 1 #>*/, BLUE/*<# 2 #>*/
				}

				class Usage {
				    Color favourite = Color.BLUE/*<# 2 #>*/;

				    int code(Color color) {
				        switch (color) {
				            case GREEN/*<# 1 #>*/: return 1;
				            default: return 0;
				        }
				    }
				}
				""", new EnumOrdinalHintProvider(), settings(false));
	}

	public void testEnumConstantsWithArguments() {
		doTestProvider("Planet.java", """
				enum Planet {
				    MERCURY(3.303e+23)/*<# 0 #>*/, VENUS(4.869e+24)/*<# 1 #>*/, PLUTO/*<# 2 #>*/;

				    Planet(double mass) {}
				    Planet() {}
				}
				""", new EnumOrdinalHintProvider(), settings(false));
	}

	public void testHideHintIfArguments() {
		doTestProvider("Planet.java", """
				enum Planet {
				    MERCURY(3.303e+23), VENUS(4.869e+24), PLUTO/*<# 2 #>*/;

				    Planet(double mass) {}
				    Planet() {}
				}
				""", new EnumOrdinalHintProvider(), settings(true));
	}

	private static EnumOrdinalSettingsState settings(boolean hideHintIfArguments) {
		EnumOrdinalSettingsState settings = new EnumOrdinalSettingsState();
		settings.setHideHintIfArguments(hideHintIfArguments);
		return settings;
	}
}
