@Test public void follow20Redirects() throws Exception {
assertEquals(server.getUrl("/20"),connection.getURL());
}