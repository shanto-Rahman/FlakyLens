@Test public void objectToJSon() throws IOException {
  Person davidTuranski=new Person(1L,"David","Turanski");
  this.jsonRegion.put("dave",davidTuranski);
  String json=String.valueOf(this.jsonRegion.get("dave"));
  assertEquals(json,toJson(davidTuranski));
  Object result=jsonRegion.put("dave",davidTuranski);
  assertEquals(toJson(davidTuranski),result);
}
