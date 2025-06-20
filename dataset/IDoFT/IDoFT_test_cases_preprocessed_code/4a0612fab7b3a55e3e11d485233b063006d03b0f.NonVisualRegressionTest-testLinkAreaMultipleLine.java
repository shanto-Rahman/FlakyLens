/** 
 * Tests that an inline link over multiple lines generates at least one link annotation for each line.
 */
@Test public void testLinkAreaMultipleLine() throws IOException {
assertEquals(2,doc.getPage(0).getAnnotations().size());
assertEquals(6.0,link.getRectangle().getLowerLeftX(),1.0d);
assertEquals(130.012,link.getRectangle().getLowerLeftY(),1.0d);
assertEquals(138.6,link.getRectangle().getUpperRightX(),1.0d);
assertEquals(144.0,link.getRectangle().getUpperRightY(),1.0d);
assertEquals(6.0,link.getRectangle().getLowerLeftX(),1.0d);
assertEquals(116.02,link.getRectangle().getLowerLeftY(),1.0d);
assertEquals(101.13,link.getRectangle().getUpperRightX(),1.0d);
assertEquals(130.01,link.getRectangle().getUpperRightY(),1.0d);
}