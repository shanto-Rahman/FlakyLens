/** 
 * Tests that a head bookmark linking to element (on overflow page). 
 */
@Test public void testBookmarkHeadOnOverflowPage() throws IOException {
assertThat(bm.getTitle(),equalTo("Test bookmark"));
assertThat(bm.getDestination(),instanceOf(PDPageXYZDestination.class));
assertEquals(dest.getPage(),doc.getPage(2));
assertEquals(cssPixelYToPdfPoints(11,50),dest.getTop(),1.0d);
}