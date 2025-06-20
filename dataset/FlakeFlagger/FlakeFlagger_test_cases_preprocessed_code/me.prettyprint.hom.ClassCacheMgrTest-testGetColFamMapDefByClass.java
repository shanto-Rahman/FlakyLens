@Test public void testGetColFamMapDefByClass(){
assertNotNull(cfMapDef);
assertEquals(MyTestBean.class,cfMapDef.getClazz());
assertEquals("did not find @Id properly","baseId",cfMapDef.getIdPropertyDef().getPropDesc().getName());
}