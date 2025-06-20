@Test public void tesConcludedLicensetCol() throws Exception {
assertEquals(PackageSheet.DIFFERENT_STRING,getEqualCellValue(row));
assertEquals(getDescribedPackage(doc1).getLicenseConcluded().toString(),getDocCellValue(0,row));
assertEquals(getDescribedPackage(doc2).getLicenseConcluded().toString(),getDocCellValue(1,row));
assertEquals(different,getDocCellValue(2,row));
assertEquals(PackageSheet.EQUAL_STRING,getEqualCellValue(row));
}