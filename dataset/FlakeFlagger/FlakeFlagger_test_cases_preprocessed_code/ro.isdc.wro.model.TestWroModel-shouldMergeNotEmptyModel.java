@Test public void shouldMergeNotEmptyModel(){
assertEquals(Arrays.asList("anEmptyGroup","g1","g2","g3"),new WroModelInspector(victim).getGroupNames());
}