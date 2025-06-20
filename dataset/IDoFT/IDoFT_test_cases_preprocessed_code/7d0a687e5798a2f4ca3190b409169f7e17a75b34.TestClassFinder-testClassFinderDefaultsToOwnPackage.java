@Test public void testClassFinderDefaultsToOwnPackage() throws Exception {
ClassFinder allClassesFinder=new ClassFinder(classLoader);//RW
assertEquals(pkgClassesArray.length,defaultClassesArray.length);
assertThat(pkgClassesArray,arrayContainingInAnyOrder(defaultClassesArray));
}