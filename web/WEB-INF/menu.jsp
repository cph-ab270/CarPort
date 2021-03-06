<%@ page import="org.cba.domain.User" %>
<%@ page import="org.cba.model.cart.TemplateCart" %>
<%@ page import="static org.cba.Path.ROOT" %>
<% User loggedUser = ((User) session.getAttribute("user")); %>
<% TemplateCart cart = ((TemplateCart) request.getAttribute("cart")); %>
<nav class="navbar navbar-default navBg">
    <div class="container">
        <div class="navbar-header">
            <button materialType="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<%=ROOT%>"><img src="https://image.flaticon.com/icons/svg/149/149412.svg"
                                                        height="20" width="20"> </a>
        </div>
        <div class="container">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<%=ROOT%>">Home</a>
                    </li>
                    <li>
                        <a href="<%=ROOT%>carport/all">Store</a>
                    </li>
                    <% if (loggedUser == null) {%>
                    <li>
                        <a href="<%=ROOT%>sign/up">Register</a>
                    </li>
                    <li>
                        <a href="<%=ROOT%>sign/in">Login</a>
                    </li>
                    <% } else {%>

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                           aria-expanded="false">
                            Assembly Material<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=ROOT%>assembly-material">List</a></li>
                            <li><a href="<%=ROOT%>assembly-material/add">Add</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                            Roof tiles<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=ROOT%>roof-tile">List</a></li>
                            <li><a href="<%=ROOT%>roof-tile/add">Add</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                        Materials<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                          <li><a href="<%=ROOT%>material">List</a></li>
                          <li><a href="<%=ROOT%>material/add">Add</a></li>
                      </ul>
                    </li>
                    <% }%>
                    <li>
                        <% if (request.getAttribute("alerts") != null) {%>
                        ${alerts}
                        <% } %>
                    </li>

                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <% if (cart.getNumberOfItems() > 0) {%>
                    <li>
                        <a href="<%=ROOT%>cart">
                            <%= cart.getNumberOfItems() %>
                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                            <%= cart.getPrice() %> DKK
                        </a>
                    </li>
                    <% } %>
                    <% if (loggedUser != null) {%>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                            <%=loggedUser.getName()%> <%=loggedUser.getSurname()%><span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=ROOT%>profile/email">Change email</a></li>
                            <li><a href="<%=ROOT%>profile/password">Change password</a></li>
                            <li><a href="<%=ROOT%>order/history">Order history</a></li>
                            <li><a href="<%=ROOT%>sign/out">Logout</a></li>
                        </ul>
                    </li>
                    <% }%>

                </ul>
            </div>
        </div>
    </div>
</nav>