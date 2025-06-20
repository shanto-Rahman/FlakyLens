@Test public void testMockInvokerFromOverride_Invoke_check_String(){
Assert.assertTrue("result type must be String but was : " + ret.getValue().getClass(),ret.getValue() instanceof String);
Assert.assertEquals("1688",(String)ret.getValue());
}