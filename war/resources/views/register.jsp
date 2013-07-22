<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Udacity | Internal Messaging | Registration</title>
<link rel="shortcut icon" href="/resources/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/messagingsystem.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mobile.css">
<link href='http://fonts.googleapis.com/css?family=Didact+Gothic' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="/resources/js/jquery.easing-1.3.js"></script>
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

   <div id="midder">
      <div class="register">
         <h2>Register for the Messaging System:</h2>
         <form:form id="register" method="post" modelAttribute="registrationForm">
            <br/>
            <fieldset>
               <form:label path="firstName">First Name:</form:label>
               <br />
               <form:input path="firstName" />
               <form:errors path="firstName" cssClass="error" />
               <br />
   
               <form:label path="lastName">Last Name:</form:label>
               <br />
               <form:input path="lastName" />
               <form:errors path="lastName" cssClass="error" />
               <br />
               
               <form:label path="groups">Groups:</form:label>
               <br />
               <form:input path="groups" />
               <form:errors path="groups" cssClass="error" />
               <br />
               <label>User Name:</label>
               <br />
               <input type="text" value="<sec:authentication property="principal.userName" />" readonly style="background-color: #EE7622">
               <br />
            </fieldset>
            <input type="submit" value="Register">
         </form:form>
      </div>
      <div class="footer">&copy; 2013 Joshua Wyse --- All rights reserved.</div>
</body>
</html>
