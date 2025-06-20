@Test public void shouldOrderedAlphabeticallyWildcardResources() throws IOException {
final Collection<String> filenameList=filenameListHolder.get();
Assert.assertNotNull(filenameList);
Assert.assertEquals(Arrays.toString(new String[]{"com/app/level1/level2/styles/style.css","com/app/level1/level2/level2.css","com/app/level1/level1.css"}),Arrays.toString(filenameList.toArray()));
}