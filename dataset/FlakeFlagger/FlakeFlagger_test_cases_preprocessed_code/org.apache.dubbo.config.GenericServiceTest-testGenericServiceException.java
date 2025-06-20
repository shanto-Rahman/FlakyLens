@Test public void testGenericServiceException(){
if ("sayName".equals(method)) {
}
if ("throwDemoException".equals(method)) {
}
if ("getUsers".equals(method)) {
}
Assert.assertEquals("Generic Haha",demoService.sayName("Haha"));
Assert.assertEquals("Aaa",users.get(0).getName());
Assert.fail();
Assert.assertEquals("Generic",e.getMessage());
}