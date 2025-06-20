/** 
 * Tests that an inline link with multiple inline boxes generates one link annotation for each line. ie. Multiple inline boxes are concatenated into one rect for the purposes of creating a link area.
 */
@Test public void testLinkAreaMultipleBoxes() throws IOException {
  PDDocument doc=run("link-area-multiple-boxes");
  assertEquals(2,doc.getPage(0).getAnnotations().size());
  PDAnnotationLink link=(PDAnnotationLink)doc.getPage(0).getAnnotations().get(0);
  assertEquals(6.0,link.getRectangle().getLowerLeftX(),1.0d);
  assertEquals(130.012,link.getRectangle().getLowerLeftY(),1.0d);
  assertEquals(138.6,link.getRectangle().getUpperRightX(),1.0d);
  assertEquals(144.0,link.getRectangle().getUpperRightY(),1.0d);
  link=(PDAnnotationLink)doc.getPage(0).getAnnotations().get(1);
  assertEquals(6.0,link.getRectangle().getLowerLeftX(),1.0d);
  assertEquals(113.28,link.getRectangle().getLowerLeftY(),1.0d);
  assertEquals(112.57,link.getRectangle().getUpperRightX(),1.0d);
  assertEquals(127.27,link.getRectangle().getUpperRightY(),1.0d);
  remove("link-area-multiple-boxes",doc);
}
