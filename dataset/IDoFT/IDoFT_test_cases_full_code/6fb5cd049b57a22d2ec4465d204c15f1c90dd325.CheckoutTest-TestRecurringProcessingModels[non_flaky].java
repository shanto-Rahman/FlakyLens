@Test public void TestRecurringProcessingModels(){
  PaymentsRequest paymentsRequest=new PaymentsRequest();
  paymentsRequest.setRecurringProcessingModel(PaymentsRequest.RecurringProcessingModelEnum.CARD_ON_FILE);
  String jsonRequest=PRETTY_PRINT_GSON.toJson(paymentsRequest);
  assertTrue(jsonRequest.contains("recurringProcessingModel\": \"CardOnFile\"\n") || jsonRequest.contains("recurringProcessingModel\": \"CardOnFile\",\n"));
  paymentsRequest.setRecurringProcessingModel(PaymentsRequest.RecurringProcessingModelEnum.SUBSCRIPTION);
  jsonRequest=PRETTY_PRINT_GSON.toJson(paymentsRequest);
  assertTrue(jsonRequest.contains("recurringProcessingModel\": \"Subscription\"\n") || jsonRequest.contains("recurringProcessingModel\": \"Subscription\",\n"));
  paymentsRequest.setRecurringProcessingModel(PaymentsRequest.RecurringProcessingModelEnum.UNSCHEDULED_CARD_ON_FILE);
  jsonRequest=PRETTY_PRINT_GSON.toJson(paymentsRequest);
  assertTrue(jsonRequest.contains("recurringProcessingModel\": \"UnscheduledCardOnFile\"\n") || jsonRequest.contains("recurringProcessingModel\": \"UnscheduledCardOnFile\",\n"));
}
