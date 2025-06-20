@Test public void shouldCorrectlyDetectFilesFromFoldersWithDirectoriesOnlyAsChildren(){
Assert.assertEquals(2,changedModel.getGroupByName("group").getResources().size());
Assert.assertEquals(resultPathPrefix + "/folder1/script1.js",changedModel.getGroupByName("group").getResources().get(0).getUri());
Assert.assertEquals(resultPathPrefix + "/folder2/script2.js",changedModel.getGroupByName("group").getResources().get(1).getUri());
}