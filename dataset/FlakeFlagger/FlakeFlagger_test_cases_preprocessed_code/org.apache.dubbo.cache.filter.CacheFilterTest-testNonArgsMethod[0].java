@Test public void testNonArgsMethod(){
Assert.assertEquals(rpcResult1.getValue(),rpcResult2.getValue());
Assert.assertEquals(rpcResult1.getValue(),"value");
}