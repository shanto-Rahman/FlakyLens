@Test public void defaultUriEncoding() throws Exception {
assertEquals("UTF-8",tomcat.getConnector().getURIEncoding());
}