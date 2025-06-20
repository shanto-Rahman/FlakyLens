@Test public void EventRequestTest(){
Assert.assertTrue(bdapiEventRequest.getPartnerAgent() == "partnerAgent");
Assert.assertTrue(bdapiEvent.getEventName() == "Purchase");
Assert.assertTrue(bdapiEvent.getEventTime() == 123124125L);
Assert.assertTrue(bdapiEvent.getDataProcessingOptions().length == 0);
Assert.assertTrue(bdapiEvent.getUserData().getEmail() == "aaa@fb.com");
Assert.assertTrue(bdapiEvent.getCustomData().getValue() == 123.45F);
Assert.assertTrue(bdapiContents.get(0).getId() == "1");
Assert.assertTrue(bdapiContents.get(0).getTax() == 1.2F);
Assert.assertTrue(bdapiContents.get(1).getId() == "2");
Assert.assertTrue(bdapiEvent.getCustomData().getBillingContact().getEmail() == "bbb@fb.com");
Assert.assertTrue(bdapiEvent.getCustomData().getShippingContact().getEmail() == "ccc@fb.com");
Assert.assertTrue(capiEventRequest.getPartnerAgent() == "partnerAgent");
Assert.assertTrue(capiEvent.getEventName() == "Purchase");
Assert.assertTrue(capiEvent.getEventTime() == 123124125L);
Assert.assertTrue(capiEvent.getDataProcessingOptions().length == 0);
Assert.assertTrue(capiEvent.getUserData().getEmail() == "aaa@fb.com");
Assert.assertTrue(capiEvent.getCustomData().getValue() == 123.45F);
Assert.assertTrue(capiContents.get(0).getProductId() == "1");
Assert.assertTrue(capiContents.get(1).getProductId() == "2");
Assert.assertTrue(capiContents.get(1).getBrand() == "brand");
Assert.assertTrue(capiEvent.getCustomData().getCustomProperties().get("Key1") == "Value1");
Assert.assertTrue(bdapiDataJSON.contains(bdapiContentsJSON));
Assert.assertTrue(bdapiDataJSON.contains("\"event_name\":\"Purchase\""));
Assert.assertTrue(capiDataJSON.contains(customPropertiesJSON.substring(1,customPropertiesJSON.length() - 1)));
}