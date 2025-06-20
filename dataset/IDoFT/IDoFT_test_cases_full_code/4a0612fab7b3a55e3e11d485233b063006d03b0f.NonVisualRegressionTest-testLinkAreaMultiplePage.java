/** 
 * Tests that a link area is created for each page (normal and overflow) that the link appears on.
 */
@Test public void testLinkAreaMultiplePage() throws IOException {
  PDDocument doc=run("link-area-multiple-page");
  assertEquals(1,doc.getPage(0).getAnnotations().size());
  assertEquals(1,doc.getPage(1).getAnnotations().size());
  assertEquals(1,doc.getPage(2).getAnnotations().size());
  assertEquals(1,doc.getPage(3).getAnnotations().size());
  PDAnnotationLink link=(PDAnnotationLink)doc.getPage(0).getAnnotations().get(0);
  assertThat(link.getRectangle(),rectEquals(new PDRectangle(11f,11f,79f,79f),100d));
  link=(PDAnnotationLink)doc.getPage(1).getAnnotations().get(0);
  assertThat(link.getRectangle(),rectEquals(new PDRectangle(10f,11f,61f,79f),100d));
  link=(PDAnnotationLink)doc.getPage(2).getAnnotations().get(0);
  assertThat(link.getRectangle(),rectEquals(new PDRectangle(11f,10f,79f,71f),100d));
  link=(PDAnnotationLink)doc.getPage(3).getAnnotations().get(0);
  assertThat(link.getRectangle(),rectEquals(new PDRectangle(10f,10f,61f,71f),100d));
  remove("link-area-multiple-page",doc);
}
