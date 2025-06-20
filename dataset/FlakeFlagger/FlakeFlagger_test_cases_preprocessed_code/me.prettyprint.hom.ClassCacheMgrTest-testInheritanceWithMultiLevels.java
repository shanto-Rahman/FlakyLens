@Test public void testInheritanceWithMultiLevels(){
assertEquals(5,cfMapDef.getAllProperties().size());
assertNotNull(cfMapDef.getCfSuperMapDef());
assertNotNull(cfMapDef.getCfBaseMapDef());
assertEquals(Desk.class.getSuperclass(),cfMapDef.getCfSuperMapDef().getClazz());
assertEquals(Desk.class.getSuperclass().getSuperclass(),cfMapDef.getCfSuperMapDef().getCfSuperMapDef().getClazz());
assertEquals(cfBaseMapDef.getColFamName(),cfMapDef.getColFamName());
assertEquals("type",cfMapDef.getDiscColumn());
assertEquals("table_desk",cfMapDef.getDiscValue());
assertEquals(DiscriminatorType.STRING,cfMapDef.getDiscType());
assertEquals("id",cfMapDef.getIdPropertyDef().getPropDesc().getName());
}