@Test public void templateFindUnique(){
  Person davidTuranski=new Person(1L,"David","Turanski");
  this.jsonRegion.put("dave",davidTuranski);
  String json=this.template.findUnique(String.format("SELECT * FROM %s WHERE firstname=$1",this.jsonRegion.getFullPath()),davidTuranski.getFirstname());
  assertEquals(toJson(davidTuranski),json);
}
