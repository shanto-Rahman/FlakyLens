@Test public void testInheritanceOfNonEntity(){
assertEquals(2,cfMapDef.getAllProperties().size());
assertNull(cfMapDef.getCfBaseMapDef());
assertEquals(MyPurpleTestBean.class,cfMapDef.getClazz());
}