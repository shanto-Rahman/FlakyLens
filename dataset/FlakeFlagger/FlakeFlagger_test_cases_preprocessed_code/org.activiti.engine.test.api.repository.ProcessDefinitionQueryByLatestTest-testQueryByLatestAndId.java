public void testQueryByLatestAndId() throws Exception {
assertEquals(0,processDefinitions.size());
assertEquals(1,processDefinitions.size());
assertEquals("testProcess1",processDefinitions.get(0).getKey());
assertEquals(1,processDefinitions.size());
assertEquals("testProcess2",processDefinitions.get(0).getKey());
}