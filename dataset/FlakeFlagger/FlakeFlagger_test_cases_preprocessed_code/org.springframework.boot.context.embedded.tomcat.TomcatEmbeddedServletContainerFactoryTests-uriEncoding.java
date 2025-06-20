@Test public void uriEncoding() throws Exception {
assertEquals("US-ASCII",tomcat.getConnector().getURIEncoding());
}