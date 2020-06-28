package com.spring2go.algorithms.datastructures.stack;

/**
 * Created on Jun, 2020 by @author bobo
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

    private ListStack<Integer> stack = new ListStack<>();

    @Test
    public void testEmptyStack() {
        assertTrue(stack.isEmpty());
        assertEquals(stack.size(), 0);
    }

    @Test
    public void testPopOnEmpty() {
        assertThrows(Exception.class, stack::pop);
    }

    @Test
    public void testPeekOnEmpty() {
        assertThrows(Exception.class, stack::peek);
    }

    @Test
    public void testPush() {
        stack.push(2);
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testPeek() {
        stack.push(2);
        assertEquals(2, (int) (Integer) stack.peek());
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testPop() {
        stack.push(2);
        assertEquals(2, (int) stack.pop());
        assertEquals(stack.size(), 0);
    }

    @Test
    public void testExhaustively() {
        assertTrue(stack.isEmpty());
        stack.push(1);
        assertFalse(stack.isEmpty());
        stack.push(2);
        assertEquals(stack.size(), 2);
        assertEquals(2, (int) stack.peek());
        assertEquals(stack.size(), 2);
        assertEquals(2, (int) stack.pop());
        assertEquals(stack.size(), 1);
        assertEquals(1, (int) stack.peek());
        assertEquals(stack.size(), 1);
        assertEquals(1, (int) stack.pop());
        assertEquals(stack.size(), 0);
        assertTrue(stack.isEmpty());
    }
}
