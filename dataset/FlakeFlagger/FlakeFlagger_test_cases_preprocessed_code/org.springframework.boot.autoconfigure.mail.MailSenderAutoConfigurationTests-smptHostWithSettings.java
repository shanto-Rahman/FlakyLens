@Test public void smptHostWithSettings(){
assertEquals(host,bean.getHost());
assertEquals(42,bean.getPort());
assertEquals("john",bean.getUsername());
assertEquals("secret",bean.getPassword());
assertEquals("ISO-9",bean.getDefaultEncoding());
}