/** 
 * Verify that serialization form of CopyOnWriteMap.Hash and HashMap are the same.
 */
@Test public void hashSerialization(){
assertEquals("empty maps","<hudson.util.CopyOnWriteMapTest_-HashData>" + "<map1/><map2/></hudson.util.CopyOnWriteMapTest_-HashData>",out.replaceAll("\\s+",""));
assertTrue(td2.map1.isEmpty());
assertTrue(td2.map2.isEmpty());
assertEquals("maps","<hudson.util.CopyOnWriteMapTest_-HashData><map1>" + "<entry><string>foo1</string><string>bar1</string></entry></map1>" + "<map2><entry><string>foo2</string><string>bar2</string></entry>"+ "</map2></hudson.util.CopyOnWriteMapTest_-HashData>",out.replaceAll("\\s+",""));
assertEquals("bar1",td2.map1.get("foo1"));
assertEquals("bar2",td2.map2.get("foo2"));
}