public void testSameMessageNameInSameProcessFails(){
fail("exception expected: Cannot have more than one message event subscription with name 'newInvoiceMessage' for scope");
}