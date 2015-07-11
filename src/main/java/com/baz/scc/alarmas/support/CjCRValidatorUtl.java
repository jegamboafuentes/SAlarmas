package com.baz.scc.alarmas.support;

/**
 * @author B233388 Froil&aacute;n L&oacute;pez Lemus.
 * @since V 1.1.2
 */
public class CjCRValidatorUtl {
    
    private CjCRValidatorUtl() {}
    
    /**
     * Evaula si el argumento es de tipo boolean.
     * 
     * @param booleanValue
     * @return boolean
     */
    public static boolean validateBoolean(String booleanValue) {
        return Boolean.parseBoolean(booleanValue);
    }
    
    /**
     * Evalua si el argumento es n&uacute;mero entero.
     * 
     * @param integerValue
     * @return boolean
     */
    public static boolean validateInteger(String integerValue) {
        boolean result;
        try {
            Integer.parseInt(integerValue);
            result = true;
        } catch (NumberFormatException nfe) {
            result = false;
        }
        
        return result;
    }
    
    /**
     * Evalua si el argumento es un n&uacute;mero double.
     * 
     * @param doubleValue
     * @return boolean
     */
    public static boolean validateDouble(String doubleValue) {
        boolean result = false;
        
        if (hasData(doubleValue)) {
            try {
                Double.parseDouble(doubleValue);
                result = true;
            } catch (NumberFormatException nfe) { }
        }
        
        return result;
    }
    
    /**
     * Valida si el argumento es fecha valida.
     * Con el patrón: yyyy-MM-dd HH:mm:ss.
     * 
     * @param dateValue
     * @return boolean
     */
    public static boolean validateDateTime1(String dateValue) {
        boolean result = false;
        String pattern = "[0-9]{4}-(0[0-9]|1[0-2])-([0-2][0-9]|3[0-1]) ([0-1][0-9]|2[0-4]):([0-5][0-9]|60):([0-5][0-9]|60)";
        
        if (hasData(dateValue)) {
            result = validatePattern(dateValue, pattern);
        } 
        
        return result;
    }
    
    public static boolean validateDate1(String dateValue) {
        boolean result = false;
        String pattern = "[0-9]{4}-(0[0-9]|1[0-2])-([0-2][0-9]|3[0-1])";
        
        if (hasData(dateValue)) {
            result = validatePattern(dateValue, pattern);
        } 
        
        return result;
    }
    
    /**
     * Evalua si es un folio valido de orden de recolecci&oacute;n.
     * 
     * @param value
     * @return boolean
     */
    public static boolean validateFolioRecoleccion(String value) {
        String pattern = "[a-zA-Z0-9]{3,}";
        
        return validatePattern(value, pattern);
    }
    
    /**
     * Servicio para aplicar los pattern sobre los valores.
     * 
     * @param value
     * @param pattern
     * @return boolean
     */
    private static boolean validatePattern(String value, String pattern) {
        boolean result;
        
       if (hasData(value) && hasData(pattern)) {
           result = value.matches(pattern);
       } else {
           result = false;
       }
        
        return result;
    }
    
    /**
     * Evalua si el par&aacute;metro es null o vacio.
     * 
     * @param value cadena a evaluar.
     * @return String
     */
    private static boolean hasData(String value) {
        boolean result = true;
        if (value == null || (value.trim().isEmpty())) {
            result = false;
        }
        return result;
    }
    
}
