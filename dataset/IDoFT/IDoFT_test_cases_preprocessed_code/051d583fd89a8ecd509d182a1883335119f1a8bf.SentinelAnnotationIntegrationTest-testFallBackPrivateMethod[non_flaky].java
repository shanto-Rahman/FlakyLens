@Test public void testFallBackPrivateMethod() throws Exception {
assertThat(fooService.fooWithPrivateFallback(1)).isEqualTo("Hello for 1");
fail("should not reach here");
assertThat(cn.exceptionQps()).isZero();
assertThat(fooService.fooWithPrivateFallback(5763)).isEqualTo("EEE...");
assertThat(fooService.fooWithPrivateFallback(2221)).isEqualTo("Oops, 2221");
}