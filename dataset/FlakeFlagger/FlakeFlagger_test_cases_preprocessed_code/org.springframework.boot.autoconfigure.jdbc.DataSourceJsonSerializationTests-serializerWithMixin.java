@Test public void serializerWithMixin() throws Exception {
assertTrue(value.contains("\"url\":"));
assertEquals(1,StringUtils.countOccurrencesOf(value,"\"url\""));
}