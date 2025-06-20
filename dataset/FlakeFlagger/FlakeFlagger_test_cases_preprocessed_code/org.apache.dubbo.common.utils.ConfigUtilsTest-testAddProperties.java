@Test public void testAddProperties() throws Exception {
assertThat((String)ConfigUtils.getProperties().get("key1"),equalTo("value1"));
}