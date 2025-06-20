public void testVerifyModelProperties(){
assertEquals("my model",modelOne.getName());
assertEquals(modelOneId,modelOne.getId());
assertEquals("my model",models.get(0).getName());
assertEquals(1,models.size());
assertEquals(1,repositoryService.createModelQuery().orderByModelId().asc().list().size());
}