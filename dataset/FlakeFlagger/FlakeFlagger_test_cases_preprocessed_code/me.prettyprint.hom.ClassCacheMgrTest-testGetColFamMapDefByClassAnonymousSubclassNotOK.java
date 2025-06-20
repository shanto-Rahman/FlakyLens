@Test(expected=IllegalStateException.class) public void testGetColFamMapDefByClassAnonymousSubclassNotOK(){
assertTrue(tmplMap.get(2L).getClass().isAnonymousClass());
}