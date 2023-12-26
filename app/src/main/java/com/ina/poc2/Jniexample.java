package com.ina.poc2;

public class Jniexample{  // Save as HelloJNI.java
    static {
        System.loadLibrary("hello"); // Load native library hello.dll (Windows) or libhello.so (Unixes)
        //  at runtime
        // This library contains a native method called sayHello()
    }

    // Declare an instance native method sayHello() which receives no parameter and returns void
    private native void sayHello();

    // Test Driver
    public static void main(String[] args) {
        new Jniexample().sayHello();  // Create an instance and invoke the native method
    }
}
