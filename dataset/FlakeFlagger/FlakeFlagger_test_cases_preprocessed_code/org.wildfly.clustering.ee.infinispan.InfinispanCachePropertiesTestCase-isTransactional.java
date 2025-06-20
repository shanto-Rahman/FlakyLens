@Test public void isTransactional(){
Assert.assertTrue(new InfinispanCacheProperties(config).isTransactional());
Assert.assertFalse(new InfinispanCacheProperties(config).isTransactional());
}