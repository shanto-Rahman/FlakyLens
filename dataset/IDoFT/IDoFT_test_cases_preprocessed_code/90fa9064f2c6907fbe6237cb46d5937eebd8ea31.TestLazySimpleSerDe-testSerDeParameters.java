/** 
 * Tests the deprecated usage of SerDeParameters.
 */
@Test @SuppressWarnings("deprecation") public void testSerDeParameters() throws SerDeException, IOException {
assertEquals((boolean)row.myBool,((LazyBoolean)data.getField(0)).getWritableObject().get());
assertEquals((int)row.myInt,((LazyInteger)data.getField(3)).getWritableObject().get());
}