@Test(expected=IllegalStateException.class) public void testGetColFamMapDefByClassSubclassNotOK(){
assertFalse(obj.getClass().isAnonymousClass());
}