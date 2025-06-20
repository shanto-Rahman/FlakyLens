/** 
 * Tests link area on overflow page is correctly placed.
 */
@Test public void testLinkAreaOverflowPage() throws IOException {
  PDDocument doc=run("link-area-overflow-page");
  assertEquals(0,doc.getPage(0).getAnnotations().size());
  assertThat(doc.getPage(1).getAnnotations().get(0),instanceOf(PDAnnotationLink.class));
  PDAnnotationLink link=(PDAnnotationLink)doc.getPage(1).getAnnotations().get(0);
  assertThat(link.getRectangle(),rectEquals(new PDRectangle(30f,11f,40f,10f),100d));
  remove("link-area-overflow-page",doc);
}
