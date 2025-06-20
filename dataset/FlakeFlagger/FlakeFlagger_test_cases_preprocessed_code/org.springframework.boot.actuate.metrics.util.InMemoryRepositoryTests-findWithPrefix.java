@Test public void findWithPrefix(){
assertEquals(3,((Collection<?>)this.repository.findAllWithPrefix("foo")).size());
}