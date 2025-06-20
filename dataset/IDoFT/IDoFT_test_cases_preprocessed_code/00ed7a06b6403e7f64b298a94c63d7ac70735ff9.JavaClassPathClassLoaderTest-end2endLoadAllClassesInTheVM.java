@Test public void end2endLoadAllClassesInTheVM(){
Assert.assertTrue(types.contains(PojoClassFactory.getPojoClass(this.getClass())));
Assert.assertThat(reason,types.size(),greaterThan(minExpectedTotalClasses));
}