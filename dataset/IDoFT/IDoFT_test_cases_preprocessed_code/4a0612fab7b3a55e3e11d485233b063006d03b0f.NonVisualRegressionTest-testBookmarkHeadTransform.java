/** 
 * Tests that a head bookmark linking to transformed element (by way of transform) on third page works. 
 */
@Test public void testBookmarkHeadTransform() throws IOException {
assertThat(bm.getTitle(),equalTo("Test bookmark"));
assertThat(bm.getDestination(),instanceOf(PDPageXYZDestination.class));
assertEquals(dest.getPage(),doc.getPage(2));
assertEquals(doc.getPage(2).getMediaBox().getUpperRightY(),dest.getTop(),1.0d);
}