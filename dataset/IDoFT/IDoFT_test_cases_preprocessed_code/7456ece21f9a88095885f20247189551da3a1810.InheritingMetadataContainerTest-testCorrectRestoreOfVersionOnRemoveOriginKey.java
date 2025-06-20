@Test public void testCorrectRestoreOfVersionOnRemoveOriginKey(){
Assert.assertEquals(4,byVersion.size());
Assert.assertEquals(bValue,byVersion.get(bKey));
Assert.assertEquals(cValue,byVersion.get(cKey));
Assert.assertEquals(dValue,byVersion.get(dKey));
Assert.assertEquals(eValue,byVersion.get(eKey));
Assert.assertEquals(4,byVersion.size());
Assert.assertEquals(aValue,byVersion.get(aKey));
Assert.assertEquals(bValue,byVersion.get(bKey));
Assert.assertEquals(cValue,byVersion.get(cKey));
Assert.assertEquals(eValue,byVersion.get(eKey));
}