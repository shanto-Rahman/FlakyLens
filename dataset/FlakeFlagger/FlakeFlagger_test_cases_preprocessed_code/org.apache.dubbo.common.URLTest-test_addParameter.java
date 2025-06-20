@Test public void test_addParameter() throws Exception {
assertEquals("dubbo",url.getProtocol());
assertEquals("admin",url.getUsername());
assertEquals("hello1234",url.getPassword());
assertEquals("10.20.130.230",url.getHost());
assertEquals(20880,url.getPort());
assertEquals("context/path",url.getPath());
assertEquals(2,url.getParameters().size());
assertEquals("morgan",url.getParameter("application"));
assertEquals("v1",url.getParameter("k1"));
}