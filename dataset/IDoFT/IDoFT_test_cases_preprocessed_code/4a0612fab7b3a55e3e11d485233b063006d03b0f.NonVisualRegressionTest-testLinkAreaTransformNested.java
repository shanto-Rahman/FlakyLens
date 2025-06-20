/** 
 * Tests a link element inside a transformed element in the page content.
 */
@Test public void testLinkAreaTransformNested() throws IOException {
assertEquals(1,doc.getPage(0).getAnnotations().size());
assertThat(doc.getPage(0).getAnnotations().get(0),instanceOf(PDAnnotationLink.class));
assertThat(link.getRectangle(),rectEquals(new PDRectangle(60f,62f,50f,100f),200d));
}