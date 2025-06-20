/** 
 * Test for hbase-1686.
 * @throws IOException
 */
public void testEmptyStoreFile() throws IOException {
assertEquals(2,this.store.getStorefilesCount());
assertEquals(1,result.size());
}