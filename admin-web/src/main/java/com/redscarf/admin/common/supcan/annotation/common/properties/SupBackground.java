package com.redscarf.admin.common.supcan.annotation.common.properties;

import java.lang.annotation.*;

/**
 * 硕正Background注解
 * @author
 * @version 2017-12-05
 */
@Target({ ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SupBackground {
	
	/**
	 * 背景颜色
	 * @return
	 */
	String bgColor() default "";

}
