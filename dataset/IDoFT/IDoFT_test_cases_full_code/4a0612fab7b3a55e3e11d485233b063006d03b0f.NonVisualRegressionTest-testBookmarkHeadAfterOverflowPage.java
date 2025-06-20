/** 
 * Tests that a head bookmark linking to an inline element (on page after overflow page) works. 
 */
@Test public void testBookmarkHeadAfterOverflowPage() throws IOException {
  PDDocument doc=run("bookmark-head-after-overflow-page");
  PDDocumentOutline outline=doc.getDocumentCatalog().getDocumentOutline();
  PDOutlineItem bm=outline.getFirstChild();
  assertThat(bm.getTitle(),equalTo("Test bookmark"));
  assertThat(bm.getDestination(),instanceOf(PDPageXYZDestination.class));
  PDPageXYZDestination dest=(PDPageXYZDestination)bm.getDestination();
  assertEquals(dest.getPage(),doc.getPage(3));
  assertEquals(cssPixelYToPdfPoints(10,50),dest.getTop(),1.0d);
  remove("bookmark-head-after-overflow-page",doc);
}
