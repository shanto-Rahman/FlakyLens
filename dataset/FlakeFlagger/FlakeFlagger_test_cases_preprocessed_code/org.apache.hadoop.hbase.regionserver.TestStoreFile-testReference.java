/** 
 * Test that our mechanism of writing store files in one region to reference store files in other regions works.
 * @throws IOException
 */
public void testReference() throws IOException {
if (first) {
assertTrue(Bytes.equals(kv.getRow(),midRow));
}
assertTrue(Bytes.equals(kv.getRow(),finalRow));
}