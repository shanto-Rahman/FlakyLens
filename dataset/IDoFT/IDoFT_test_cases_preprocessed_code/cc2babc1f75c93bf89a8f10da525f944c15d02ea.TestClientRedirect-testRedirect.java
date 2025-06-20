@Test public void testRedirect() throws Exception {
Assert.assertTrue(amContact);
Thread.sleep(5000);
Thread.sleep(5000);
Assert.assertEquals(0,counters.countCounters());
Assert.assertTrue(amContact);
Assert.assertTrue(hsContact);
}