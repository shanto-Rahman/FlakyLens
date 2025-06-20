/** 
 * Tests a link area inside a transformed element in the page margin.
 */
@Test public void testLinkAreaPageMarginTransform() throws IOException {
assertEquals(1,doc.getPage(0).getAnnotations().size());
assertEquals(1,doc.getPage(1).getAnnotations().size());
assertThat(link.getRectangle(),rectEquals(new PDRectangle(170f,70f,10f,30f),100d));
assertThat(link.getRectangle(),rectEquals(new PDRectangle(170f,70f,10f,30f),100d));
}