@Test public void testCallSuccessReturnHello() throws InterruptedException, EqCommandTagException {
Thread.sleep(20);
assertTrue(executor.getSourceCommandTagReport().getStatus() == STATUS_OK);
assertEquals(executor.getSourceCommandTagReport().getReturnValue(),"hello");
}