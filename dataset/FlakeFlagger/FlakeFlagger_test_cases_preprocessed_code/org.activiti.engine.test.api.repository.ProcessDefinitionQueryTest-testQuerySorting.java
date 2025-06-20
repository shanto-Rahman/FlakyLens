public void testQuerySorting(){
assertEquals(3,processDefinitions.size());
assertEquals("one",processDefinitions.get(0).getKey());
assertEquals(2,processDefinitions.get(0).getVersion());
assertEquals("one",processDefinitions.get(1).getKey());
assertEquals(1,processDefinitions.get(1).getVersion());
assertEquals("two",processDefinitions.get(2).getKey());
assertEquals(1,processDefinitions.get(2).getVersion());
}