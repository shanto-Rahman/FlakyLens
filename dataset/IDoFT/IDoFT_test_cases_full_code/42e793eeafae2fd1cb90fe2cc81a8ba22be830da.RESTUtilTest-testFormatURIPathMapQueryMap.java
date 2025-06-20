@Test(dependsOnMethods={"testFormatURIPathMapEmptyQueryMap"}) public void testFormatURIPathMapQueryMap() throws PayPalRESTException {
  String pattern="/a/b/first/second";
  Map<String,String> pathParameters=new HashMap<String,String>();
  Map<String,String> queryParameters=new HashMap<String,String>();
  queryParameters.put("query1","value1");
  queryParameters.put("query2","value2");
  String uriPath=RESTUtil.formatURIPath(pattern,pathParameters,queryParameters);
  Assert.assertEquals(uriPath,"/a/b/first/second?query1=value1&query2=value2&");
}
