'use strict';

$(function() {
  // removes artist or song info, and replaces with text fields to fill out
  $('.edit-button').click(function(){
    console.log('clicked on edit button');
//    $(this).parent().parent('text-to-hide').hide();
//    $('.form-to-show').removeAttr('hidden');

    $(this).parent().parent().find('.form-to-show').removeAttr('hidden');
    $(this).parent().parent().find('.text-to-hide').hide();

   });
})

//TODO: Make alert that confirms user wants to delete the artist or song