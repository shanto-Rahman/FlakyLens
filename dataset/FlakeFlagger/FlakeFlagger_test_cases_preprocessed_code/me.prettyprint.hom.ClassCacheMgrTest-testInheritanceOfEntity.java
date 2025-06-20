@Test public void testInheritanceOfEntity(){
assertEquals(13,cfMapDef.getAllProperties().size());
assertNotNull(cfMapDef.getCfBaseMapDef());
assertEquals(MyRedTestBean.class,cfMapDef.getClazz());
assertEquals("TestBeanColumnFamily",cfMapDef.getColFamName());
assertEquals("myType",cfMapDef.getDiscColumn());
assertEquals(DiscriminatorType.STRING,cfMapDef.getDiscType());
assertEquals("baseId",cfMapDef.getIdPropertyDef().getPropDesc().getName());
}