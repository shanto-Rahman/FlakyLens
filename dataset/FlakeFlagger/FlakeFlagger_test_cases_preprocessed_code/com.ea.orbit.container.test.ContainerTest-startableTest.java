@Test public void startableTest(){
assertTrue(hello.startCalled);
assertFalse(hello.stopCalled);
assertTrue(hello.stopCalled);
}