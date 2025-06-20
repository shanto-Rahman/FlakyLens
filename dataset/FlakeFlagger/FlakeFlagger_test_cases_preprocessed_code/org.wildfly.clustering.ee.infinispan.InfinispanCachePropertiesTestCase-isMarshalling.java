@Test public void isMarshalling(){
if (mode.isDistributed() || mode.isReplicated() || mode.isScattered()) {
Assert.assertTrue(mode.name(),configuration.isMarshalling());
Assert.assertFalse(mode.name(),configuration.isMarshalling());
}
Assert.assertTrue(new InfinispanCacheProperties(config).isMarshalling());
Assert.assertTrue(new InfinispanCacheProperties(passivating).isMarshalling());
Assert.assertFalse(new InfinispanCacheProperties(noStore).isMarshalling());
}