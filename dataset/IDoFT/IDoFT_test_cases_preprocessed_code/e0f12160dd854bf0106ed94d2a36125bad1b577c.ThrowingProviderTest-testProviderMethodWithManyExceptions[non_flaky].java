@Test public void testProviderMethodWithManyExceptions(){
fail();
assertEquals(new HashSet(){
{
    add(expected1);
    add(expected2);
  }
}
,new HashSet(){
{
    add(errors.get(0).getMessage());
    add(errors.get(1).getMessage());
  }
}
);
assertEquals(2,errors.size());
}