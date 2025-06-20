/** 
 * An involved filter test.  Has multiple column families and deletes in mix.
 */
public void testWeirdCacheBehaviour() throws Exception {
assertEquals("Got back incorrect number of rows from scan",3,getNumberOfRows(keyPrefix1,value2,this.region));
assertEquals("Got back incorrect number of rows from scan",3,getNumberOfRows(keyPrefix2,value2,this.region));
assertEquals("Got back incorrect number of rows from scan",3,getNumberOfRows(keyPrefix3,value2,this.region));
assertEquals("Got back incorrect number of rows from scan: " + keyPrefix1,0,getNumberOfRows(keyPrefix1,value2,this.region));
assertEquals("Got back incorrect number of rows from scan: " + keyPrefix2,0,getNumberOfRows(keyPrefix2,value2,this.region));
assertEquals("Got back incorrect number of rows from scan: " + keyPrefix3,0,getNumberOfRows(keyPrefix3,value2,this.region));
}