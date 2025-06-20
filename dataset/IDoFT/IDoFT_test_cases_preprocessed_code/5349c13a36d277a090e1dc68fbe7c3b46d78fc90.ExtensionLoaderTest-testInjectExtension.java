@Test public void testInjectExtension(){
Assertions.assertNotNull(injectExtImpl.getSimpleExt());
Assertions.assertNull(injectExtImpl.getSimpleExt1());
Assertions.assertNull(injectExtImpl.getGenericType());
Assertions.assertSame(demoBean,injectExtImpl.getDemo());
}