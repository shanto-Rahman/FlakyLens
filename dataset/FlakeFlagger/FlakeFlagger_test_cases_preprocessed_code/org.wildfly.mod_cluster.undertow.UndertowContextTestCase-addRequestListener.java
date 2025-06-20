@Test public void addRequestListener() throws ServletException {
assertSame(request,event.getValue().getServletRequest());
assertSame(context,event.getValue().getServletContext());
assertSame(request,event.getValue().getServletRequest());
assertSame(context,event.getValue().getServletContext());
}