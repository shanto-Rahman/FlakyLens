@Test public void bake_in_a_header_a_Unicode_value() throws UnsupportedEncodingException {
assertEquals(1,outMap.size(),1);
assertEquals("\u0000",outMap.get("a"));
}