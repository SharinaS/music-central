'use strict';

$(function() {
  // removes artist or song info, and replaces with form for user to submit info
  $('.edit-button').click(function(){
    console.log('clicked on edit button');
    $(this).parent().parent().find('.form-to-show').removeAttr('hidden');
    $(this).parent().parent().find('.text-to-hide').hide();
   });

   // Pop up box when delete button clicked
   $('.delete-button').click(function(event){
    console.log('clicked on delete button');
    if(confirm("Are you sure you want to DELETE?")) {
        console.log("OK chosen");
    } else {
        console.log("cancel chosen");
        event.preventDefault();
    }
   });
})