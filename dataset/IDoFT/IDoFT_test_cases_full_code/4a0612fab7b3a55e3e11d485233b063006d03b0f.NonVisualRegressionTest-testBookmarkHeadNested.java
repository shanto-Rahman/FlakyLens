/** 
 * Tests that a nested head bookmark linking to top of the third page works. 
 */
@Test public void testBookmarkHeadNested() throws IOException {
  PDDocument doc=run("bookmark-head-nested");
  PDDocumentOutline outline=doc.getDocumentCatalog().getDocumentOutline();
  PDOutlineItem bm1=outline.getFirstChild();
  assertThat(bm1.getTitle(),equalTo("Outer"));
  assertThat(bm1.getDestination(),instanceOf(PDPageXYZDestination.class));
  PDPageXYZDestination dest1=(PDPageXYZDestination)bm1.getDestination();
  assertEquals(dest1.getPage(),doc.getPage(1));
  assertEquals(doc.getPage(1).getMediaBox().getUpperRightY(),dest1.getTop(),1.0d);
  PDOutlineItem bm2=bm1.getFirstChild();
  assertThat(bm2.getTitle(),equalTo("Inner"));
  assertThat(bm2.getDestination(),instanceOf(PDPageXYZDestination.class));
  PDPageXYZDestination dest2=(PDPageXYZDestination)bm2.getDestination();
  assertEquals(dest2.getPage(),doc.getPage(2));
  assertEquals(doc.getPage(2).getMediaBox().getUpperRightY(),dest2.getTop(),1.0d);
  remove("bookmark-head-nested",doc);
}
