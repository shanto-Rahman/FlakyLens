/** 
 * Tests a link element inside a transformed element in the page content.
 */
@Test public void testLinkAreaTransformNested() throws IOException {
  PDDocument doc=run("link-area-transform-nested");
  assertEquals(1,doc.getPage(0).getAnnotations().size());
  assertThat(doc.getPage(0).getAnnotations().get(0),instanceOf(PDAnnotationLink.class));
  PDAnnotationLink link=(PDAnnotationLink)doc.getPage(0).getAnnotations().get(0);
  assertThat(link.getRectangle(),rectEquals(new PDRectangle(60f,62f,50f,100f),200d));
  remove("link-area-transform-nested",doc);
}
