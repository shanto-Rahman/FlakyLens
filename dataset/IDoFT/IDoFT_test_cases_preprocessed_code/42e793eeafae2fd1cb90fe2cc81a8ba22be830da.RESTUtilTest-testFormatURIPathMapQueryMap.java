@Test(dependsOnMethods={"testFormatURIPathMapEmptyQueryMap"}) public void testFormatURIPathMapQueryMap() throws PayPalRESTException {
Assert.assertEquals(uriPath,"/a/b/first/second?query1=value1&query2=value2&");
}