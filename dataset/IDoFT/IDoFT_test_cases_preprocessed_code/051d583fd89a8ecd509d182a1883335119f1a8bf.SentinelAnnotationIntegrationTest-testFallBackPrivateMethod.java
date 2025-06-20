@Test public void testFallBackPrivateMethod() throws Exception {
fail("should not reach here");
assertThat(cn.exceptionQps()).isZero();
assertThat(fooService.fooWithPrivateFallback(5763)).isEqualTo("EEE...");
assertThat(fooService.fooWithPrivateFallback(2221)).isEqualTo("Oops, 2221");
}