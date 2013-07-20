<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

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
         <a href="http://joshuawyse-messagingsystem.appspot.com">
            <img alt="" src="/resources/images/udacity_logo_50x50.png"></img>
            Udacity Internal Messaging
         </a>
      </h3>
   </div>
   <div id="midder">
      <div class="newUser">
         <form method="POST" action="">
            <h1>Sign Up:</h1>
            <table>
               <!-- First name -->
               <tr>
                  <td class="label">First Name:</td>
               </tr>
               <tr>
                  <td><input id="firstName" name="firstName" type="text" placeholder="" required></td>
               </tr>
               <!-- Last name -->
               <tr>
                  <td class="label">Last Name:</td>
               </tr>
               <tr>
                  <td><input id="lastName" name="lastName" type="text" placeholder="" required></td>
               </tr>
               <!-- User name -->
               <tr>
                  <td class="label">User Name:</td>
               </tr>
               <tr>
                  <td><input id="userName" name="userName" type="text" placeholder="" required></td>
               </tr>
               <!-- Email (optional) -->
               <tr>
                  <td class="label">Email:</td>
               </tr>
               <tr>
                  <td><input id="email" name="email" type="email" placeholder="example@domain.com"></td>
               </tr>
               <!-- Submit button -->
               <tr>
                  <td><input type="submit" value="Sign Up"></td>
               </tr>
               <tr>
                  <td class="error">${error}</td>
               </tr>
            </table>
         </form>
      </div>
   </div>
   <div class="footer">&copy; 2013 Joshua Wyse --- All rights reserved.</div>
</body>
</html>