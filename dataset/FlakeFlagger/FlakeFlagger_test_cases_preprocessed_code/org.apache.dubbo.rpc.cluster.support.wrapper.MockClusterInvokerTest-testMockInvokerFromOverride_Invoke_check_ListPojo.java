@SuppressWarnings("unchecked") @Test public void testMockInvokerFromOverride_Invoke_check_ListPojo(){
Assert.assertEquals(2,rl.size());
Assert.assertEquals("hi1",((User)rl.get(0)).getName());//IT
}