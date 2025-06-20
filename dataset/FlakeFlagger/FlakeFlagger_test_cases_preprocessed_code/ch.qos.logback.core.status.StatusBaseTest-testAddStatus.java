public void testAddStatus(){
assertTrue("No status was added",it.hasNext());
assertTrue("hasChilden method reported wrong result",status.hasChildren());
fail("method should have thrown an Exception");
}