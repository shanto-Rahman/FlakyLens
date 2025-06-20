/** 
 * Verify that serialization form of CopyOnWriteMap.Hash and HashMap are the same.
 */
@Test public void hashSerialization(){
  HashData td=new HashData();
  XStream2 xs=new XStream2();
  String out=xs.toXML(td);
  System.out.println(td.getClass().getName());
  assertTrue(out.replaceAll("\\s+","").equals("<hudson.util.CopyOnWriteMapTest_-HashData>" + "<map1/><map2/></hudson.util.CopyOnWriteMapTest_-HashData>") || out.replaceAll("\\s+","").equals("<hudson.util.CopyOnWriteMapTest_-HashData>" + "<map2/><map1/></hudson.util.CopyOnWriteMapTest_-HashData>"));
  HashData td2=(HashData)xs.fromXML(out);
  assertTrue(td2.map1.isEmpty());
  assertTrue(td2.map2.isEmpty());
  td.map1.put("foo1","bar1");
  td.map2.put("foo2","bar2");
  out=xs.toXML(td);
  assertTrue(out.replaceAll("\\s+","").equals("<hudson.util.CopyOnWriteMapTest_-HashData><map1>" + "<entry><string>foo1</string><string>bar1</string></entry></map1>" + "<map2><entry><string>foo2</string><string>bar2</string></entry>"+ "</map2></hudson.util.CopyOnWriteMapTest_-HashData>") || out.replaceAll("\\s+","").equals("<hudson.util.CopyOnWriteMapTest_-HashData><map2>" + "<entry><string>foo2</string><string>bar2</string></entry></map2>" + "<map1><entry><string>foo1</string><string>bar1</string></entry>"+ "</map1></hudson.util.CopyOnWriteMapTest_-HashData>"));
  td2=(HashData)xs.fromXML(out);
  assertEquals("bar1",td2.map1.get("foo1"));
  assertEquals("bar2",td2.map2.get("foo2"));
}
