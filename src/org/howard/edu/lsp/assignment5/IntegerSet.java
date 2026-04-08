package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Models a mathematical set of integers.
 * A set cannot contain duplicate values.
 * All set operations (union, intersect, diff, complement) return a new
 * IntegerSet and do not modify the original sets.
 *
 * <p>CSCI 363 / CSCI 540 – Assignment 5</p>
 *
 * @author Sam
 */
public class IntegerSet {

    /** Internal storage for set elements. */
    private ArrayList<Integer> set = new ArrayList<>();

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {}

    /**
     * Constructs an IntegerSet pre-loaded with the given list of integers.
     * Duplicates in the provided list are ignored.
     *
     * @param set the initial list of integers
     */
    public IntegerSet(ArrayList<Integer> set) {
        for (int val : set) {
            if (!this.set.contains(val)) {
                this.set.add(val);
            }
        }
    }

    /**
     * Removes all elements from this set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in this set.
     *
     * @return the number of elements
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if this set and the given IntegerSet contain exactly
     * the same elements (order does not matter).
     *
     * @param b the other IntegerSet to compare
     * @return true if both sets have the same elements, false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) return false;
        for (int val : this.set) {
            if (!b.contains(val)) return false;
        }
        return true;
    }

    /**
     * Returns true if the given value is in this set.
     *
     * @param value the value to search for
     * @return true if the value is present, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in this set.
     *
     * @return the largest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in this set.
     *
     * @return the smallest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an integer to this set. If the value is already present,
     * this method does nothing.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an integer from this set. If the value is not present,
     * this method does nothing.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new IntegerSet containing all elements that appear in
     * either this set or the given set (set union).
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the union
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet(new ArrayList<>(this.set));
        for (int val : intSetb.set) {
            result.add(val);
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing only elements common to both
     * this set and the given set (set intersection).
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the intersection
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : this.set) {
            if (intSetb.contains(val)) {
                result.add(val);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements in this set but not
     * in the given set (set difference: this - b).
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the difference
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : this.set) {
            if (!intSetb.contains(val)) {
                result.add(val);
            }
        }
        return result;
    }

    /**
     * Returns a new IntegerSet containing elements in the given set but
     * not in this set (complement: b - this).
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the complement
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int val : intSetb.set) {
            if (!this.contains(val)) {
                result.add(val);
            }
        }
        return result;
    }

    /**
     * Returns true if this set contains no elements.
     *
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of this set in ascending order.
     * Format: [1, 2, 3] for a non-empty set, or [] for an empty set.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}