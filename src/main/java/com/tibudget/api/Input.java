package com.tibudget.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a plugin field so that users can configure its value.
 * <p>
 * Fields annotated with this annotation are transformed into an HTML input form.
 * A getter and a setter must exist:
 * the getter provides the default value, and the setter validates the submitted value.
 * If the value is invalid, the setter must throw a
 * {@link com.tibudget.api.exceptions.ParameterError ParameterError}
 * exception.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Input {
	/**
	 * Whether the field is required.
	 *
	 * @return {@code true} if the field is required; otherwise {@code false}
	 */
	boolean required() default true;

	/**
	 * For an HTML text input, indicates the size of the field.
	 *
	 * @return the input size, or {@code -1} if unspecified
	 */
	int size() default -1;

	/**
	 * For a {@link String} field, indicates the maximum length.
	 *
	 * @return the maximum length, or {@code -1} if unspecified
	 */
	int maxlen() default -1;

	/**
	 * Indicates where the input should appear in the form.
	 * You can choose any value; what matters is the order across all other members.
	 *
	 * @return the display order, or {@code -1} if unspecified
	 */
	int order() default -1;

	/**
	 * Indicates whether the field is a password.
	 *
	 * @return {@code true} if the field is a password; otherwise {@code false}
	 */
	boolean password() default false;
	
	/**
	 * Groups fields into a fieldset.
	 *
	 * @return the fieldset name, or an empty string if none is set
	 */
	String fieldset() default "";
	
	/**
	 * Only works with boolean fields.
	 * If needed, indicates the fieldsets that will be hidden
	 * when this field is {@code true} and displayed when it is {@code false}.
	 *
	 * @return the fieldsets to hide
	 */
	String[] hideFieldset() default {};
	
	/**
	 * Only works with boolean fields.
	 * If needed, indicates the fieldsets that will be displayed
	 * when this field is {@code true} and hidden when it is {@code false}.
	 *
	 * @return the fieldsets to show
	 */
	String[] showFieldset() default {};
}
