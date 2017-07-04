package com.epam.training.internship.multimap;

import java.util.Collection;

/**
 * MultiMap is a special key-value association structure
 * where multiple values can be stored for a single key.
 *
 * @author  attilagyongyosi
 * @since   0.0.1
 *
 * @param   <K>
 *          The type of the keys inside the MultiMap.
 *
 * @param   <V>
 *          The type of the values inside the MultiMap.
 */
public interface MultiMap<K,V>
{

    /**
     * Insert a new value for a given key.
     * If the key is not yet present in the multimap, a new association will
     * be created.
     *
     * @param   key
     *          The key to assign a new value to.
     *
     * @param   value
     *          The value to assign to a given key.
     *
     * @return  The last value associated with key.
     */
    V put(K key, V value);

    /**
     * Returns with every value for a given key.
     *
     * @param   key
     *          The key to get the associated values of.
     *
     * @return  A {@link Collection} of values associated with a key
     *          or {@code null} if the key does not exist in the multimap.
     */
    Collection<V> get(Object key);

    /**
     * Removes an association from the multimap, defined by the key.
     *
     * @param   key
     *          The key to remove from the multimap.
     *
     * @return  The values associated with the key before removal.
     */
    Collection<V> remove(K key);

    /**
     * Removes a specified value from from a key-values association.
     *
     * @param   key
     *          The key of the association.
     *
     * @param   value
     *          The single value to remove from an association.
     *
     * @return  {@code true} if the operation was successful, {@code false} otherwise.
     */
    boolean remove(K key, V value);

    /**
     * Removes every association from the multimap.
     */
    void clear();

    /**
     * Checks if a give key is present in the multimap.
     *
     * @param   key
     *          The key to check.
     *
     * @return  {@code true} if the key is present, {@code false} otherwise.
     */
    boolean containsKey(Object key);

    /**
     * Checks whether a value is associated with any key in the multimap.
     *
     * @param   value
     *          The value to search for in the multimap.
     *
     * @return  {@code true} if the value is present in the multimap, {@code false} otherwise.
     */
    boolean containsValue(Object value);

    /**
     * Checks whether the multimap contains any associations.
     *
     * @return  {@code true} if the multimap contains no key-value associations,
     *          {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Returns with the size of the multimap. The size is determined
     * by how many key-values associations are in the map.
     *
     * @return  the number of keys in the multimap.
     */
    int size();

}
