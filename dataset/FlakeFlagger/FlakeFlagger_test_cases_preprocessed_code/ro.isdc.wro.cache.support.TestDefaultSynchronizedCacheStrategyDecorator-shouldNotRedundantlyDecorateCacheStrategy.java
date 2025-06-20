/** 
 * Fix Issue 528:  Redundant CacheStrategy decoration (which has unclear cause, but it is safe to prevent redundant decoration anyway).
 */
@Test public void shouldNotRedundantlyDecorateCacheStrategy(){
Assert.assertTrue(victim instanceof DefaultSynchronizedCacheStrategyDecorator);
Assert.assertSame(original,victim);
}