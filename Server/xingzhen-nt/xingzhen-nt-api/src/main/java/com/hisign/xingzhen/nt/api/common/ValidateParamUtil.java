package com.hisign.xingzhen.nt.api.common;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 验证参数工具类
 * @author lqf
 * @Date 2017年6月20日
 */
public class ValidateParamUtil {
	private static Validator validator;

	static {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	private ValidateParamUtil() {
		super();
	}

	public static String validateParam(Object obj) {
		StringBuffer sb = new StringBuffer();
		Set<ConstraintViolation<Object>> violations = validator.validate(obj);
		if (null == violations || violations.size() == 0) {
			return "";
		}
		for (ConstraintViolation<Object> violation : violations) {
			sb.append(violation.getMessage()).append(";");
		}
		return sb.toString();
	}
}
