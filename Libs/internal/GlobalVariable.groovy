package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object locationAPK
     
    /**
     * <p></p>
     */
    public static Object username
     
    /**
     * <p></p>
     */
    public static Object password
     
    /**
     * <p></p>
     */
    public static Object delayShort
     
    /**
     * <p></p>
     */
    public static Object delayMedium
     
    /**
     * <p></p>
     */
    public static Object delayLong
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            locationAPK = selectedVariables['locationAPK']
            username = selectedVariables['username']
            password = selectedVariables['password']
            delayShort = selectedVariables['delayShort']
            delayMedium = selectedVariables['delayMedium']
            delayLong = selectedVariables['delayLong']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
