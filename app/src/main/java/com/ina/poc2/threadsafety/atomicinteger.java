package com.ina.poc.threadsafety;

import java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    AtomicInteger count
            = new AtomicInteger();

    public void increment()
    {
        count.incrementAndGet();
    }
}

