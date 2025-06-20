@Test public void setAndGet(){
assertEquals(15.3,Iterables.collection(this.repository.findAll("foo")).iterator().next().getValue());
}