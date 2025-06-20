@Test public void testSerialization() throws Exception {
assertThat(mapper.writeValueAsString(result)).isEqualTo("{\"status\":\"UNKNOWN\",\"details\":{\"db\":{\"status\":\"UNKNOWN\"" + ",\"details\":{\"db1\":{\"status\":\"UNKNOWN\",\"details\"" + ":{\"1\":\"1\"}},\"db2\":{\"status\":\"UNKNOWN\",\"details\""+ ":{\"2\":\"2\"}}}}}}");
}