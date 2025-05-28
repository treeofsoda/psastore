package com.psa.psastore.validator;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

public class FlagValidatorClassTest {
    private FlagValidatorClass validator;
    @Mock
    private FlagValidator flagValidator;
    @Mock
    private ConstraintValidatorContext context;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        validator = new FlagValidatorClass();
    }

    @Test
    public void testValidValue() {
        validator.initialize(new FlagValidator() {
            @Override
            public String[] value() { return new String[]{"0", "1"}; }
            @Override
            public String message() { return "invalid flag value"; }
            @Override
            public Class<?>[] groups() { return new Class[0]; }
            @Override
            @SuppressWarnings("unchecked")
            public Class<? extends jakarta.validation.Payload>[] payload() { return (Class<? extends jakarta.validation.Payload>[]) new Class<?>[0]; } // NOSONAR
            @Override
            public Class<? extends java.lang.annotation.Annotation> annotationType() { return FlagValidator.class; }
        });
        assertTrue(validator.isValid(0, context));
        assertTrue(validator.isValid(1, context));
        assertFalse(validator.isValid(2, context));
    }

    @Test
    public void testNullValue() {
        validator.initialize(new FlagValidator() {
            @Override
            public String[] value() { return new String[]{"0", "1"}; }
            @Override
            public String message() { return "invalid flag value"; }
            @Override
            public Class<?>[] groups() { return new Class[0]; }
            @Override
            @SuppressWarnings("unchecked")
            public Class<? extends jakarta.validation.Payload>[] payload() { return (Class<? extends jakarta.validation.Payload>[]) new Class<?>[0]; } // NOSONAR
            @Override
            public Class<? extends java.lang.annotation.Annotation> annotationType() { return FlagValidator.class; }
        });
        assertTrue(validator.isValid(null, context));
    }

    @Test
    public void testEmptyValidValues() {
        validator.initialize(new FlagValidator() {
            @Override
            public String[] value() { return new String[]{}; }
            @Override
            public String message() { return "invalid flag value"; }
            @Override
            public Class<?>[] groups() { return new Class[0]; }
            @Override
            @SuppressWarnings("unchecked")
            public Class<? extends jakarta.validation.Payload>[] payload() { return (Class<? extends jakarta.validation.Payload>[]) new Class<?>[0]; } // NOSONAR
            @Override
            public Class<? extends java.lang.annotation.Annotation> annotationType() { return FlagValidator.class; }
        });
        assertFalse(validator.isValid(0, context));
        assertFalse(validator.isValid(1, context));
    }
}
