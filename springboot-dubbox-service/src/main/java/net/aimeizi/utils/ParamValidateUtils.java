package net.aimeizi.utils;

import javax.validation.*;
import java.util.*;

public class ParamValidateUtils {

    final static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    final static Validator validator = factory.getValidator();

    public static <T> Map<String, ArrayList<String>> validator(T t, HashSet<String> skipFields) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        if (constraintViolations != null && constraintViolations.size() > 0) {
            Map<String, ArrayList<String>> mapErr = new HashMap<String, ArrayList<String>>();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                for (Path.Node node : constraintViolation.getPropertyPath()) {
                    String fieldName = node.getName();
                    if (skipFields == null || !skipFields.contains(fieldName)) {
                        ArrayList<String> lst = mapErr.get(fieldName);
                        if (lst == null) {
                            lst = new ArrayList<String>();
                        }
                        lst.add(constraintViolation.getMessage());
                        mapErr.put(node.getName(), lst);
                    }
                }
            }
            return mapErr;
        }
        return null;
    }

    public static <T> Map<String, ArrayList<String>> validator(T t) {
        return validator(t, null);
    }
}
