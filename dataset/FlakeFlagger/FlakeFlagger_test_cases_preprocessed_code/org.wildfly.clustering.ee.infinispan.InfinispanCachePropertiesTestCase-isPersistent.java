@Test public void isPersistent(){
if (mode.isDistributed() || mode.isReplicated() || mode.isScattered()) {
Assert.assertTrue(mode.name(),configuration.isPersistent());
Assert.assertFalse(mode.name(),configuration.isPersistent());
}
Assert.assertTrue(new InfinispanCacheProperties(config).isPersistent());
Assert.assertFalse(new InfinispanCacheProperties(passivating).isPersistent());
Assert.assertFalse(new InfinispanCacheProperties(noStore).isPersistent());
}