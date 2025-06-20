/** 
 * Tests that a link area is created for each page (normal and overflow) that the link appears on.
 */
@Test public void testLinkAreaMultiplePage() throws IOException {
assertEquals(1,doc.getPage(0).getAnnotations().size());
assertEquals(1,doc.getPage(1).getAnnotations().size());
assertEquals(1,doc.getPage(2).getAnnotations().size());
assertEquals(1,doc.getPage(3).getAnnotations().size());
assertThat(link.getRectangle(),rectEquals(new PDRectangle(11f,11f,79f,79f),100d));
assertThat(link.getRectangle(),rectEquals(new PDRectangle(10f,11f,61f,79f),100d));
assertThat(link.getRectangle(),rectEquals(new PDRectangle(11f,10f,79f,71f),100d));
assertThat(link.getRectangle(),rectEquals(new PDRectangle(10f,10f,61f,71f),100d));
}