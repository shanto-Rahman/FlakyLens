@Test public void testInjectExtension(){
  DemoImpl demoBean=new DemoImpl();
  ApplicationModel.defaultModel().getBeanFactory().registerBean(demoBean);
  InjectExt injectExt=getExtensionLoader(InjectExt.class).getExtension("injection");
  InjectExtImpl injectExtImpl=(InjectExtImpl)injectExt;
  Assertions.assertNotNull(injectExtImpl.getSimpleExt());
  Assertions.assertNull(injectExtImpl.getSimpleExt1());
  Assertions.assertNull(injectExtImpl.getGenericType());
  Assertions.assertSame(demoBean,injectExtImpl.getDemo());
}
