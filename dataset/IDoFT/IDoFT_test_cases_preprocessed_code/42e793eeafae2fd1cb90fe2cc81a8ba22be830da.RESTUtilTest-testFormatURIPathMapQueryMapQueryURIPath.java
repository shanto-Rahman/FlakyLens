@Test(dependsOnMethods={"testFormatURIPathMapQueryMap"}) public void testFormatURIPathMapQueryMapQueryURIPath() throws PayPalRESTException {
Assert.assertEquals(uriPath,"/a/b/first/second?query1=value1&query2=value2&");
}