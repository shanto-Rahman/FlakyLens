/** 
 * Result should look like this: <code> result { match { index: 1 node { name: "source" index: 1 } node { name: "target" index: 2 } reln { name: "zzz" reln: "dobj" } } } </code>
 */
@Test public void testSimpleRequest(){
Assert.assertEquals("Expected exactly 1 reply",1,response.getResultList().size());
}