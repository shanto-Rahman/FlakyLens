@Test public void testItWithNotExistClass() throws Exception {
assertThat(result.getException().getMessage(),is("Not found class test, cause: test"));
}