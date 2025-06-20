@Test public void testToQueryUrl(){
  Map<String,String> parameters=new LinkedHashMap<String,String>();
  parameters.put(CommonParams.NAMESPACE_ID,"namespace");
  parameters.put(CommonParams.SERVICE_NAME,"service");
  parameters.put(CommonParams.GROUP_NAME,"group");
  parameters.put(CommonParams.CLUSTER_NAME,null);
  parameters.put("ip","1.1.1.1");
  parameters.put("port",String.valueOf(9999));
  parameters.put("weight",String.valueOf(1.0));
  parameters.put("ephemeral",String.valueOf(true));
  String excepted="namespaceId=namespace&serviceName=service&groupName=group&ip=1.1.1.1&port=9999&weight=1.0&ephemeral=true";
  assertEquals(excepted,Query.newInstance().initParams(parameters).toQueryUrl());
}
