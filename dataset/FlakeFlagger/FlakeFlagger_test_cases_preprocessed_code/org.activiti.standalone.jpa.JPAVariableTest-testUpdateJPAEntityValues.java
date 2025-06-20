@Deployment public void testUpdateJPAEntityValues(){
variables.put("entityToUpdate",entityToUpdate);//RW
assertTrue(updatedEntity instanceof FieldAccessJPAEntity);
assertEquals("updatedValue",((FieldAccessJPAEntity)updatedEntity).getValue());
}