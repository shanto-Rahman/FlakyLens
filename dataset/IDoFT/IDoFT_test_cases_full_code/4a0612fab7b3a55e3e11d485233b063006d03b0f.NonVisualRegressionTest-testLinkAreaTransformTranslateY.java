/** 
 * Tests that link annotation area is correctly translated-y.
 */
@Test public void testLinkAreaTransformTranslateY() throws IOException {
  PDDocument doc=run("link-area-transform-translatey");
  assertEquals(1,doc.getPage(0).getAnnotations().size());
  assertThat(doc.getPage(0).getAnnotations().get(0),instanceOf(PDAnnotationLink.class));
  PDAnnotationLink link=(PDAnnotationLink)doc.getPage(0).getAnnotations().get(0);
  assertThat(link.getRectangle(),rectEquals(new PDRectangle(10f,61f,150f,50f),200d));
  remove("link-area-transform-translatey",doc);
}
