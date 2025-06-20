public void testUpdateModelPersistence() throws Exception {
assertNotNull(model);
assertNotNull(model.getId());
assertNotNull(model);
assertNotNull(model.getId());
assertEquals("New name",model.getName());
assertEquals("New category",model.getCategory());
assertEquals("test",model.getMetaInfo());
assertNotNull(model.getCreateTime());
assertEquals(Integer.valueOf(2),model.getVersion());
assertEquals("new",new String(repositoryService.getModelEditorSource(model.getId()),"utf-8"));
assertEquals("new",new String(repositoryService.getModelEditorSourceExtra(model.getId()),"utf-8"));
}