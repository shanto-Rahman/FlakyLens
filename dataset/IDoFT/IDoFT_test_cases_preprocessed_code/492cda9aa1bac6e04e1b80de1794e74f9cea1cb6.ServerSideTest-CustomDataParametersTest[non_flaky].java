@Test public void CustomDataParametersTest(){
mp.forEach((key,value) -> Assert.assertTrue(serializedPayload.contains("\"" + key + "\":"+ "\""+ value+ "\"")));
Assert.assertTrue(serializedPayload.contains(serializedContents));
Assert.assertTrue(serializedPayload.contains(serializedContentIds));
Assert.assertTrue(serializedPayload.contains(currency.toLowerCase()));
Assert.assertTrue(serializedPayload.contains(contentCategory));
Assert.assertTrue(serializedPayload.contains(contentName));
Assert.assertTrue(serializedPayload.contains(DeliveryCategory.curbside.toString()));
}