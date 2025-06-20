@Test public void CustomDataParametersTest(){
Assert.assertTrue(serializedPayload.contains(cpString.substring(1,cpString.length() - 1)));
Assert.assertTrue(serializedPayload.contains(serializedContents));
Assert.assertTrue(serializedPayload.contains(serializedContentIds));
Assert.assertTrue(serializedPayload.contains(currency.toLowerCase()));
Assert.assertTrue(serializedPayload.contains(contentCategory));
Assert.assertTrue(serializedPayload.contains(contentName));
Assert.assertTrue(serializedPayload.contains(DeliveryCategory.curbside.toString()));
}