package com.weison.mokito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

public class Spy {


    @Test
    public void spyTest() {
        List<String> list = new LinkedList();
        List spy = Mockito.spy(list);
        spy.add("0");
        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        when(spy.get(0)).thenReturn("foo");
        Object o = spy.get(0);
        //You have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(1);
        Object o1 = spy.get(0);
        System.out.println();
    }

}
