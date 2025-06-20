public void testNewModelPersistence(){
assertNotNull(model);
assertNotNull(model.getId());
assertNotNull(model);
assertEquals("Test model",model.getName());
assertEquals("test",model.getCategory());
assertEquals("meta",model.getMetaInfo());
assertNotNull(model.getCreateTime());
assertEquals(Integer.valueOf(1),model.getVersion());
}