/** 
 * Tests that a simple head bookmark linking to top of the second page works. 
 */
@Test public void testBookmarkHeadSimple() throws IOException {
  PDDocument doc=run("bookmark-head-simple");
  PDDocumentOutline outline=doc.getDocumentCatalog().getDocumentOutline();
  PDOutlineItem bm=outline.getFirstChild();
  assertThat(bm.getTitle(),equalTo("Test bookmark"));
  assertThat(bm.getDestination(),instanceOf(PDPageXYZDestination.class));
  PDPageXYZDestination dest=(PDPageXYZDestination)bm.getDestination();
  assertEquals(dest.getPage(),doc.getPage(1));
  assertEquals(doc.getPage(1).getMediaBox().getUpperRightY(),dest.getTop(),1.0d);
  remove("bookmark-head-simple",doc);
}
