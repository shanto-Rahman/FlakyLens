@Test public void testPrefixAndDaemon() throws Exception {
assertThat(t.getName(),allOf(containsString("prefix-"),containsString("-thread-")));
assertTrue(t.isDaemon());
}