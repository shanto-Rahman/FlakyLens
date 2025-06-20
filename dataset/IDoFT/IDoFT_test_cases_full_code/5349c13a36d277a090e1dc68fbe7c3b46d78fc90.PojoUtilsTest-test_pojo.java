@Test public void test_pojo() throws Exception {
  assertObject(new Person());
  assertObject(new BasicTestData(false,'\0',(byte)0,(short)0,0,0L,0F,0D));
  assertObject(new SerializablePerson(Character.MIN_VALUE,false));
}
