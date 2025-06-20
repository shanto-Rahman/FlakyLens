/** 
 * Covers test case when there is one ear with shared sessions between wars and second without sharing. This test checks that the sessions sharing in one EAR doesn't intervene with sessions in second EAR
 */
@Test public void testSharedSessionsDoNotInterleave() throws IOException {
assertEquals("0",result);
assertEquals("1",result);
assertEquals("0",result);
assertEquals("0",result);
assertEquals("2",result);
}