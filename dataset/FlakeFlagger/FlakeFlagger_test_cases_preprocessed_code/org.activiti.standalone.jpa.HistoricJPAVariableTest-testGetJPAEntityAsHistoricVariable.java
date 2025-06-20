@Deployment public void testGetJPAEntityAsHistoricVariable(){
variables.put("simpleEntityFieldAccess",simpleEntityFieldAccess);//RW
assertTrue(value instanceof FieldAccessJPAEntity);
assertEquals(((FieldAccessJPAEntity)value).getValue(),simpleEntityFieldAccess.getValue());//RW
}