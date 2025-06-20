@Test public void testSerializeString(){
  String origString="test string";
  String json=JSONSerializeUtils.serializeToJSON(origString,String.class);
  String desString=JSON.parseObject(json,String.class);
  assertEquals(origString,desString);
  String desString1=JSONSerializeUtils.deserializeAs(json,String.class);
  assertEquals(origString,desString1);
  String desString2=JSONSerializeUtils.deserializeAs(origString,String.class);
  assertEquals(origString,desString2);
  Car car=new Car();
  car.setCost(10);
  car.setWeight(1000);
  String carJSON=JSONSerializeUtils.serializeToJSON(car);
  String carJSON1=JSON.toJSONString(car,false);
  assertEquals(carJSON,carJSON1);
  String carString=JSON.parseObject(carJSON,String.class);
  assertJsonEqualsNonStrict(carJSON,carString);
  String carString2=JSONSerializeUtils.deserializeAs(carJSON,String.class);
  assertJsonEqualsNonStrict(carJSON,carString2);
}
