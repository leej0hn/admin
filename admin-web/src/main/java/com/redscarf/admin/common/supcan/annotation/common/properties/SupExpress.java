package com.redscarf.admin.common.supcan.annotation.common.properties;

import java.lang.annotation.*;

/**
 * 硕正Express注解
 * @author WangZhen
 * @version 2017-12-05
 */
@Target({ ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SupExpress {
	
	/**
	 * 是否自动按列的引用关系优化计算顺序  默认值true
	 */
	String isOpt() default "";
	
	/**
	 * 文本
	 */
	String text() default "";

}
