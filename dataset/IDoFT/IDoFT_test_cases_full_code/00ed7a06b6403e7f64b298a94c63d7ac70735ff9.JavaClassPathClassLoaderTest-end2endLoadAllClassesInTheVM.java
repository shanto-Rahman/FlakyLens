@Test public void end2endLoadAllClassesInTheVM(){
  List<PojoClass> types=PojoClassFactory.getPojoClassesRecursively("",null);
  Assert.assertTrue(types.contains(PojoClassFactory.getPojoClass(this.getClass())));
  final String reason="Loaded " + types.size() + " classes instead of expected "+ minExpectedTotalClasses;
  Assert.assertThat(reason,types.size(),greaterThan(minExpectedTotalClasses));
  checkListOfPojoClassesContains(types,java.rmi.registry.LocateRegistry.class);
}
