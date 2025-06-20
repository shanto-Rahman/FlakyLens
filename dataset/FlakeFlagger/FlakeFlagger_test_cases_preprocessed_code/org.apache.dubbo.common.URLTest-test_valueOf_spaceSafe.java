@Test public void test_valueOf_spaceSafe() throws Exception {
assertEquals("http://1.2.3.4:8080/path?key=value1 value2",url.toString());
assertEquals("value1 value2",url.getParameter("key"));
}