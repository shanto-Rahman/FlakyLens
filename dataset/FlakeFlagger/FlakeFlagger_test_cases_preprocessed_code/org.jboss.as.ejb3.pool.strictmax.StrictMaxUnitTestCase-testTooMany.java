@Test public void testTooMany(){
fail("should have thrown an exception");
assertEquals(EjbLogger.ROOT_LOGGER.failedToAcquirePermit(1,TimeUnit.SECONDS).getMessage(),e.getMessage());
assertEquals(10,MockBean.getPostConstructs());
assertEquals(10,MockBean.getPreDestroys());
}