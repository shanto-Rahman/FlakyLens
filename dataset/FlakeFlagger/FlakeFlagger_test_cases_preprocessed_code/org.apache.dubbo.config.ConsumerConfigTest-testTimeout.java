@Test public void testTimeout() throws Exception {
assertThat(consumer.getTimeout(),is(10));
assertThat(System.getProperty("sun.rmi.transport.tcp.responseTimeout"),equalTo("10"));
}