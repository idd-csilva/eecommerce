package br.com.eecommerce.backend.action;

public interface Action<T> {

    T perform(final Object... params);
}
