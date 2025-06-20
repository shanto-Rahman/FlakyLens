@Test public void testCacheType(){
Assert.assertTrue(Jboot.getCache().getClass() == JbootRedisCacheImpl.class);
}