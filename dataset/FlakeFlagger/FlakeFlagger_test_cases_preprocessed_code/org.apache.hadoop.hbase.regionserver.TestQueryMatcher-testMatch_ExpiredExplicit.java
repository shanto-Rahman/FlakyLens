/** 
 * Verify that    {@link QueryMatcher}  only skips expired KeyValueinstances and does not exit early from the row (skipping later non-expired KeyValues).  This version mimics a Get with explicitly specified column qualifiers.
 * @throws IOException
 */
public void testMatch_ExpiredExplicit() throws IOException {
assertEquals(expected.length,actual.size());
if (PRINT) {
}
assertEquals(expected[i],actual.get(i));
}