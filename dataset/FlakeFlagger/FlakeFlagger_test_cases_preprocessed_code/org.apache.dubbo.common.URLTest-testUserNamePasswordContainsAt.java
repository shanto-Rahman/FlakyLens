@Test public void testUserNamePasswordContainsAt(){
assertNull(url.getProtocol());
assertEquals("ad@min",url.getUsername());
assertEquals("hello@1234",url.getPassword());
assertEquals("10.20.130.230",url.getHost());
assertEquals(20880,url.getPort());
assertEquals("context/path",url.getPath());
assertEquals(2,url.getParameters().size());
assertEquals("1.0.0",url.getParameter("version"));
assertEquals("morgan",url.getParameter("application"));
}