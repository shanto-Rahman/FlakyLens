@Test(expected=IllegalArgumentException.class) public void testUnsubscribeIfNotifyNull() throws Exception {
Assert.fail("unsubscribe listener == null");
}