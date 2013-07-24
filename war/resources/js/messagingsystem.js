/*$(document).ready(function() {
   $('.newUser').magnificPopup({
      type: 'inline',
      preloader: false,
      focus: '#name',

      // When elemened is focused, some mobile browsers in some cases zoom in
      // It looks not nice, so we disable it:
      callbacks: {
         beforeOpen: function() {
            if($(window).width() < 700) {
               this.st.focus = false;
            } else {
               this.st.focus = '#name';
            }
         }
      }
   });
});


$('.open-popup-link').magnificPopup({
  type:'inline',
  midClick: true,
  mainClass: 'custom-popup-class'
  // Optionally pass markup without attaching it to DOM
  items: {
    src: '<div id="popup-with-something" class="mfp-hide"><div class="some-element">Instead of this element you may put anything else and it\'ll scale proportionally (e.g. flash embed object or your custom video player) </div></div>' 
  }
});*/

$(document).ready(function()
{
   $("tr:even").css("background-color", "#D4D4D4");
});


/*
 * Handles displaying the compose section from the inbox
 */
$(document).ready(function(){
   $(".sendMessage h3").click(function(){
     $("form").slideToggle();
   });
   
   /*
    * Handles displaying the message content when clicked on
    */
/*   $(".messages tr").click(function(){
      $(".messages tr p").slideToggle();
    });*/
   
   $(document).ready(function() {
      $("td").click(function() {
          alert("You clicked my <td>!" + $(this).html() + 
                "My TR is:" + $(this).parent("tr").html());
          //get <td> element values here!!??
      });
  });
 });

