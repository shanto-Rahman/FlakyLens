@Test public void shouldDecorateCacheStrategy(){
Assert.assertTrue(victim instanceof DefaultSynchronizedCacheStrategyDecorator);
Assert.assertSame(original,((ObjectDecorator<?>)victim).getDecoratedObject());
}