/** 
 * Tests that a link to an external url works correclty.
 */
@Test public void testLinkExternalUrl() throws IOException {
assertEquals(1,doc.getPage(0).getAnnotations().size());
assertThat(doc.getPage(0).getAnnotations().get(0),instanceOf(PDAnnotationLink.class));
assertThat(link.getAction(),instanceOf(PDActionURI.class));
assertEquals("https://openhtmltopdf.com",action.getURI());
}