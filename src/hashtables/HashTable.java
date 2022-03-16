package hashtables;

import java.util.Iterator;

/**
 * Implementation of a hash table. Propertie are:
 *
 * - linear probing for collisions
 * - 60% load factor
 * - 50% resize rate
 * - initial table size is 10
 *
 * @param <T> the type of elements in the table
 */
public class HashTable<T> implements IHashTable<T>
{
    //fields?
    private static final double LOAD_FACTOR = 0.6;
    private static final double RESIZE_RATE = 1.5;
    private static final int INITIAL_TABLE_SIZE = 10;

    private HashElement[] table;
    private int size;
    private int modCount;

    public HashTable()
    {
        table = new HashElement[INITIAL_TABLE_SIZE];
    }

    @Override
    public void add(T... elements)
    {
        for (T element : elements)
        {
            add(element);
        }
    }

    @Override
    public boolean add(T element)
    {
        //make sure we respect our max load factor
        double curLoad = (double)(size + 1) / table.length; //+1 for the new element
        if (curLoad > LOAD_FACTOR)
        {
            resize();
        }

        //find the position where the element should be
        int index = Math.abs(element.hashCode()) % table.length;

        if (table[index] == null)
        {
            table[index] = new HashElement(element, true);
        }
        else
        {
            //we need to determine if the element is already in the structure,
            //or find an empty spot for it
            while (table[index] != null && !table[index].element.equals(element))
            {
                //move to the next spot in the table
                index = (index + 1) % table.length;
            }

            //what two possibilities are the case when we exit the loop?
            if (table[index] == null) //we found an empty spot!
            {
                table[index] = new HashElement(element, true);
            }
            else //we found an element that is equal to our input
            {
                if (table[index].active)
                {
                    return false; // a duplicate!
                }
                else
                {
                    table[index].active = true;
                }
            }
        }

        size++;
        modCount++;
        return true;
    }

    private void resize()
    {
        //create a new array
        HashElement[] oldTable = table;
        table = new HashElement[(int)(oldTable.length * RESIZE_RATE)];
        size = 0; //reset size so we don't overcount with add() below...

        //move all elements over to the new array
        for (int i = 0; i < oldTable.length; i++)
        {
            if (oldTable[i] != null && oldTable[i].active)
            {
                add((T)oldTable[i].element);
            }
        }
    }

    @Override
    public boolean contains(T element)
    {
        int index = Math.abs(element.hashCode()) % table.length;

        while (table[index] != null && !table[index].element.equals(element))
        {
            //move to the next element
            index = (index + 1) % table.length;
        }

        //we found a null spot
        if (table[index] == null)
        {
            return false;
        }

        return table[index].active;
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public boolean remove(T element)
    {
        int index = Math.abs(element.hashCode()) % table.length;

        while (table[index] != null && !table[index].element.equals(element))
        {
            //move to the next element
            index = (index + 1) % table.length;
        }

        //we found a null spot
        if (table[index] == null)
        {
            return false;
        }

        //if there's a match
        if (table[index].element.equals(element))
        {
            table[index].active = false;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator()
    {
        return null;
    }

    @Override
    public T get(T element)
    {
        return null;
    }

    @Override
    public String toString()
    {
        String output = "[";

        for (int i = 0; i < table.length; i++)
        {
            if (table[i] != null)
            {
                output += table[i] + ", ";
            }
            else
            {
                output += "null, ";
            }
        }

        output += "]";
        return output;
    }

    private static class HashElement<T>
    {
        private T element;
        private boolean active;

        public HashElement(T element, boolean active)
        {
            this.element = element;
            this.active = active;
        }

        @Override
        public String toString()
        {
            String output = element.toString();
            output += active ? "" : " (i)";
            return output;
        }
    }
}
