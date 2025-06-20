@Test public void test_NotifiedDubbo1(){
Assert.assertEquals(true,registryDirectory.isAvailable());
Assert.assertEquals(1,invokers.size());
Assert.assertEquals(1,invokers.size());
Assert.assertEquals(DemoService.class.getName(),invokers.get(0).getUrl().getPath());
}