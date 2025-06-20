@Test public void testSerialization() throws Exception {
assertEquals("{\"status\":\"UNKNOWN\",\"db\":{\"status\":\"UNKNOWN\"" + ",\"db1\":{\"status\":\"UNKNOWN\",\"1\":\"1\"}," + "\"db2\":{\"status\":\"UNKNOWN\",\"2\":\"2\"}}}",mapper.writeValueAsString(result));
}