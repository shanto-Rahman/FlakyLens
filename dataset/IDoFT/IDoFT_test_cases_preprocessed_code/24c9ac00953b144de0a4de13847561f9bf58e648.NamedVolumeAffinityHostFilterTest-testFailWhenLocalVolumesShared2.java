@Test public void testFailWhenLocalVolumesShared2() throws Throwable {
assertEquals(3,initialHostLinks.size());
if (e == null) {
fail("Expected exception");
}
if (e instanceof LocalizableValidationException) {
assertThat(le.getMessage(),startsWith("Unable to place containers sharing local volumes"));
fail("Expected LocalizableValidationException");
}
}