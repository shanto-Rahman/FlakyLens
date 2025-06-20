@Test public void testClassFinderDefaultsToOwnPackage() throws Exception {
  ClassFinder allClassesFinder=new ClassFinder(classLoader);
  Set<Class<?>> pkgClasses=allClassesFinder.findClasses(ClassFinder.class.getPackage().getName(),false);
  Set<Class<?>> defaultClasses=allClassesFinder.findClasses(false);
  Object[] pkgClassesArray=pkgClasses.toArray();
  Object[] defaultClassesArray=defaultClasses.toArray();
  assertEquals(pkgClassesArray.length,defaultClassesArray.length);
  assertThat(pkgClassesArray,arrayContainingInAnyOrder(defaultClassesArray));
}
