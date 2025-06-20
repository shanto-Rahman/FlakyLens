@Test public void testNoListenerInWebXml() throws Exception {
Assert.assertEquals(1,context.getApplicationLifecycleListeners().length);
Assert.assertTrue(context.getApplicationLifecycleListeners()[0] instanceof ContextLoaderListener);
}