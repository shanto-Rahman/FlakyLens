@SuppressWarnings("unchecked") @Test public void testExecuteExceptionSupplier() throws Exception {
assertTrue(result.isPresent());
assertSame(expected,result.get());
fail("Should have thrown an exception");
assertNotNull(e);
assertFalse(result.isPresent());
}