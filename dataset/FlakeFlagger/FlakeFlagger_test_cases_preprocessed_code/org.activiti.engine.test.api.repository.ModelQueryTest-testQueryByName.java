public void testQueryByName() throws Exception {
assertNotNull(model);
assertEquals("bytes",new String(repositoryService.getModelEditorSource(model.getId()),"utf-8"));
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}