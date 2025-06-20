/** 
 * Tests that a simple body bookmark linking to top of the second page works.
 */
@Test public void testBookmarkBodySimple() throws IOException {
assertThat(bm.getTitle(),equalTo("Test bookmark"));
assertThat(bm.getDestination(),instanceOf(PDPageXYZDestination.class));
assertEquals(dest.getPage(),doc.getPage(1));
assertEquals(doc.getPage(1).getMediaBox().getUpperRightY(),dest.getTop(),1.0d);
}