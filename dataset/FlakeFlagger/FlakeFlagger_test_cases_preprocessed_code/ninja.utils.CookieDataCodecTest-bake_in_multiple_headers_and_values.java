@Test public void bake_in_multiple_headers_and_values() throws UnsupportedEncodingException {
assertEquals(outMap.size(),2);
assertEquals("b",outMap.get("a"));
assertEquals("d",outMap.get("c"));
}