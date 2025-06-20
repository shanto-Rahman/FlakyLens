@Test public void isLockOnWrite(){
Assert.assertTrue(new InfinispanCacheProperties(config).isLockOnWrite());
Assert.assertFalse(new InfinispanCacheProperties(optimistic).isLockOnWrite());
Assert.assertFalse(new InfinispanCacheProperties(nonTx).isLockOnWrite());
}