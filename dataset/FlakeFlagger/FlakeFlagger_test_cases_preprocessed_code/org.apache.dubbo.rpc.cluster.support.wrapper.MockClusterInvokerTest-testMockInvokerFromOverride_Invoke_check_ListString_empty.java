@SuppressWarnings("unchecked") @Test public void testMockInvokerFromOverride_Invoke_check_ListString_empty(){
Assert.assertEquals(0,((List<String>)ret.getValue()).size());
}