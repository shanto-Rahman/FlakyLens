/** 
 * Tests that a simple block link successfully links to an element that is transformed to top of third page.
 */
@Test public void testLinkTransformTarget() throws IOException {
  PDDocument doc=run("link-transform-target");
  assertEquals(1,doc.getPage(0).getAnnotations().size());
  assertThat(doc.getPage(0).getAnnotations().get(0),instanceOf(PDAnnotationLink.class));
  PDAnnotationLink link=(PDAnnotationLink)doc.getPage(0).getAnnotations().get(0);
  assertThat(link.getRectangle(),rectEquals(new PDRectangle(0f,0f,100f,10f),100d));
  assertThat(link.getAction(),instanceOf(PDActionGoTo.class));
  PDActionGoTo action=(PDActionGoTo)link.getAction();
  assertThat(action.getDestination(),instanceOf(PDPageXYZDestination.class));
  PDPageXYZDestination dest=(PDPageXYZDestination)action.getDestination();
  assertEquals(doc.getPage(2),dest.getPage());
  assertEquals(cssPixelYToPdfPoints(0,100),dest.getTop(),1.0d);
  remove("link-transform-target",doc);
}
