package com.spring2go.algorithms.datastructures.unionfind;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created on Jul, 2020 by @author bobo
 */
public class UnionFindTest {
    @Test
    public void testNumComponents() {

        UnionFind uf = new UnionFind(5);
        assertEquals(uf.groups(), 5);

        uf.unify(0, 1);
        assertEquals(uf.groups(), 4);

        uf.unify(1, 0);
        assertEquals(uf.groups(), 4);

        uf.unify(1, 2);
        assertEquals(uf.groups(), 3);

        uf.unify(0, 2);
        assertEquals(uf.groups(), 3);

        uf.unify(2, 1);
        assertEquals(uf.groups(), 3);

        uf.unify(3, 4);
        assertEquals(uf.groups(), 2);

        uf.unify(4, 3);
        assertEquals(uf.groups(), 2);

        uf.unify(1, 3);
        assertEquals(uf.groups(), 1);

        uf.unify(4, 0);
        assertEquals(uf.groups(), 1);
    }

    @Test
    public void testComponentSize() {

        UnionFind uf = new UnionFind(5);
        assertEquals(uf.groupSize(0), 1);
        assertEquals(uf.groupSize(1), 1);
        assertEquals(uf.groupSize(2), 1);
        assertEquals(uf.groupSize(3), 1);
        assertEquals(uf.groupSize(4), 1);

        uf.unify(0, 1);
        assertEquals(uf.groupSize(0), 2);
        assertEquals(uf.groupSize(1), 2);
        assertEquals(uf.groupSize(2), 1);
        assertEquals(uf.groupSize(3), 1);
        assertEquals(uf.groupSize(4), 1);

        uf.unify(1, 0);
        assertEquals(uf.groupSize(0), 2);
        assertEquals(uf.groupSize(1), 2);
        assertEquals(uf.groupSize(2), 1);
        assertEquals(uf.groupSize(3), 1);
        assertEquals(uf.groupSize(4), 1);

        uf.unify(1, 2);
        assertEquals(uf.groupSize(0), 3);
        assertEquals(uf.groupSize(1), 3);
        assertEquals(uf.groupSize(2), 3);
        assertEquals(uf.groupSize(3), 1);
        assertEquals(uf.groupSize(4), 1);

        uf.unify(0, 2);
        assertEquals(uf.groupSize(0), 3);
        assertEquals(uf.groupSize(1), 3);
        assertEquals(uf.groupSize(2), 3);
        assertEquals(uf.groupSize(3), 1);
        assertEquals(uf.groupSize(4), 1);

        uf.unify(2, 1);
        assertEquals(uf.groupSize(0), 3);
        assertEquals(uf.groupSize(1), 3);
        assertEquals(uf.groupSize(2), 3);
        assertEquals(uf.groupSize(3), 1);
        assertEquals(uf.groupSize(4), 1);

        uf.unify(3, 4);
        assertEquals(uf.groupSize(0), 3);
        assertEquals(uf.groupSize(1), 3);
        assertEquals(uf.groupSize(2), 3);
        assertEquals(uf.groupSize(3), 2);
        assertEquals(uf.groupSize(4), 2);

        uf.unify(4, 3);
        assertEquals(uf.groupSize(0), 3);
        assertEquals(uf.groupSize(1), 3);
        assertEquals(uf.groupSize(2), 3);
        assertEquals(uf.groupSize(3), 2);
        assertEquals(uf.groupSize(4), 2);

        uf.unify(1, 3);
        assertEquals(uf.groupSize(0), 5);
        assertEquals(uf.groupSize(1), 5);
        assertEquals(uf.groupSize(2), 5);
        assertEquals(uf.groupSize(3), 5);
        assertEquals(uf.groupSize(4), 5);

        uf.unify(4, 0);
        assertEquals(uf.groupSize(0), 5);
        assertEquals(uf.groupSize(1), 5);
        assertEquals(uf.groupSize(2), 5);
        assertEquals(uf.groupSize(3), 5);
        assertEquals(uf.groupSize(4), 5);
    }

    @Test
    public void testConnectivity() {

        int sz = 7;
        UnionFind uf = new UnionFind(sz);

        for (int i = 0; i < sz; i++) assertTrue(uf.connected(i, i));

        uf.unify(0, 2);

        assertTrue(uf.connected(0, 2));
        assertTrue(uf.connected(2, 0));

        assertFalse(uf.connected(0, 1));
        assertFalse(uf.connected(3, 1));
        assertFalse(uf.connected(6, 4));
        assertFalse(uf.connected(5, 0));

        for (int i = 0; i < sz; i++) assertTrue(uf.connected(i, i));

        uf.unify(3, 1);

        assertTrue(uf.connected(0, 2));
        assertTrue(uf.connected(2, 0));
        assertTrue(uf.connected(1, 3));
        assertTrue(uf.connected(3, 1));

        assertFalse(uf.connected(0, 1));
        assertFalse(uf.connected(1, 2));
        assertFalse(uf.connected(2, 3));
        assertFalse(uf.connected(1, 0));
        assertFalse(uf.connected(2, 1));
        assertFalse(uf.connected(3, 2));

        assertFalse(uf.connected(1, 4));
        assertFalse(uf.connected(2, 5));
        assertFalse(uf.connected(3, 6));

        for (int i = 0; i < sz; i++) assertTrue(uf.connected(i, i));

        uf.unify(2, 5);
        assertTrue(uf.connected(0, 2));
        assertTrue(uf.connected(2, 0));
        assertTrue(uf.connected(1, 3));
        assertTrue(uf.connected(3, 1));
        assertTrue(uf.connected(0, 5));
        assertTrue(uf.connected(5, 0));
        assertTrue(uf.connected(5, 2));
        assertTrue(uf.connected(2, 5));

        assertFalse(uf.connected(0, 1));
        assertFalse(uf.connected(1, 2));
        assertFalse(uf.connected(2, 3));
        assertFalse(uf.connected(1, 0));
        assertFalse(uf.connected(2, 1));
        assertFalse(uf.connected(3, 2));

        assertFalse(uf.connected(4, 6));
        assertFalse(uf.connected(4, 5));
        assertFalse(uf.connected(1, 6));

        for (int i = 0; i < sz; i++) assertTrue(uf.connected(i, i));

        // Connect everything
        uf.unify(1, 2);
        uf.unify(3, 4);
        uf.unify(4, 6);

        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                assertTrue(uf.connected(i, j));
            }
        }
    }

    @Test
    public void testSize() {

        UnionFind uf = new UnionFind(5);
        assertEquals(uf.size(), 5);
        uf.unify(0, 1);
        uf.find(3);
        assertEquals(uf.size(), 5);
        uf.unify(1, 2);
        assertEquals(uf.size(), 5);
        uf.unify(0, 2);
        uf.find(1);
        assertEquals(uf.size(), 5);
        uf.unify(2, 1);
        assertEquals(uf.size(), 5);
        uf.unify(3, 4);
        uf.find(0);
        assertEquals(uf.size(), 5);
        uf.unify(4, 3);
        uf.find(3);
        assertEquals(uf.size(), 5);
        uf.unify(1, 3);
        assertEquals(uf.size(), 5);
        uf.find(2);
        uf.unify(4, 0);
        assertEquals(uf.size(), 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadUnionFindCreation1() {
        new UnionFind(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadUnionFindCreation2() {
        new UnionFind(-3463);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBadUnionFindCreation3() {
        new UnionFind(0);
    }

}
