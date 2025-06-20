@Test public void onlyValidConstructorsOverwritten(){
Assert.assertNotNull(getInstance(PojoClassFactory.getPojoClass(subClass1)));
}