@SuppressWarnings("unchecked") @Test public void testExecuteSupplier(){
assertTrue(result.isPresent());
assertSame(expected,result.get());
assertFalse(result.isPresent());
}