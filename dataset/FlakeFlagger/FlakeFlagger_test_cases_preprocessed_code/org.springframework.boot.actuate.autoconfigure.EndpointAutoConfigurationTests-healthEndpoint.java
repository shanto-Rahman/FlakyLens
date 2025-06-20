@Test public void healthEndpoint(){
assertNotNull(bean);
assertNotNull(result);
assertTrue("Wrong result: " + result,result.getDetails().containsKey("db"));
}