@Test public void isLockOnRead(){
Assert.assertTrue(new InfinispanCacheProperties(config).isLockOnRead());
Assert.assertFalse(new InfinispanCacheProperties(optimistic).isLockOnRead());
Assert.assertFalse(new InfinispanCacheProperties(nonTx).isLockOnRead());
Assert.assertFalse(new InfinispanCacheProperties(readCommitted).isLockOnRead());
}