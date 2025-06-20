@Test public void flash_cookies_should_bake_in_a_header_and_value() throws UnsupportedEncodingException {
assertEquals(1,outMap.size());
assertEquals("b",outMap.get("a"));
}