@Test public void incrementGroup(){
assertEquals(2,names.size());
assertTrue(names.contains("foo.bar"));
assertEquals(3L,this.repository.findOne("foo.bar").getValue());
}