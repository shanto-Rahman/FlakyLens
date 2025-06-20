@Test public void TestRecurringProcessingModels(){
assertTrue(jsonRequest.contains("recurringProcessingModel\": \"CardOnFile\"\n") || jsonRequest.contains("recurringProcessingModel\": \"CardOnFile\",\n"));
assertTrue(jsonRequest.contains("recurringProcessingModel\": \"Subscription\"\n") || jsonRequest.contains("recurringProcessingModel\": \"Subscription\",\n"));
assertTrue(jsonRequest.contains("recurringProcessingModel\": \"UnscheduledCardOnFile\"\n") || jsonRequest.contains("recurringProcessingModel\": \"UnscheduledCardOnFile\",\n"));
}