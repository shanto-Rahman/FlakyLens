@Test public void testFindMethodByMethodSignatureNotFound() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("No such method "));
assertThat(expected.getMessage(),containsString("in class"));
}