@Test public void test_valueOf_Exception_noProtocol() throws Exception {
fail();
assertEquals("url missing protocol: \"://1.2.3.4:8080/path\"",expected.getMessage());
}