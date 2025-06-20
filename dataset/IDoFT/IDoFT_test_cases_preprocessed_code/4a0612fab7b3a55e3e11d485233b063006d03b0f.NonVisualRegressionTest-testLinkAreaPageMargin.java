/** 
 * Tests a link area in the page margin.
 */
@Test public void testLinkAreaPageMargin() throws IOException {
assertEquals(1,doc.getPage(0).getAnnotations().size());
assertEquals(1,doc.getPage(1).getAnnotations().size());
assertThat(link.getRectangle(),rectEquals(new PDRectangle(170f,80f,30f,10f),100d));
assertThat(link.getRectangle(),rectEquals(new PDRectangle(170f,80f,30f,10f),100d));
}