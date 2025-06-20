/** 
 * Verify that    {@link QueryMatcher}  only skips expired KeyValueinstances and does not exit early from the row (skipping later non-expired KeyValues).  This version mimics a Get with wildcard-inferred column qualifiers.
 * @throws IOException
 */
public void testMatch_ExpiredWildcard() throws IOException {
assertEquals(expected.length,actual.size());
if (PRINT) {
}
assertEquals(expected[i],actual.get(i));
}