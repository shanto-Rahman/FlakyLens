@Test public void testDubbo1UrlWithGenericInvocation(){
Assert.assertEquals(1,invokers.size());
Assert.assertEquals(serviceURL.setPath(service).addParameters("check","false","interface",DemoService.class.getName()),invokers.get(0).getUrl());
}