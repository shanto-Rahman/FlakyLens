/** 
 * Test from client side of an involved filter against a multi family that involves deletes.
 * @throws Exception
 */
@Test public void testWeirdCacheBehaviour() throws Exception {
assertEquals("Got back incorrect number of rows from scan",3,getNumberOfRows(keyPrefix1,value2,table));
assertEquals("Got back incorrect number of rows from scan",3,getNumberOfRows(keyPrefix2,value2,table));
assertEquals("Got back incorrect number of rows from scan",3,getNumberOfRows(keyPrefix3,value2,table));
assertEquals("Got back incorrect number of rows from scan: " + keyPrefix1,0,getNumberOfRows(keyPrefix1,value2,table));
assertEquals("Got back incorrect number of rows from scan: " + keyPrefix2,0,getNumberOfRows(keyPrefix2,value2,table));
assertEquals("Got back incorrect number of rows from scan: " + keyPrefix3,0,getNumberOfRows(keyPrefix3,value2,table));
assertEquals("Got back incorrect number of rows from scan",0,getNumberOfRows(keyPrefix1,value2,table));
assertEquals("Got back incorrect number of rows from scan",0,getNumberOfRows(keyPrefix2,value2,table));
}