@Test(expected=IllegalArgumentException.class) public void testNotifyIfNotifyNull(){
Assert.fail("notify listener == null");
}