@Test public void testHandlerAdded() throws Exception {
assertThat(new String(captor.getValue().array()),containsString("Foreign Ip Not Permitted"));
}