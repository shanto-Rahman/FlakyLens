@Test public void test_getAdaptiveExtension_ExceptionWhenNoUrlAttribute() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("fail to create adaptive class for interface "));
assertThat(expected.getMessage(),containsString(": not found url parameter or url attribute in parameters of method "));
}