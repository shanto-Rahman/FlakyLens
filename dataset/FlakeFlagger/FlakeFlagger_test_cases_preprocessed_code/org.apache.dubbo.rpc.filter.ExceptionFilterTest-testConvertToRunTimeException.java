@SuppressWarnings("unchecked") @Test public void testConvertToRunTimeException(){
Assert.assertFalse(newResult.getException() instanceof HessianException);
Assert.assertEquals(newResult.getException().getClass(),RuntimeException.class);
Assert.assertEquals(newResult.getException().getMessage(),StringUtils.toString(rpcResult.getException()));
}