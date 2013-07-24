<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>Udacity | Internal Messaging</title>
<link rel="shortcut icon" href="/resources/images/favicon.ico">
<!-- <link rel="stylesheet" type="text/css" href="/resources/css/magnific-popup.css">-->
<link rel="stylesheet" type="text/css" href="/resources/css/messagingsystem.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mobile.css">
<link href='http://fonts.googleapis.com/css?family=Didact+Gothic' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="/resources/js/jquery.easing-1.3.js"></script>
<!-- <script type="text/javascript" src="/resources/js/magnificent.popup-0.9.3.js"></script>-->
<script type="text/javascript" src="/resources/js/messagingsystem.js"></script>
</head>
<body>
   <div class="header">
      <h3>
         <a href="/">
            <img alt="" src="/resources/images/udacity_logo_50x50.png"></img>
            Udacity Internal Messaging
         </a>
      </h3>
   </div>
   <div class="midder">
      <div class="inbox">
         <div class="title">
            <h1>Inbox</h1>
            <h5>
               <sec:authentication property="principal.userName" />
            </h5>
         </div>
         <div class="messages">
            <table>
               <tr>
                  <th>From</th>
                  <th>Subject</th>
                  <th>Message</th>
                  <th>Date</th>
               </tr>
               <c:forEach var="message" items="${messages}">
                  <tr>
                     <td><h4>${message.fromUserName}</h4></td>
                     <td><h4>${message.subject}</h4></td>
                     <td><h4>${message.content}</h4</td>
                     <td><h4>${message.date}</h4></td>
                  </tr>
               </c:forEach>
            </table>
         </div>
         <div class="sendMessage">
            <h3>Compose</h3>
            <form:form id="compose" method="post" modelAttribute="composeForm">
               <fieldset>
                  <!-- To group -->
                  <form:label path="toGroupName">To Group:</form:label>
                  <br />
                  <form:input path="toGroupName" />
                  <form:errors path="toGroupName" cssClass="error" />
                  <br />
               
                  <!-- To user name -->
                  <form:label path="toUserName">To User:</form:label>
                  <br />
                  <form:input path="toUserName" />
                  <form:errors path="toUserName" cssClass="error" />

                  <!-- From user name -->
                  <br /> <label>From:</label> <br /> <input id="readonly" type="text"
                     value="<sec:authentication property="principal.userName" />" readonly
                     style="background-color: #EE7622; text-align: center;">

                  <!-- Subject -->
                  <br />
                  <form:label path="subject">Subject:</form:label>
                  <br />
                  <form:input path="subject" />
                  <form:errors path="subject" cssClass="error" />

                  <!-- Message -->
                  <br />
                  <form:label path="content">Message:</form:label>
                  <br />
                  <form:input path="content" />
                  <form:errors path="content" cssClass="error" />
                  <br /> <input type="submit" value="Send">
               </fieldset>
               <div class="error">${error}</div>
            </form:form>
         </div>
      </div>
   </div>
   <div class="footer">&copy; 2013 Joshua Wyse --- All rights reserved.</div>
</body>
</html>