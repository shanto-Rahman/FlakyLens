/** 
 * Tests that a nested head bookmark linking to top of the third page works. 
 */
@Test public void testBookmarkHeadNested() throws IOException {
assertThat(bm1.getTitle(),equalTo("Outer"));
assertThat(bm1.getDestination(),instanceOf(PDPageXYZDestination.class));
assertEquals(dest1.getPage(),doc.getPage(1));
assertEquals(doc.getPage(1).getMediaBox().getUpperRightY(),dest1.getTop(),1.0d);
assertThat(bm2.getTitle(),equalTo("Inner"));
assertThat(bm2.getDestination(),instanceOf(PDPageXYZDestination.class));
assertEquals(dest2.getPage(),doc.getPage(2));
assertEquals(doc.getPage(2).getMediaBox().getUpperRightY(),dest2.getTop(),1.0d);
}