@Test public void testAddress() throws Exception {
assertThat(registry.getAddress(),equalTo("localhost"));
assertThat(parameters,not(hasKey("address")));
}