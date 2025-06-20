@Test public void testLoadProperties() throws Exception {
assertThat((String)p.get("dubbo"),equalTo("properties"));
}