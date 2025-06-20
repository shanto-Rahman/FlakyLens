@Test public void testCorrectRemoveOfVersionWithNoOriginKey(){
Assert.assertEquals(3,byVersion.size());
Assert.assertEquals(bValue,byVersion.get(bKey));
Assert.assertEquals(cValue,byVersion.get(cKey));
Assert.assertEquals(dValue,byVersion.get(dKey));
Assert.assertEquals(3,byVersion.size());
Assert.assertEquals(aValue,byVersion.get(aKey));
Assert.assertEquals(bValue,byVersion.get(bKey));
Assert.assertEquals(cValue,byVersion.get(cKey));
}