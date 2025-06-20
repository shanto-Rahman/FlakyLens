@Deployment public void testGetJPAEntityAsHistoricLog(){
variables.put("simpleEntityFieldAccess",simpleEntityFieldAccess);//RW
assertTrue(value instanceof FieldAccessJPAEntity);
assertEquals(((FieldAccessJPAEntity)value).getValue(),simpleEntityFieldAccess.getValue());//RW
}