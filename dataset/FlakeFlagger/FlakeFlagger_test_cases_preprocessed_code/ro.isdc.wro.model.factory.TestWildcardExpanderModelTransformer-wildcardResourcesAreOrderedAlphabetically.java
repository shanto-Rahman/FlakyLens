@Test public void wildcardResourcesAreOrderedAlphabetically(){
Assert.assertEquals(7,changedModel.getGroupByName("group").getResources().size());
Assert.assertEquals("01-xyc.js",FilenameUtils.getName(resources.get(0).getUri()));
Assert.assertEquals("02-xyc.js",FilenameUtils.getName(resources.get(1).getUri()));
Assert.assertEquals("03-jquery-ui.js",FilenameUtils.getName(resources.get(2).getUri()));
Assert.assertEquals("04-xyc.js",FilenameUtils.getName(resources.get(3).getUri()));
Assert.assertEquals("05-xyc.js",FilenameUtils.getName(resources.get(4).getUri()));
Assert.assertEquals("06-xyc.js",FilenameUtils.getName(resources.get(5).getUri()));
Assert.assertEquals("07-jquery-impromptu.js",FilenameUtils.getName(resources.get(6).getUri()));
}