public void testMissingFilter() throws Exception {
fail("Should have failed without configured filter");
assertEquals("{\"a\":\"a\",\"b\":\"b\"}",json);
}