@Test public void findAll(){
assertEquals(2,Iterables.collection(this.repository.findAll()).size());
}