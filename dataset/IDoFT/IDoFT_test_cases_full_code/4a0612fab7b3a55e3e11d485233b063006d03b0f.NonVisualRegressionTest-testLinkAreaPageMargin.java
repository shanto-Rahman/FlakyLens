/** 
 * Tests a link area in the page margin.
 */
@Test public void testLinkAreaPageMargin() throws IOException {
  PDDocument doc=run("link-area-page-margin");
  assertEquals(1,doc.getPage(0).getAnnotations().size());
  assertEquals(1,doc.getPage(1).getAnnotations().size());
  PDAnnotationLink link=(PDAnnotationLink)doc.getPage(0).getAnnotations().get(0);
  assertThat(link.getRectangle(),rectEquals(new PDRectangle(170f,80f,30f,10f),100d));
  link=(PDAnnotationLink)doc.getPage(1).getAnnotations().get(0);
  assertThat(link.getRectangle(),rectEquals(new PDRectangle(170f,80f,30f,10f),100d));
  remove("link-area-page-margin",doc);
}
