package com.epam.training.internship.multimap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Gabor_Veress on 7/4/2017.
 */
public class MultiMapClass implements MultiMap
{
    private Collection<MultiMapAlap> multimap;

    public Object put(Object key, Object value)
    {
        MultiMapAlap [] t=new MultiMapAlap[multimap.size()];
        t=multimap.toArray(t);
        for (int i=0;i<multimap.size();i++)
        {
            if(t[i].getKey().equals(key))
            {
                t[i].getValue().add(value);
                return value;
            }
        }
     return null;
    }

    public Collection get(Object key)
    {
        MultiMapAlap[] t = new MultiMapAlap[multimap.size()];
        t = multimap.toArray(t);
        ArrayList<Object> ret=new ArrayList<Object>();
        for(int i=0;i<multimap.size();i++)
        {
            if(t[i].getKey().equals(key))
            {
                for (int j=0;j<t[i].getValue().size();j++)
                {
                      ret.add(t[i].getValue().toArray()[j]);
                }
            }
        }
        if(ret.size()>0)
        {
            return ret;
        }
        return null;
    }

    public Collection remove(Object key)
    {
        MultiMapAlap [] t=new MultiMapAlap[multimap.size()];
        t=multimap.toArray(t);
        for (int i=0;i<multimap.size();i++)
        {
            if(t[i].getKey().equals(key))
            {
                multimap.remove(key);
                return t[i].getValue();
            }
        }
        return null;
    }

    public boolean remove(Object key, Object value)
    {
        MultiMapAlap [] t=new MultiMapAlap[multimap.size()];
        t=multimap.toArray(t);
        for(int i=0;i<multimap.size();i++)
        {
            if(t[i].getKey().equals(key))
            {
                for(int j=0;j<t[i].getValue().size();j++)
                {
                    if(t[i].getValue().toArray()[j].equals(value))
                    {
                        t[i].getValue().remove(value);
                        return  true;
                    }
                }
            }
        }
        return false;
    }

    public void clear()
    {
        multimap.clear();
    }

    public boolean containsKey(Object key)
    {
        if (multimap.contains(key))
        {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object value)
    {
        if(multimap.contains(value))
        {
            return true;
        }
        return false;
    }

    public boolean isEmpty()
    {
        if(multimap.size()>0)
        {
            return false;
        }
        return true;
    }

    public int size()
    {
        return multimap.size();
    }
}
