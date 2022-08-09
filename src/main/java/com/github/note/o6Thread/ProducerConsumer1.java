package com.github.note.o6Thread;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer1 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Container container = new Container(lock);

        Producer producer = new Producer(container, lock);
        Consumer consumer = new Consumer(container, lock);

        producer.start();
        consumer.start();
    }


    static class Producer extends Thread {
        private final Container container;
        private final ReentrantLock lock;

        public Producer(Container container, ReentrantLock lock) {
            this.container = container;
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (container.getValue().isPresent()) {
                        try {
                            container.getNotConsumedYet().await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    int r = new Random().nextInt();
                    System.out.println("Producing " + r);
                    container.setValue(Optional.of(r));
                    container.getNotProducedYet().signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer extends Thread {
        private final Container container;
        private final ReentrantLock lock;

        public Consumer(Container container, ReentrantLock lock) {
            this.container = container;
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (!container.getValue().isPresent()) {
                        try {
                            container.getNotProducedYet().await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    Integer value = container.getValue().get();
                    container.setValue(Optional.empty());
                    System.out.println("Consuming " + value);
                    container.getNotConsumedYet().signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    static class Container {
        private final Condition notConsumedYet;
        private final Condition notProducedYet;
        private Optional<Integer> value = Optional.empty();

        public Container(ReentrantLock lock) {
            this.notConsumedYet = lock.newCondition();
            this.notProducedYet = lock.newCondition();
        }

        public Condition getNotConsumedYet() {
            return notConsumedYet;
        }

        public Condition getNotProducedYet() {
            return notProducedYet;
        }

        public Optional<Integer> getValue() {
            return value;
        }

        public void setValue(Optional<Integer> value) {
            this.value = value;
        }
    }
}
