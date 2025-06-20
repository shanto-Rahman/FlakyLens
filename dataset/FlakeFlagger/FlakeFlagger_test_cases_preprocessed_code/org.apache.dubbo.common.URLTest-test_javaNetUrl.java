@Test public void test_javaNetUrl() throws Exception {
assertEquals("http",url.getProtocol());
assertEquals("admin:hello1234",url.getUserInfo());//ET
assertEquals("10.20.130.230",url.getHost());//ET
assertEquals(20880,url.getPort());//ET
assertEquals("/context/path",url.getPath());//ET
assertEquals("version=1.0.0&application=morgan",url.getQuery());//ET
assertEquals("anchor1",url.getRef());//ET
assertEquals("admin:hello1234@10.20.130.230:20880",url.getAuthority());//ET
assertEquals("/context/path?version=1.0.0&application=morgan",url.getFile());//ET
}