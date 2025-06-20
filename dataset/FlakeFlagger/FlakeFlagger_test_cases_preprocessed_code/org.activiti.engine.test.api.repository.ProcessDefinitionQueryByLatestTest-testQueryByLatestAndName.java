public void testQueryByLatestAndName() throws Exception {
assertEquals(1,processDefinitions.size());
assertEquals(1,processDefinitions.get(0).getVersion());
assertEquals("testProcess2",processDefinitions.get(0).getKey());
assertEquals(1,processDefinitions.size());
assertEquals(1,processDefinitions.get(0).getVersion());
assertEquals("testProcess2",processDefinitions.get(0).getKey());
}