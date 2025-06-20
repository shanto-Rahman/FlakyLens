@Test public void shouldDecorateCacheStrategy(){
Assert.assertTrue(victim instanceof DefaultWroModelFactoryDecorator);
Assert.assertSame(original,((ObjectDecorator<?>)victim).getDecoratedObject());
}