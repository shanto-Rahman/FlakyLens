/** 
 * Tests that link annotation area is correctly rotated.
 */
@Test public void testLinkAreaTransformRotate() throws IOException {
assertEquals(1,doc.getPage(0).getAnnotations().size());
assertThat(doc.getPage(0).getAnnotations().get(0),instanceOf(PDAnnotationLink.class));
assertEquals(11.4375,link.getRectangle().getLowerLeftX(),1.0d);
assertEquals(69.975,link.getRectangle().getLowerLeftY(),1.0d);
assertEquals(117.4875,link.getRectangle().getUpperRightX(),1.0d);
assertEquals(142.5,link.getRectangle().getUpperRightY(),1.0d);
}