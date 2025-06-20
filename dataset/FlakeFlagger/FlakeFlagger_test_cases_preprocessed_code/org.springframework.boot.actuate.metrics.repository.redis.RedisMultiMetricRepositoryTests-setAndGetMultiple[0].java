@Test public void setAndGetMultiple(){
assertEquals(2,Iterables.collection(this.repository.findAll("foo")).size());
}