public void testRemoveStatus(){
assertTrue("Remove failed",result);
assertFalse("No status was removed",it.hasNext());
assertFalse("hasChilden method reported wrong result",status.hasChildren());
assertFalse("Remove result was not false",result);
}