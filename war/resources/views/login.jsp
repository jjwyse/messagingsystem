<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>Udacity | Internal Messaging</title>
<link rel="shortcut icon" href="/resources/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="/resources/css/magnific-popup.css">
<link rel="stylesheet" type="text/css" href="/resources/css/messagingsystem.css">
<link rel="stylesheet" type="text/css" href="/resources/css/mobile.css">
<link href='http://fonts.googleapis.com/css?family=Didact+Gothic' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="/resources/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="/resources/js/jquery.easing-1.3.js"></script>
<script type="text/javascript" src="/resources/js/magnificent.popup-0.8.7.js"></script>
<script type="text/javascript" src="/resources/js/messagingsystem.js"></script>
</head>
<body>
   <div class="header">
      <h3>
         <a href="http://joshuawyse-messagingsystem.appspot.com">
            <img alt="" src="/resources/images/udacity_logo_50x50.png"></img>
            Udacity Internal Messaging
         </a>
      </h3>
   </div>
   <div id="midder">
      <div class="login">
         <form method="POST">
            <table>
               <tr>
                  <td class="label">Username:</td>
               </tr>
               <tr>
                  <td><input type="text" name="username" value="${username}"></td>
               </tr>
               <tr>
                  <td class="label">Password:</td>
               </tr>
               <tr>
                  <td><input type="password" name="password" value=""></td>
               </tr>
               <tr>
                  <td class="error">${error}</td>
               </tr>
            </table>
         </form>
         
         <div class="newUser">
            <a href="/newUser">New user?</a>
         </div>
      </div>
   </div>
   <div class="footer">&copy; 2013 Joshua Wyse --- All rights reserved.</div>
</body>
</html>