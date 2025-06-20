@Test void should_generate_member_index(){
assertEquals(34,index.size());
assertEquals(expected,new HashSet<String>(index));
}