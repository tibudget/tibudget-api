package com.tibudget.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares a plugin field as a user-configurable input.
 * <p>
 * Applications inspect this annotation at runtime to build configuration forms,
 * including mobile, desktop and web interfaces. The annotation describes the
 * input; the application determines how to render it and enforce its constraints.
 * <p>
 * The field must have a matching public getter and setter. The getter supplies
 * the initial value, used as the default when no saved configuration is available.
 * The setter validates and applies a submitted value, and must throw
 * {@link com.tibudget.api.exceptions.ParameterError ParameterError} if it is invalid.
 * Form metadata does not replace validation in the setter.
 * <p>
 * Define the field label in the plugin's {@code messages.properties} bundle using
 * {@code form.label.<fieldName>}. Optional helper text uses
 * {@code form.tooltip.<fieldName>}. For a field named {@code login}, for example:
 * <pre>{@code
 * form.label.login=Login
 * form.tooltip.login=Your account email address
 * }</pre>
 * Rendering details and support for individual options depend on the application.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Input {
	/**
	 * Whether the user must supply a value for this input.
	 * Defaults to {@code true}.
	 *
	 * @return {@code true} if the field is required; otherwise {@code false}
	 */
	boolean required() default true;

	/**
	 * Preferred display width of a text input, in characters.
	 * This is a presentation hint for interfaces that support it, not a length limit.
	 * Use {@link #maxlen()} to specify the maximum text length.
	 *
	 * @return the input size, or {@code -1} if unspecified
	 */
	int size() default -1;

	/**
	 * Maximum number of characters allowed for a {@link String} input.
	 * A value of {@code -1} leaves the maximum unspecified.
	 *
	 * @return the maximum length, or {@code -1} if unspecified
	 */
	int maxlen() default -1;

	/**
	 * Relative display order among the form inputs, sorted in ascending order.
	 * Values need not be consecutive. The default {@code -1} participates in
	 * sorting like any other value; ordering of equal values depends on the application.
	 *
	 * @return the display order, or {@code -1} if unspecified
	 */
	int order() default -1;

	/**
	 * Whether a {@link String} input should mask its displayed characters.
	 * This controls presentation and does not itself encrypt or store the value.
	 *
	 * @return {@code true} if the field is a password; otherwise {@code false}
	 */
	boolean password() default false;
	
	/**
	 * Identifier of the group (fieldset) containing this input.
	 * Inputs with the same identifier belong to the same group. This identifier
	 * can be referenced by {@link #hideFieldset()} and {@link #showFieldset()};
	 * it is not a display label.
	 *
	 * @return the fieldset name, or an empty string if none is set
	 */
	String fieldset() default "";
	
	/**
	 * Group identifiers to hide when this boolean input is {@code true},
	 * and show when it is {@code false}.
	 * Applies only to boolean inputs. Each identifier refers to the
	 * {@link #fieldset()} of the affected inputs.
	 *
	 * @return the fieldsets to hide
	 */
	String[] hideFieldset() default {};
	
	/**
	 * Group identifiers to show when this boolean input is {@code true},
	 * and hide when it is {@code false}.
	 * Applies only to boolean inputs. Each identifier refers to the
	 * {@link #fieldset()} of the affected inputs.
	 *
	 * @return the fieldsets to show
	 */
	String[] showFieldset() default {};
}
