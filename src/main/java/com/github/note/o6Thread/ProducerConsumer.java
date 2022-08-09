package com.github.note.o6Thread;

import java.util.Optional;
import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        Container container = new Container();

        Producer producer = new Producer(container, lock);
        Consumer consumer = new Consumer(container, lock);

        producer.start();
        consumer.start();

        producer.join();
        producer.join();

    }

    static class Producer extends Thread {
        private final Object lock;
        private final Container container;


        Producer(Container container, Object lock) {
            this.lock = lock;
            this.container = container;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (container.getValue().isPresent()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    int value = new Random().nextInt();
                    System.out.println("Producing " + value);
                    container.setValue(Optional.of(value));
                    lock.notify();
                }
            }

        }
    }

    static class Consumer extends Thread {
        private final Object lock;
        private final Container container;

        public Consumer(Container container, Object lock) {
            this.lock = lock;
            this.container = container;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    while (!container.getValue().isPresent()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Consuming " + container.getValue().get());
                    container.setValue(Optional.empty());
                    lock.notify();
                }
            }

        }
    }


    static class Container {
        private Optional<Integer> value = Optional.empty();

        public Optional<Integer> getValue() {
            return value;
        }

        public void setValue(Optional<Integer> value) {
            this.value = value;
        }
    }
}
