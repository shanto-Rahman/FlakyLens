@Test public void testSerialize() throws SerializationException {
  GetUserIdSerializableRequest request=new GetUserIdSerializableRequest();
  request.setOperation(InstantAccessOperationValue.GETUSERID);
  request.setInfoField1("nobody@amazon.com");
  request.setInfoField2("AMZN");
  String requestString=serializer.encode(request);
  requestString=requestString.replace("{","").replace("}","").replace("\"","");
  HashMap<String,String> requestMap=new HashMap<String,String>();
  String[] pairs=requestString.split(",");
  for (int i=0; i < pairs.length; i++) {
    String pair=pairs[i];
    String[] keyValue=pair.split(":");
    requestMap.put(keyValue[0],keyValue[1]);
  }
  HashMap<String,String> expected=new HashMap<String,String>();
  expected.put("operation","GetUserId");
  expected.put("infoField1","nobody@amazon.com");
  expected.put("infoField2","AMZN");
  assertEquals(requestMap,expected);
}
