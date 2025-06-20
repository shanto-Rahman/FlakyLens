/** 
 * Tests that there is no repeated text in the page margin area as reported in issue 458.
 */
@Test public void testIssue458PageContentRepeatedInMargin() throws IOException {
assertEquals(normalizedExpected.trim(),normalizedActual.trim());
}