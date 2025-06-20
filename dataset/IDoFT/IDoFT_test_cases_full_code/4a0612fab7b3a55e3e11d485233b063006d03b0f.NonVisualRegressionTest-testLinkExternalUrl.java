/** 
 * Tests that a link to an external url works correclty.
 */
@Test public void testLinkExternalUrl() throws IOException {
  PDDocument doc=run("link-external-url");
  assertEquals(1,doc.getPage(0).getAnnotations().size());
  assertThat(doc.getPage(0).getAnnotations().get(0),instanceOf(PDAnnotationLink.class));
  PDAnnotationLink link=(PDAnnotationLink)doc.getPage(0).getAnnotations().get(0);
  assertThat(link.getAction(),instanceOf(PDActionURI.class));
  PDActionURI action=(PDActionURI)link.getAction();
  assertEquals("https://openhtmltopdf.com",action.getURI());
  remove("link-external-url",doc);
}
