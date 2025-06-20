@Test public void testToAddress() throws Exception {
assertThat(address.getHostName(),equalTo("localhost"));
assertThat(address.getPort(),equalTo(1234));
assertThat(address.getHostName(),equalTo("localhost"));
assertThat(address.getPort(),equalTo(0));
}