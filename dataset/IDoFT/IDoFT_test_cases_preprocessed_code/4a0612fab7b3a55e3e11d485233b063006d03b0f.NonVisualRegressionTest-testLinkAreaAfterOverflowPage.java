/** 
 * Tests link area after overflow page is correctly placed.
 */
@Test public void testLinkAreaAfterOverflowPage() throws IOException {
assertEquals(0,doc.getPage(0).getAnnotations().size());
assertEquals(0,doc.getPage(1).getAnnotations().size());
assertEquals(1,doc.getPage(2).getAnnotations().size());
assertThat(doc.getPage(2).getAnnotations().get(0),instanceOf(PDAnnotationLink.class));
assertThat(link.getRectangle(),rectEquals(new PDRectangle(10f,10f,80f,10f),100d));
}