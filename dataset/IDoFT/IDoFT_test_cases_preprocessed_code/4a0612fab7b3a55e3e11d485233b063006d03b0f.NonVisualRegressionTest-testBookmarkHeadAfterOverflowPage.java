/** 
 * Tests that a head bookmark linking to an inline element (on page after overflow page) works. 
 */
@Test public void testBookmarkHeadAfterOverflowPage() throws IOException {
assertThat(bm.getTitle(),equalTo("Test bookmark"));
assertThat(bm.getDestination(),instanceOf(PDPageXYZDestination.class));
assertEquals(dest.getPage(),doc.getPage(3));
assertEquals(cssPixelYToPdfPoints(10,50),dest.getTop(),1.0d);
}