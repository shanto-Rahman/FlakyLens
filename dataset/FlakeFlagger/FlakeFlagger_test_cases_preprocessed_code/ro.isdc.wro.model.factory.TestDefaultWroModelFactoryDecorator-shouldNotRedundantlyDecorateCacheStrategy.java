@Test public void shouldNotRedundantlyDecorateCacheStrategy(){
Assert.assertTrue(victim instanceof DefaultWroModelFactoryDecorator);
Assert.assertSame(original,victim);
}