/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skiplist2;

/**
 *
 * @author algebra1415011
 */
public class SkipListEntry 
{
  public String key;
  public Integer value;

  public int pos;      // I added this to print the skiplist "nicely"

  public SkipListEntry up, down, left, right;

  public static String negInf = new String();  // -inf key value
  public static String posInf = new String();  // +inf key value

  public SkipListEntry(String k, Integer v) 
  { 
     key = k;
     value = v;

     up = down = left = right = null;
  }

  public Integer getValue() 
  { 
    return value; 
  }

  public String getKey() 
  { return key; 
  }

  public Integer setValue(Integer val) 
  {
    Integer oldValue = value;
    value = val;
    return oldValue;
  }

  public boolean equals(Object o) 
  {
    SkipListEntry ent;

    try 
    { 
      ent = (SkipListEntry) o;    // Test if o is a SkipListEntry...
    }
    catch (ClassCastException ex) 
    { 
	return false; 
    }

    return (ent.getKey() == key) && (ent.getValue() == value);
  }

  public String toString() 
  {
    return "(" + key + "," + value + ")";
  }
}
