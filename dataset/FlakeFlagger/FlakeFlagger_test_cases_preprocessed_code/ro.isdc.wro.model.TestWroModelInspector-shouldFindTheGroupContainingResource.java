@Test public void shouldFindTheGroupContainingResource(){
assertEquals(2,groups.size());
assertEquals("[g2, g3]",Arrays.toString(groups.toArray()));
}