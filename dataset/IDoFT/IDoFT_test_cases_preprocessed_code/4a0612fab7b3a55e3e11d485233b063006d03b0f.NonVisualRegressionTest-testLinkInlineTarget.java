/** 
 * Tests that a link can successfully target a destination comprised of an inline element. 
 */
@Test public void testLinkInlineTarget() throws IOException {
assertThat(link.getAction(),instanceOf(PDActionGoTo.class));
assertThat(action.getDestination(),instanceOf(PDPageXYZDestination.class));
assertEquals(doc.getPage(1),dest.getPage());
assertEquals(cssPixelYToPdfPoints(0,100),dest.getTop(),1.0d);
}