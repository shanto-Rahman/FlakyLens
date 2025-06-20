@Test public void testExtensionFactory(){
Assert.assertTrue(factory instanceof ExtensionFactory);
Assert.assertTrue(factory instanceof com.alibaba.dubbo.common.extension.ExtensionFactory);
Assert.assertTrue(factory instanceof MyExtensionFactory);
Assert.assertTrue(spring instanceof ExtensionFactory);
Assert.assertFalse(spring instanceof com.alibaba.dubbo.common.extension.ExtensionFactory);
fail();
}