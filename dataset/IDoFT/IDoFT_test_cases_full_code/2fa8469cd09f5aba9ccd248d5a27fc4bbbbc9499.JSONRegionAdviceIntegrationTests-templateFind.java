@Test public void templateFind(){
  Person davidTuranski=new Person(1L,"David","Turanski");
  this.jsonRegion.put("dave",davidTuranski);
  SelectResults<String> results=this.template.find(String.format("SELECT * FROM %s WHERE firstname=$1",this.jsonRegion.getFullPath()),davidTuranski.getFirstname());
  assertEquals(toJson(davidTuranski),results.iterator().next());
}
