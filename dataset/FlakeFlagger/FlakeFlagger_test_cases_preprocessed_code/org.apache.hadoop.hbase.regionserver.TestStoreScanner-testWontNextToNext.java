/** 
 * Test test shows exactly how the matcher's return codes confuses the StoreScanner and prevent it from doing the right thing.  Seeking once, then nexting twice should return R1, then R2, but in this case it doesnt.
 * @throws IOException
 */
public void testWontNextToNext() throws IOException {
assertEquals(1,results.size());
assertEquals(kvs[0],results.get(0));
assertEquals(1,results.size());
assertEquals(kvs[2],results.get(0));
assertEquals(0,results.size());
}