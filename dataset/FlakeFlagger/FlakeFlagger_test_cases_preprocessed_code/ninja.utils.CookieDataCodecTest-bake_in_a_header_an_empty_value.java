@Test public void bake_in_a_header_an_empty_value() throws UnsupportedEncodingException {
assertEquals(1,outMap.size());
assertEquals("",outMap.get("a"));
}