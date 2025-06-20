@Test public void shouldContainOnlyOneResourceWhenSameIsAddedTwice(){
assertEquals(1,victim.list().size());
assertEquals(resource,victim.list().iterator().next());
}