/** 
 * Tests that a link can successfully target a destination comprised of an inline element. 
 */
@Test public void testLinkInlineTarget() throws IOException {
  PDDocument doc=run("link-inline-target");
  PDAnnotationLink link=(PDAnnotationLink)doc.getPage(0).getAnnotations().get(0);
  assertThat(link.getAction(),instanceOf(PDActionGoTo.class));
  PDActionGoTo action=(PDActionGoTo)link.getAction();
  assertThat(action.getDestination(),instanceOf(PDPageXYZDestination.class));
  PDPageXYZDestination dest=(PDPageXYZDestination)action.getDestination();
  assertEquals(doc.getPage(1),dest.getPage());
  assertEquals(cssPixelYToPdfPoints(0,100),dest.getTop(),1.0d);
  remove("link-inline-target",doc);
}
