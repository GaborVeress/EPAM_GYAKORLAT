package com.epam.training.internship.multimap;

import java.util.Collection;
import java.util.List;

/**
 * Created by Gabor_Veress on 7/4/2017.
 */
public class MultiMapAlap
{
    private Object key;
    private Collection<Object> value;
    public MultiMapAlap(Object k,Collection<Object> v)
    {
        key=k;
        value=v;
    }
    public Object getKey()
    {
        return key;
    }

    public void setKey(Object key)
    {
        this.key = key;
    }

    public Collection<Object> getValue()
    {
        return value;
    }

    public void setValue(Collection<Object> value)
    {
        this.value = value;
    }
}
