/** 
 * Create a Store with the result of a HLog split and test we only see the good edits
 * @throws Exception
 */
@Test public void runReconstructionLog() throws Exception {
assertEquals(1,splits.size());
assertTrue(cluster.getFileSystem().exists(splits.get(0)));
assertEquals(TOTAL_EDITS,result.size());
}