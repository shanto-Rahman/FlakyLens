public void testStandaloneTaskEvents() throws JsonParseException, JsonMappingException, IOException {
assertEquals(4,events.size());
assertEquals("TASK_CREATED",events.get(0).getType());
assertEquals("TASK_ASSIGNED",events.get(1).getType());
assertEquals("TASK_ASSIGNED",events.get(2).getType());
assertEquals("TASK_ASSIGNED",events.get(3).getType());
assertEquals("myTenant",data.get(Fields.TENANT_ID));
}