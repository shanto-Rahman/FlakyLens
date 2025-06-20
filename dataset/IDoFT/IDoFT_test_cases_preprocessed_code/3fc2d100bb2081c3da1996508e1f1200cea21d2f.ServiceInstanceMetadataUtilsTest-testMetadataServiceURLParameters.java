@Test public void testMetadataServiceURLParameters(){
List<URL> urls=Arrays.asList(url,url2);//RW
urls.forEach(url -> //RW
JSONObject map=jsonObject.getJSONObject(url.getProtocol());//RW
for (Map.Entry<String,String> param : url.getParameters().entrySet()) //RW
if (value != null) {
assertEquals(param.getValue(),value);
}
assertEquals(VALUE,parameter);
}