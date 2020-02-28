'use strict';

$(function() {
  // === Edit functionality - removes artist or song info, and replaces with hidden form ===
  $('.edit-button').click(function(){
    console.log('clicked on edit button');
    $(this).parent().parent().find('.form-to-show').removeAttr('hidden');
    $(this).parent().parent().find('.text-to-hide').hide();
   });

   // === Pop-up boxes for delete buttons ===
   $('.delete-song').click(function(event){
    console.log('clicked on delete button');
    if(confirm("Are you sure you want to DELETE this song?")) {
        console.log("OK chosen");
    } else {
        console.log("cancel chosen");
        event.preventDefault();
    }
   });

      $('.delete-artist').click(function(event){
       console.log('clicked on delete button');
       if(confirm("Are you sure you want to DELETE this artist? All songs associated with this artist will also be deleted!")) {
           console.log("OK chosen");
       } else {
           console.log("cancel chosen");
           event.preventDefault();
       }
      });
})