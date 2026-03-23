package com.example.todo.presentation.rest;

import javax.ws.rs.HttpMethod;
import java.lang.annotation.*;

/**
 * JAX-RS 2.0 (Java EE 7) には @PATCH が含まれないため独自定義。
 * JAX-RS 2.1 以降では標準の @PATCH に置き換え可能。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@HttpMethod("PATCH")
@Documented
public @interface PATCH {
}
