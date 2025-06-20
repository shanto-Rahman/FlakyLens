public void testNewModelWithSource() throws Exception {
assertNotNull(model.getId());
assertNotNull(model);
assertEquals("Test model",model.getName());
assertEquals("modelsource",new String(editorSourceBytes,"utf-8"));
}