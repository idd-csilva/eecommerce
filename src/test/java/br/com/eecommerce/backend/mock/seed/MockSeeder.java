package br.com.eecommerce.backend.mock.seed;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class MockSeeder<T> {
    private static final String SETTER_TERM = "set";

    public abstract T getMock();

    protected T inflate(final T instance) throws RuntimeException {
        final var fields =
                Arrays.stream(instance.getClass().getDeclaredFields()).collect(Collectors.toList());
        final var methods =
                Arrays.stream(instance.getClass().getDeclaredMethods()).collect(Collectors.toList());

        methods.forEach(it -> {
            if (it.toString().contains(SETTER_TERM)) {
                final var fieldName = sanitizeSetterMethodName(it.toString());

                fields.stream().filter(filterByName(fieldName)).findFirst().ifPresent(invoke(instance, it));
            }
        });

        return instance;
    }

    private String sanitizeSetterMethodName(final String methodName) {
        final int setTermIndex = methodName.indexOf(SETTER_TERM);
        final int parenthesesIndex = methodName.indexOf("(");

        return methodName.substring(setTermIndex, parenthesesIndex).replaceAll(SETTER_TERM, "");
    }

    private Predicate<Field> filterByName(final String fieldName) {
        return field -> field.getName().equalsIgnoreCase(fieldName);
    }

    private Consumer<Field> invoke(final T instance, final Method method) {
        final Random random = new Random();

        return field -> {
            try {
                if (field.getType().getName().contains(Long.class.getName())) {
                    method.invoke(instance, random.nextLong());
                }
                if (field.getType().getName().contains(String.class.getName())) {
                    method.invoke(instance, getRandomString());
                }
                if (field.getType().getName().contains(BigDecimal.class.getName())) {
                    method.invoke(instance, BigDecimal.valueOf(random.nextFloat()));
                }
                if (field.getType().getName().contains(Integer.class.getName())) {
                    method.invoke(instance, random.nextInt());
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private String getRandomString() {
        final int leftLimit = 97;
        final int rightLimit = 122;
        final int targetStringLength = 10;
        final Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
