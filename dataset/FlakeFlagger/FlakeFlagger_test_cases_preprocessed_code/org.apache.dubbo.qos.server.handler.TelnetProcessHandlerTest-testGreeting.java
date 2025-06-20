@Test public void testGreeting() throws Exception {
assertThat(captor.getValue(),containsString("greeting"));
assertThat(captor.getValue(),containsString("dubbo>"));
}