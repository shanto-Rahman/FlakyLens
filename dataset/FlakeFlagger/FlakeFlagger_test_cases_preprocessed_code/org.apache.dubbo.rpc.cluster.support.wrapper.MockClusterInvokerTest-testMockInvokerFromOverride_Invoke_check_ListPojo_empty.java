@SuppressWarnings("unchecked") @Test public void testMockInvokerFromOverride_Invoke_check_ListPojo_empty(){
Assert.assertEquals(0,((List<User>)ret.getValue()).size());
}