public void testQueryByTenantIdLike() throws Exception {
assertNotNull(model);
assertEquals("someKey1",model.getKey());
assertEquals("bytes",new String(repositoryService.getModelEditorSource(model.getId()),"utf-8"));
assertEquals(1,query.list().size());
assertEquals(1,query.count());
assertNotNull(model);
assertEquals("someKey2",model.getKey());
assertEquals("bytes",new String(repositoryService.getModelEditorSource(model.getId()),"utf-8"));
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}