@Test public void testExceptionToStringWithMessage() throws Exception {
assertThat(s,containsString("greeting"));
assertThat(s,containsString("java.lang.RuntimeException: abc"));
}