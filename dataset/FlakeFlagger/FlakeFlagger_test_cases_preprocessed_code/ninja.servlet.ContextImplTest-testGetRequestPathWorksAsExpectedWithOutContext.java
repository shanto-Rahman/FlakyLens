@Test public void testGetRequestPathWorksAsExpectedWithOutContext(){
assertEquals("/myapp/is/here",context.getRequestPath());
}