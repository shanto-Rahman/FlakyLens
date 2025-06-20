@Test public void testGetColFamMapDefByClassAnonymousClassOK(){
assertTrue(tmplMap.get(1L).getClass().isAnonymousClass());
assertNotNull(cfMapDef);
assertEquals(MyTestBean.class,cfMapDef.getClazz());
}