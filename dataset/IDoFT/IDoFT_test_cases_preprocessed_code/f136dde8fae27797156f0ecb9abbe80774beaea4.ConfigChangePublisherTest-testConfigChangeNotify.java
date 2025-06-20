@Test public void testConfigChangeNotify() throws InterruptedException {
Thread.sleep(2000);
Assert.assertNotNull(reference.get());
Thread.sleep(2000);
Assert.assertNotNull(reference.get());
Thread.sleep(2000);
Assert.assertNull(reference.get());
Thread.sleep(2000);
Assert.assertNotNull(reference.get());
}