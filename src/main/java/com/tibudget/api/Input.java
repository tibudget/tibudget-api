package com.tibudget.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Mark your plugin field members with this annotation
 * to allow the user to set its value.
 * 
 * <p>All member with this annotation will be transformed into
 * an HTML input form. Getter and setter must exists. Getter
 * gives the default value and setter validates the 
 * given value. If value is not correct it must throw a
 * {@link com.nbo.whatispend.api.exception.ParameterError ParameterError} 
 * exception (see javadoc for more information).
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Input {
	/** Default is true */
	boolean required() default true;

	/** For HTML text input, indicates the size of the field */
	int size() default -1;

	/** For String member, indicates the maximum length of the string */
	int maxlen() default -1;

	/** Indicates where you want to place the input into the form.
	 * You can set whatever value you want, the important thing is
	 * the order accross all other members. */
	int order() default -1;

	/** Indicates if the member is a password */
	boolean password() default false;
	
	/** If you want to group fields into a fieldset then
	 * you can do it here */
	String fieldset() default "";
	
	/**
	 * Only works with boolean field.
	 * If needed, indicates the fieldsets that will be hidden
	 * if this field value is true (and displayed if false).
	 */
	String[] hideFieldset() default {};
	
	/**
	 * Only works with boolean field.
	 * If needed, indicates the fieldsets that will be displayed
	 * if this field value is true (and hidden if false). 
	 */
	String[] showFieldset() default {};
}
