@Test public void shouldNotReturnDuplicatedResources(){
assertEquals(0,new WroModelInspector(model).getAllUniqueResources().size());
assertEquals(1,new WroModelInspector(model).getAllUniqueResources().size());
}