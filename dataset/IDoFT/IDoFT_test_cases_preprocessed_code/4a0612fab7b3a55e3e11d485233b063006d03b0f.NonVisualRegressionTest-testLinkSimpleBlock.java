/** 
 * Tests that a simple block link successfully links to a simple block target on second page. 
 */
@Test public void testLinkSimpleBlock() throws IOException {
assertEquals(1,doc.getPage(0).getAnnotations().size());
assertThat(doc.getPage(0).getAnnotations().get(0),instanceOf(PDAnnotationLink.class));
assertThat(link.getRectangle(),rectEquals(new PDRectangle(0f,0f,100f,10f),200d));
assertThat(link.getAction(),instanceOf(PDActionGoTo.class));
assertThat(action.getDestination(),instanceOf(PDPageXYZDestination.class));
assertEquals(doc.getPage(1),dest.getPage());
assertEquals(cssPixelYToPdfPoints(0,200),dest.getTop(),1.0d);
}