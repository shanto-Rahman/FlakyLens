@Test public void templateQuery(){
  Person davidTuranski=new Person(1L,"David","Turanski");
  this.jsonRegion.put("dave",davidTuranski);
  SelectResults<String> results=this.template.query(String.format("firstname='%s'",davidTuranski.getFirstname()));
  assertEquals(toJson(davidTuranski),results.iterator().next());
}
