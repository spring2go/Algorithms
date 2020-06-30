package com.spring2go.algorithms.datastructures.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created on Jun, 2020 by @author bobo
 */
public class QueueTest {

    LinkedQueue<Integer> queue = new LinkedQueue<>();

    @Test
    public void testEmptyQueue() {
        assertTrue(queue.isEmpty());
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testPollOnEmpty() {
        assertThrows(Exception.class, queue::poll);
    }

    @Test
    public void testPeekOnEmpty() {
        assertThrows(Exception.class, queue::peek);
    }

    @Test
    public void testOffer() {
        queue.offer(2);
        assertEquals(queue.size(), 1);
    }

    @Test
    public void testPeek() {
        queue.offer(2);
        assertEquals(2, (int) queue.peek());
        assertEquals(queue.size(), 1);
    }

    @Test
    public void testPoll() {
        queue.offer(2);
        assertEquals(2, (int) queue.poll());
        assertEquals(queue.size(), 0);
    }

    @Test
    public void testExhaustively() {
        assertTrue(queue.isEmpty());
        queue.offer(1);
        assertFalse(queue.isEmpty());
        queue.offer(2);
        assertEquals(queue.size(), 2);
        assertEquals(1, (int) queue.peek());
        assertEquals(queue.size(), 2);
        assertEquals(1, (int) queue.poll());
        assertEquals(queue.size(), 1);
        assertEquals(2, (int) queue.peek());
        assertEquals(queue.size(), 1);
        assertEquals(2, (int) queue.poll());
        assertEquals(queue.size(), 0);
        assertTrue(queue.isEmpty());
    }
}
