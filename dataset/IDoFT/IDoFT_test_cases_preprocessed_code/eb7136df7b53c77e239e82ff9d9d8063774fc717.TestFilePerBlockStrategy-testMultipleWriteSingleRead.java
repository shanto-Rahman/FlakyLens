/** 
 * This test writes data as many small writes and tries to read back the data in a single large read.
 */
@Test public void testMultipleWriteSingleRead() throws Exception {
assertEquals(Hex.encodeHexString(oldSha.digest()),Hex.encodeHexString(newSha.digest()));
}