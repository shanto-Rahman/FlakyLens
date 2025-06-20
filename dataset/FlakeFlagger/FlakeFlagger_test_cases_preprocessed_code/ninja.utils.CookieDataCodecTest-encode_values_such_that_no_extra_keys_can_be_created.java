@Test public void encode_values_such_that_no_extra_keys_can_be_created() throws UnsupportedEncodingException {
assertEquals(1,outMap.size());
assertEquals("b&c=d",outMap.get("a"));
}