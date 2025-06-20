@Test public void testParametersMerge(){
Assert.assertEquals(null,url.getParameter("key"));
Assert.assertEquals("provider",url.getParameter("key"));
Assert.assertEquals("query",url.getParameter("key"));
Assert.assertEquals(false,url.getParameter(Constants.CHECK_KEY,false));
Assert.assertEquals(LeastActiveLoadBalance.NAME,url.getMethodParameter("get",Constants.LOADBALANCE_KEY));
Assert.assertEquals(null,registryDirectory2.getUrl().getParameter("mock"));
Assert.assertEquals("true",registryDirectory2.getUrl().getParameter("mock"));
}