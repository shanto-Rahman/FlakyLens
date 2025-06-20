/** 
 * 1. notify twice, the second time notified router rules should completely replace the former one. 2. notify with no router url, do nothing to current routers 3. notify with only one router url, with router=clean, clear all current routers
 */
@Test public void testNotifyRouterUrls(){
if (isScriptUnsupported) return;//RW
Assert.assertEquals(1 + 1,routers.size());
Assert.assertTrue(ScriptRouter.class == routers.get(1).getClass() || ScriptRouter.class == routers.get(0).getClass());
Assert.assertEquals(1 + 1,routers.size());
Assert.assertTrue(ScriptRouter.class == routers.get(1).getClass() || ScriptRouter.class == routers.get(0).getClass());
Assert.assertEquals(0 + 1,routers.size());
}