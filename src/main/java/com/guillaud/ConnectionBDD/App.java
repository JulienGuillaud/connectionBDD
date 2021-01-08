package com.guillaud.ConnectionBDD;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	bddConnect c = new bddConnect();
    	c.connect();
    	c.insertData(false);
    	c.selectData();
    	
    }
}
