/** 
 * Test the findMemstoresWithEditsOlderThan method.
 * @throws IOException
 */
public void testFindMemstoresWithEditsOlderThan() throws IOException {
assertEquals(1,regions.length);
assertTrue(Bytes.equals(regions[0],"0".getBytes()));
assertEquals(count,regions.length);
assertTrue(Bytes.equals(regions[i],"0".getBytes()) || Bytes.equals(regions[i],"1".getBytes()) || Bytes.equals(regions[i],"2".getBytes()));
}