@Test public void testFindMethodByMethodSignatureOverrideMoreThan1() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Not unique method for method name("));
}