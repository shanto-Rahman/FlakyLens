public void testRoundTrip() throws Exception {
  Map1540Implementation input=new Map1540Implementation();
  input.property=55;
  input.put(6,88);
  input.put(12,45);
  String json=MAPPER.writeValueAsString(input);
  assertEquals(aposToQuotes("{'property':55,'map':{'6':88,'12':45}}"),json);
  Map1540Implementation result=MAPPER.readValue(json,Map1540Implementation.class);
  assertEquals(result.property,input.property);
  assertEquals(input.getMap(),input.getMap());
}
