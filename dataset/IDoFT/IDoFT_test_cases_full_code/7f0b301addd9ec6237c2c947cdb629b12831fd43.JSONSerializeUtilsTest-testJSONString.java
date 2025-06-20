@Test public void testJSONString(){
  Car car=new Car();
  car.setCost(10);
  car.setWeight(1000);
  String carJSON=JSONSerializeUtils.serializeToJSON(car);
  JSONString jsonString=new JSONString(carJSON);
  System.out.println("1:--\r\n" + carJSON);
  String newJSONString=JSONSerializeUtils.serializeToJSON(jsonString);
  assertEquals(carJSON,newJSONString);
  System.out.println("2:--\r\n" + newJSONString);
  JSONString newJSONString2=JSONSerializeUtils.deserializeAs(newJSONString,JSONString.class);
  assertEquals(carJSON,newJSONString2.toString());
  String address=UUID.randomUUID().toString();
  JSONString jsonAddress=new JSONString(JSONSerializeUtils.serializeToJSON(address));
  String desAddress=JSONSerializeUtils.deserializeAs(jsonAddress,String.class);
  assertEquals(address,desAddress);
  String emptyStr="";
  JSONString emptyJsonStr=new JSONString(JSONSerializeUtils.serializeToJSON(emptyStr));
  String desEmptyStr=JSONSerializeUtils.deserializeAs(emptyJsonStr,String.class);
  assertEquals(emptyStr,desEmptyStr);
  String nullStr=null;
  String nullJson=JSONSerializeUtils.serializeToJSON(nullStr);
  assertNull(nullJson);
}
