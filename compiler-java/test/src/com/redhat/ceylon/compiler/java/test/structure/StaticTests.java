package com.redhat.ceylon.compiler.java.test.structure;

import org.junit.Test;

import com.redhat.ceylon.compiler.java.test.CompilerTests;

public class StaticTests extends CompilerTests {
    @Override
    protected String transformDestDir(String name) {
        return name + "-static";
    }
    
    @Test
    public void testStaticAttribute() {
        compareWithJavaSource("attribute/StaticAttribute");
    }
    
    @Test
    public void testStaticMethod() {
        compareWithJavaSource("method/StaticMethod");
    }
    
    @Test
    public void testStaticClass() {
        compareWithJavaSource("klass/StaticClass");
    }
    
    @Test
    public void testStaticHello() {
        compile("klass/StaticHello.ceylon");
        compile("klass/StaticHello2.ceylon");
    }
}
/*
class Foo {
    private static String s() {
        return "";
    }
    public static String t() {
        return "";
    }
}
class Bar extends Foo {
    private static int s() {
        return 1;
    }
    public static int t() {
        return 1;
    }
}*/