@Test public void testMockInvokerFromOverride_Invoke_check_int(){
Assert.assertTrue("result type must be integer but was : " + ret.getValue().getClass(),ret.getValue() instanceof Integer);
Assert.assertEquals(new Integer(1688),(Integer)ret.getValue());
}